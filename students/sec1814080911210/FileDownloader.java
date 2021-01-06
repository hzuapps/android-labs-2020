package edu.hzuapps.androidlabs.sec1814080911210;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class FileDownloader {
    public static final String TAG = FileDownloader.class.getSimpleName();
    public static final int MAX_SIZE = 8192;

    // 记录当前下载的URL
    private Set<String> mUrlsInProgress = new HashSet<>();
    private OnImageDownloadListener mImageDownloadListener;

    public FileDownloader(@NonNull OnImageDownloadListener listener) {
        mImageDownloadListener = listener;
    }

    /**
     * 自定义监听器,供外部处理.
     */
    public interface OnImageDownloadListener {
        void onError(String error);

        void onProgressChange(int percent);

        void onComplete(Bitmap bitmap, String imageUrl);
    }

    /**
     * 使用多线程下载文件.
     * @param imageUrl
     * @param displayProgress
     */
    public void download(@NonNull final String imageUrl, final boolean displayProgress) {
        if (mUrlsInProgress.contains(imageUrl)) {
            Log.w(TAG, "该图片已经在下载列表中!");
            return;
        }

        // 启动异步线程下载图片
        new AsyncTask<Void, Integer, Bitmap>() {
            private String error;

            @Override
            protected void onPreExecute() {
                mUrlsInProgress.add(imageUrl);
                Log.d(TAG, "开始下载……");
            }

            @Override
            protected void onCancelled() {
                mUrlsInProgress.remove(imageUrl);
                mImageDownloadListener.onError(error);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                mImageDownloadListener.onProgressChange(values[0]);
            }

            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap bitmap = null;
                HttpURLConnection connection = null;
                InputStream is = null;
                ByteArrayOutputStream out = null;
                try { // 创建连接
                    connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                    if (displayProgress) {
                        connection.connect(); // 建立连接
                        final int length = connection.getContentLength();
                        if (length <= 0) {
                            error = "URL不正确!";
                            this.cancel(true);
                        }
                        is = new BufferedInputStream(connection.getInputStream(), MAX_SIZE);
                        out = new ByteArrayOutputStream();
                        byte bytes[] = new byte[MAX_SIZE];
                        int count;
                        long read = 0;
                        while ((count = is.read(bytes)) != -1) {
                            read += count;
                            out.write(bytes, 0, count);
                            publishProgress((int) ((read * 100) / length));
                        }
                        bitmap = BitmapFactory.decodeByteArray(out.toByteArray(), 0, out.size());
                    } else {
                        is = connection.getInputStream();
                        bitmap = BitmapFactory.decodeStream(is);
                    }
                } catch (Throwable e) {
                    if (!this.isCancelled()) {
                        error = "网络错误!";
                        this.cancel(true);
                    }
                } finally {
                    try {
                        if (connection != null)
                            connection.disconnect();
                        if (out != null) {
                            out.flush();
                            out.close();
                        }
                        if (is != null)
                            is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                if (result == null) {
                    Log.e(TAG, "下载结果为空!");
                    mImageDownloadListener.onError("文件无法解码!");
                } else {
                    Log.d(TAG, "下载完成,大小为 " + result.getByteCount());
                    mImageDownloadListener.onComplete(result, imageUrl);
                }
                mUrlsInProgress.remove(imageUrl);
                System.gc();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }


    // 将下载的文件保存到磁盘中
    public interface OnBitmapSaveListener {
        void onBitmapSaved();
        void onBitmapSaveError(String error);
    }
    // 声明为静态方式,直接使用.
    public static void writeToDisk(@NonNull final File imageFile, @NonNull final Bitmap image,
                                   @NonNull final OnBitmapSaveListener listener,
                                   @NonNull final Bitmap.CompressFormat format, boolean shouldOverwrite) {

        if (imageFile.isDirectory()) {
            listener.onBitmapSaveError("存在同名目录!");
            return;
        }

        if (imageFile.exists()) {
            if (!shouldOverwrite) {
                listener.onBitmapSaveError("文件已存在!");
                return;
            } else if (!imageFile.delete()) {
                listener.onBitmapSaveError("无法删除原始同名文件!");
                return;
            }
        }

        File parent = imageFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            listener.onBitmapSaveError("无法创建上级目录!");
            return;
        }

        try {
            if (!imageFile.createNewFile()) {
                listener.onBitmapSaveError("无法创建文件!");
                return;
            }
        } catch (IOException e) {
            listener.onBitmapSaveError("写入文件失败!");
            return;
        }

        new AsyncTask<Void, Void, Void>() {

            private String error;

            @Override
            protected Void doInBackground(Void... params) {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(imageFile);
                    image.compress(format, 100, fos);
                } catch (IOException e) {
                    error = "写入文件失败!";
                    this.cancel(true);
                } finally {
                    if (fos != null) {
                        try {
                            fos.flush();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onCancelled() {
                listener.onBitmapSaveError(error);
            }

            @Override
            protected void onPostExecute(Void result) {
                listener.onBitmapSaved();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
