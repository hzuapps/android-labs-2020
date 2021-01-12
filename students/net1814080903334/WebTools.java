package edu.hzuapps.androidlabs.net1814080903334;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class WebTools {

    public static byte[] getData(InputStream input) throws Exception
    {
        //存放数据的byte数组
        byte[] buffer=new byte[5000];
        //保存数据的输出流对象
        ByteArrayOutputStream output=new ByteArrayOutputStream();
        int len=0;
        while((len=input.read(buffer))!=-1)
        {
            //写入数据
            output.write(buffer, 0, len);
        }
        //返回输入流中的数据
        return output.toByteArray();

    }
}