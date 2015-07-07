package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Hitesh Verma on 7/2/2015.
 */
public class WhereDialog extends Activity implements View.OnClickListener {
    Button Map;
    EditText etLong, etLati;
    GPSTracker gps;
    Intent intent = null;
    Intent chooser = null;
    EditText Lat, Long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.where_dialog);
        Map = (Button) findViewById(R.id.bOpenMap);
        Map.setOnClickListener(this);
        etLong = (EditText) findViewById(R.id.etLong);
        etLati = (EditText) findViewById(R.id.etetLat);


        gps = new GPSTracker(WhereDialog.this);

        // check if GPS enabled
        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line

            //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();

            String lat = String.valueOf(latitude);
            String lon = String.valueOf(longitude);


            etLong.setText(lat);
            etLati.setText(lon);


        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bOpenMap:
                // show location when activity opened


                intent = new Intent(android.content.Intent.ACTION_VIEW);

                String la = etLati.getText().toString();
                String lo = etLong.getText().toString();

                intent.setData(Uri.parse("geo:"+lo+","+la));
                Toast.makeText(this,"Openning map: Latitude-"+la+"\n Longitude-"+lo+".",Toast.LENGTH_SHORT).show();
                chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);


                break;
        }


    }
}
