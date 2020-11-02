package edu.hzuapps.androidlabs.net1814080903113;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class Net1814080903113PhotoShowActivity extends AppCompatActivity {

    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1814080903113photoshow);

        cardView = (CardView)findViewById(R.id.aquacardview);

        cardView.setRadius(8);

        cardView.setCardElevation(8);

        cardView.setContentPadding(5,5,5,5);
    }
}
