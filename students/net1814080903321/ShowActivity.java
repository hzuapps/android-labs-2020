package edu.hzuapp.androidlabs.net1814080903321;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void myclick(View v){
        switch (v.getId ()){
            case R.id.kaonai:
                showSingleDialog1();
                break;
            case R.id.fan:
                showSingleDialog2();
                break;
            case R.id.hanbao:
                showSingleDialog3();
                break;
            case R.id.roujuan:
                showSingleDialog4();
                break;
        }
    }

    int ide = 0;  //全局变量
    private void showSingleDialog1() {
        final String[] guige = {"无糖","半塘" ,"全糖"};
        final AlertDialog.Builder dialog = new AlertDialog.Builder (this)
                .setTitle ("请选择规格:")
                .setSingleChoiceItems (guige, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (ShowActivity.this,"你选择了："+guige[ide],Toast.LENGTH_LONG).show ();
                        Intent i = new Intent(ShowActivity.this, PersonalDetailsActivity.class);
                        startActivity(i);
                    }
                });

        dialog.show ();
    }

    private void showSingleDialog2() {
        final String[] guige = {"大份","中份" ,"小份"};
        final AlertDialog.Builder dialog = new AlertDialog.Builder (this)
                .setTitle ("请选择规格:")
                .setSingleChoiceItems (guige, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (ShowActivity.this,"你选择了："+guige[ide],Toast.LENGTH_LONG).show ();
                        Intent i = new Intent(ShowActivity.this, PersonalDetailsActivity.class);
                        startActivity(i);
                    }
                });

        dialog.show ();
    }

    private void showSingleDialog3() {
        final String[] guige = {"不辣","微辣" ,"香辣"};
        final AlertDialog.Builder dialog = new AlertDialog.Builder (this)
                .setTitle ("请选择规格:")
                .setSingleChoiceItems (guige, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (ShowActivity.this,"你选择了："+guige[ide],Toast.LENGTH_LONG).show ();
                        Intent i = new Intent(ShowActivity.this, PersonalDetailsActivity.class);
                        startActivity(i);
                    }
                });

        dialog.show ();
    }

    private void showSingleDialog4() {
        final String[] guige = {"大份","中份" ,"小份"};
        final AlertDialog.Builder dialog = new AlertDialog.Builder (this)
                .setTitle ("请选择规格:")
                .setSingleChoiceItems (guige, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (ShowActivity.this,"你选择了："+guige[ide],Toast.LENGTH_LONG).show ();
                        Intent i = new Intent(ShowActivity.this, PersonalDetailsActivity.class);
                        startActivity(i);
                    }
                });

        dialog.show ();
    }

}