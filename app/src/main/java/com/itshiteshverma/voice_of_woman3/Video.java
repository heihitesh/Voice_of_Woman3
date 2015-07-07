package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Hitesh Verma on 7/1/2015.
 */
public class Video extends Activity {

    VideoView Video1;
    Uri myUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        Video1 = (VideoView) findViewById(R.id.hitVideoView);

        Bundle maindata = getIntent().getExtras();//get the info form the main Activity
        int got = maindata.getInt("Key");
        String button = maindata.getString("Button");


        switch (got){

            case 1:
                 myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nature);  // this will play the video in raw folder
                Toast.makeText(this, "Playing Video :" +button ,Toast.LENGTH_SHORT).show();
                // need permission if using internet
                break;
            case 2:
                myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.women_one);  // this will play the video in raw folder
                Toast.makeText(this, "Playing Video :" +button ,Toast.LENGTH_SHORT).show();
                // need permission if using internet
                break;
            case 3:
                myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.women2);  // this will play the video in raw folder
                Toast.makeText(this, "Playing Video :" +button ,Toast.LENGTH_SHORT).show();
                // need permission if using internet
                break;



        }
        // to control the video like play , pause
        MediaController myControler = new MediaController(this); //always import android.widget.MediaController
        myControler.setAnchorView(Video1); //pass the video view
        Video1.setMediaController(myControler); //this will set the controler
        Video1.setVideoURI(myUri);
        Video1.requestFocus();
        Video1.start();
    }
}
