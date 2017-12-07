package com.example.user.curiositybleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jordan on 01/12/17.
 */

public class TestScreen extends AppCompatActivity {

    Button mButton;
    Intent mIntent;
    float[] test = new float[]{0,1,2,3,4,5,6,7,8,9,10};

    String mStringFromBLE = "DataBLE";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_screen);

        mButton = (Button) findViewById(R.id.button_test);

        mIntent = new Intent(this,LineChartActivity.class);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mIntent.putExtra(mStringFromBLE,test);
                startMain();
            }
        });

    }
    public void startMain(){
        startActivity(mIntent);
        finish();
    }

}
