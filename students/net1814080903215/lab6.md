# 一、实验目的

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

# 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5.将应用运行结果截图。

# 三、实验步骤

1. 呼叫照相方法

2. 调用相机模块

   ```
    private void captureImage() {
            // Create an implicit intent, for image capture.
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            // Start camera and wait for the results.
            this.startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
        }
   ```
   
3. 存储相片略缩图
   ```
          protected void onActivityResult(int requestCode, int resultCode, Intent data) {//调用完相机并拍照后会执行
            //第二个 Activity 指定的结果代码。
            // 如果操作成功，此为 RESULT_OK；如果用户退出或操作出于某种原因失败，则是 RESULT_CANCELED
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
                if (resultCode == RESULT_OK) {
                    //请求使用照相，而且用户同意使用相机权限
                    Bitmap bp = (Bitmap) data.getExtras().get("data");
                    //得到intent返回的信息
                    //保存图片等信息
                    this.imageView.setImageBitmap(bp);
                    //设置照片成果

                    save(bp);
                    //调用创建文件

                } else if (resultCode == RESULT_CANCELED) {
                    //用户不授权使用照相机
                    Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
                    //不授权使用相机和请求码不是request image
                }

            }

        }

        private void save(Bitmap bp) {

            File Pdirectory = new File(Environment.getExternalStorageDirectory()+File.separator+"草泥马");

            Random generator = new Random();
            int n = 10000;
            n = generator.nextInt(n);
            String fname = "Image-" + n + ".jpg";
            File file = new File(Pdirectory,fname);
            //在目录下添加东西
            Pdirectory.mkdirs();
            //创建目录

            try{
                FileOutputStream out = new FileOutputStream(file);
                bp.compress(Bitmap.CompressFormat.JPEG,100,out);
                out.flush();
                out.close();
                //compress(Bitmap.CompressFormat format, int quality, OutputStream stream)

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
   ```

# 四、实验结果

 ![实验截图](https://raw.githubusercontent.com/Deng-dong555/android-labs-2020/master/students/net1814080903215/lab6_pic.jpg)

# 五、实验心得

这次实验未用到网络编程，而是完善更新了我的APP的界面设计显示，以及添加了一个简易的调用系统相机拍照并且显示略缩图的功能，和一个调用系统相册的功能。
调试的时候就遇到很多未接触的点，需要通过百度学习不同的知识完善自己的APP。

