package edu.hzuapps.androidlabs.sec1814080911102.fruit;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.hzuapps.androidlabs.sec1814080911102.R;

/*
*Fruit_item.xml的activity，本来是想通过上面的button实现TextView文本的加删除线和删除效果的，但是失败了
* 暂时不知道从何下手，网上方法很复杂，没看懂，以后再尝试
*/

public class FruitItem extends AppCompatActivity {

    private TextView fruittext ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_item);

        fruittext=(TextView)findViewById(R.id.fruit_text);
        Button done = (Button) findViewById(R.id.button_item_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruittext.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    }
}
