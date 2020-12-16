package edu.hzuapps.androidlabs.presenter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.hzuapps.androidlabs.R;
import edu.hzuapps.androidlabs.model.ScenesModel;
import edu.hzuapps.androidlabs.view.CreateFragment;

public class CreatePresenter {
    private static CreateFragment fragment= null;
    private static ScenesModel scenesModel = null;
    private static CreatePresenter presenter = new CreatePresenter();


    private CreatePresenter(){}

    public static CreatePresenter getInstance(CreateFragment createFragment){
        fragment = createFragment;
        if(scenesModel==null){
            scenesModel = ScenesModel.getInstance();
        }
        return presenter;
    }

    public void saveScene(){
        ImageView imageView = (ImageView) fragment.getView().findViewById(R.id.createImageView);
        if(imageView.getDrawable()==null){
            Toast.makeText(fragment.getActivity(), "请选择一张图片", Toast.LENGTH_SHORT).show();
        }else{
            saveScene(imageView);
        }
    }

    private void saveScene(ImageView imageView){
        final Bitmap bitmap =((BitmapDrawable)imageView.getDrawable()).getBitmap();
        final EditText editText = new EditText(fragment.getContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getContext());
        builder.setTitle("请输入场景名称（不可包含空格）").setIcon(android.R.drawable.ic_dialog_info).setView(editText).setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String sceneName = null;
                sceneName = editText.getText().toString();
                if(sceneName==null||sceneName.equals("")||sceneName.lastIndexOf(" ")!=-1){
                    Toast.makeText(fragment.getActivity(), "名称不规范", Toast.LENGTH_SHORT).show();
                }
                else {
                    saveScene(bitmap,sceneName);
                }
            }
        });
        builder.show();
    }

    private void saveScene(Bitmap bitmap,String sceneName){
        if(!scenesModel.containsScene(sceneName)){
            if(scenesModel.saveScene(sceneName,bitmap)){
                Toast.makeText(fragment.getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(fragment.getActivity(), "保存失败", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(fragment.getActivity(), "同名场景已存在", Toast.LENGTH_SHORT).show();
        }
    }
}
