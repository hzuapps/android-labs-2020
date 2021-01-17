package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.hzuapps.androidlabs.R;

public class Information1814080903310Activity extends AppCompatActivity {
    private EditText PersonName;
    private EditText EmailAddress;
    private EditText Phone;
    private Button write;
    private Button read;
    private Context This;

    private TextView viewName;
    private TextView viewPhone;
    private TextView viewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1814080903310);

        PersonName = (EditText)findViewById(R.id.editTextTextPersonName);
        EmailAddress = (EditText)findViewById(R.id.editTextTextEmailAddress);
        Phone = (EditText)findViewById(R.id.editTextPhone);
        read = (Button)findViewById(R.id.read);
        write = (Button)findViewById(R.id.write);

        viewName = (TextView)findViewById(R.id.viewName);
        viewEmail = (TextView)findViewById(R.id.viewEmail);
        viewPhone = (TextView)findViewById(R.id.viewPhone);
    }

    public void onClick(View view){
        String mPersonName = PersonName.getText().toString();
        String mEmailAddress = EmailAddress.getText().toString();
        String mPhone = Phone.getText().toString();

        switch (view.getId()){
            case R.id.write:
                msave(mPersonName,mEmailAddress,mPhone);
                break;
            case R.id.read:
                mread();
                break;
        }
    }

    private void mread(){
        SharedPreferences sp = getSharedPreferences("info",MODE_PRIVATE);
        String mPersonName = sp.getString("1","");
        String mEmailAddress = sp.getString("2","");
        String mPhone = sp.getString("3","");
        PersonName.setText("");
        EmailAddress.setText("");
        Phone.setText("");
        viewName.setText("您的昵称为："+mPersonName);
        viewEmail.setText("您的邮箱为："+mEmailAddress);
        viewPhone.setText("您的电话为："+mPhone);
        //Toast.makeText(this,"昵称为："+mPersonName+"邮箱为："+mEmailAddress+"电话为："+mPhone,Toast.LENGTH_LONG).show();
    }
    private boolean msave(String PersonName,String EmailAddress,String Phone){
        SharedPreferences sp = getSharedPreferences("info",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("1",PersonName);
        edit.putString("2",EmailAddress);
        edit.putString("3",Phone);
        edit.apply();
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        return true;
    }

}
