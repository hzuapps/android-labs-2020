

        package edu.hzuapps.androidlabs.net1814080903136;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        public class Edit1814080903136Activity extends AppCompatActivity {

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_edit_1814080903136);
                        final  Edit1814080903136Activity thisActivity = this;

                        Button btncut =(Button) findViewById(R.id.button_com);

                        btncut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                        Intent intent = new Intent(thisActivity, Compound1814080903136Activity.class);
                                        thisActivity.startActivity(intent);
                                }
                        });
                }
        }
