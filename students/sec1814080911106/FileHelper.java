package helper;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {

    private Context mContext;

    public FileHelper() {
    }

    public FileHelper(Context mContext) {
        super();
        this.mContext = mContext;
    }


    public void save(String filename, String filecontent) throws Exception {

        FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
        output.write(filecontent.getBytes());
        output.close();
    }



    public String read(String filename) throws IOException {

        FileInputStream input = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;

        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }

        input.close();
        return sb.toString();
    }

}