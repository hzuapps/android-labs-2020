package edu.hzuapps.androidlabs.net1814080903334;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.view.View.*;


public class NetActivity extends AppCompatActivity {

    private Button download=null;
    private EditText url=null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.download=(Button) this.findViewById(R.id.button1);
        this.url=(EditText) this.findViewById(R.id.editText1);

        this.download.setOnClickListener(new ClickListener());
    }

    private  final class ClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            String httpUrl=url.getText().toString();
            try
            {
                //创建一个URL对象
                URL url=new URL(httpUrl);
                //下载数据的方法
                DownLoad(url);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


        public void DownLoad(final URL url)
        {

            //开启线程下载数据
                new Thread(new Runnable()
                        {
                            public void run()
                            {
                                try
                                {
                                    Thread.sleep(2000);
                                    //获取SDCard的路径
                                    String path=Environment.getExternalStorageDirectory().getAbsolutePath().toString();
                                    //新建文件
                                    File file=new File(path+"/Mp3");
                                    //判段文件是否存在
                                    if(!file.exists())
                                    {
                                        //创建目录
                                        file.mkdir();
                                    }
                                    //创建文件，并起名为a.mp3
                                    File files=new File(file.getAbsolutePath(),"a.mp3");
                                    @SuppressWarnings("resource")
                                    //用来保存读取到的网络数据，保存到文件中
                                    FileOutputStream  fileoutputstream=new FileOutputStream(files) ;
                                    //获取httpURLConnection
                                    HttpURLConnection http=(HttpURLConnection) url.openConnection();
                                    //设置请求方式
                                    http.setRequestMethod("GET");
                                    //设置连接超时时间
                                    http.setConnectTimeout(5000);
                                    //如果连接成功读取网络数据
                                    if(http.getResponseCode()==200)
                                    {
                                        //得到HttpURLConnection的输入流对象，用拿来读取网络中的数据
                                        InputStream inputstream=http.getInputStream();
                                        //调用WebTools中的getData方法并得到数据
                                        byte[] data=WebTools.getData(inputstream);
                                        //把数据写入到文件中
                                        fileoutputstream.write(data);
                                        System.out.println("下载成功");
                                    }

                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                            }

                        }).start();


                }

    }

}