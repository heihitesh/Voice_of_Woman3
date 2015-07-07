package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Hitesh Verma on 6/30/2015.
 */
public class Custom  extends Activity implements View.OnClickListener {

    TextView text,title;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom);
        text = (TextView) findViewById(R.id.tvText);
        title = (TextView) findViewById(R.id.tvTitle);
        back = (Button) findViewById(R.id.bBack);
        back.setOnClickListener(this);

        Bundle maindata = getIntent().getExtras();//get the info form the main Activity
        String got = maindata.getString("Text");
        String got2 = maindata.getString("Title");


        text.setText(got);
        title.setText(got2);


    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
