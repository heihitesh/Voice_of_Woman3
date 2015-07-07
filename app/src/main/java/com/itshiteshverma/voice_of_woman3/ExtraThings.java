package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;


/**
 * Created by Hitesh Verma on 7/1/2015.
 */
public class ExtraThings extends Activity implements View.OnClickListener {

    Button Video1, Video2, Video3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra);
        Video1 = (Button) findViewById(R.id.bVideo1);
        Video1.setOnClickListener(this);
        Video2 = (Button) findViewById(R.id.bVideo2);
        Video2.setOnClickListener(this);
        Video3 = (Button) findViewById(R.id.bVideo3);
        Video3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bVideo1:

                Intent intentvideo1 = new Intent(ExtraThings.this, Video.class);
                intentvideo1.putExtra("Key", 1);
                intentvideo1.putExtra("Button",Video1.getText().toString());
                startActivity(intentvideo1);

                break;
            case R.id.bVideo2:

                Intent intentvideo2 = new Intent(ExtraThings.this, Video.class);
                intentvideo2.putExtra("Key", 2);
                intentvideo2.putExtra("Button",Video2.getText().toString());
                startActivity(intentvideo2);

                break;
            case R.id.bVideo3:

                Intent intentvideo3 = new Intent(ExtraThings.this, Video.class);
                intentvideo3.putExtra("Key", 3);
                intentvideo3.putExtra("Button",Video3.getText().toString());
                startActivity(intentvideo3);

                break;
        }
    }
}
