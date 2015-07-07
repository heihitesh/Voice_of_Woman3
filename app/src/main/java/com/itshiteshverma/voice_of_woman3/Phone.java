package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

public class Phone extends Activity implements SlidingDrawer.OnDrawerOpenListener, SlidingDrawer.OnDrawerCloseListener, AdapterView.OnItemClickListener, View.OnClickListener {
    GridView grid;
    int idlist[] = {R.id.bPMummy, R.id.bMMummy, R.id.bPPapa, R.id.bMPapa, R.id.bPOther, R.id.bMOther};
    EditText Mummy, Papa, Other;
    SlidingDrawer sd;
    GPSTracker gps;
    Intent intent = null;
    Intent chooser = null;
    String[] web = {
            "Police",
            "Delhi Police",
            "Women HelpLine",
            "Delhi Metro HelpLine",
            "Transportation HelpLine",
            "Child HelpLine HelpLine",
            "Railways Helpline",
            "Government Helpline",
            "Consumer Helpline",

    };
    int[] imageId = {
            R.drawable.police,
            R.drawable.delhi_police,
            R.drawable.woman_helpline,
            R.drawable.metro,
            R.drawable.transport,
            R.drawable.child,
            R.drawable.train,
            R.drawable.imgres,
            R.drawable.consumer,



    };

    String lat,lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        // for the slider

        for (int id : idlist) {
            View v = (View) findViewById(id);
            v.setOnClickListener(this);
        }
        Mummy = (EditText) findViewById(R.id.etMummy);
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (!TextUtils.isEmpty(restoredText)) {
            Mummy.setText(restoredText);
        }

        Papa = (EditText) findViewById(R.id.etPapa);
        SharedPreferences prefs2 = getPreferences(MODE_PRIVATE);
        String restoredText2 = prefs2.getString("text2", null);
        if (!TextUtils.isEmpty(restoredText2)) {
            Papa.setText(restoredText2);
        }

        Other = (EditText) findViewById(R.id.etOther);
        SharedPreferences prefs3 = getPreferences(MODE_PRIVATE);
        String restoredText3 = prefs3.getString("text3", null);
        if (!TextUtils.isEmpty(restoredText3)) {
            Other.setText(restoredText3);
        }


        sd = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        sd.setOnDrawerOpenListener(this);
        sd.setOnDrawerCloseListener(this);

        CustomGrid adapter = new CustomGrid(Phone.this, web, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);

        // to get the current location

        gps = new GPSTracker(Phone.this);

        // check if GPS enabled
        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line

            //Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();

             lat = String.valueOf(latitude);
             lon = String.valueOf(longitude);



        } else {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            Toast.makeText(this,"Cant get Your Location",Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("text", Mummy.getText().toString());
        editor.commit();


        SharedPreferences.Editor editor2 = getPreferences(MODE_PRIVATE).edit();
        editor2.putString("text2", Papa.getText().toString());
        editor2.commit();


        SharedPreferences.Editor editor3 = getPreferences(MODE_PRIVATE).edit();
        editor3.putString("text3", Other.getText().toString());
        editor3.commit();


    }

    @Override
    public void onDrawerOpened() {
        grid.setVisibility(View.GONE);
    }

    @Override
    public void onDrawerClosed() {
        grid.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: //police
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String call = "100";
                callIntent.setData(Uri.parse("tel:" + call));
                startActivity(callIntent);

                break;
            case 1: //Delhi Police
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                String call1 = "1093";
                callIntent1.setData(Uri.parse("tel:" + call1));
                startActivity(callIntent1);

                break;
            case 2: //womahelpline
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                String call2 = "1091";
                callIntent2.setData(Uri.parse("tel:" + call2));
                startActivity(callIntent2);

                break;
            case 3://metro
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent3 = new Intent(Intent.ACTION_CALL);
                String call3 = "155363";
                callIntent3.setData(Uri.parse("tel:" + call3));
                startActivity(callIntent3);

                break;
            case 4: //transport
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent4 = new Intent(Intent.ACTION_CALL);
                String call4 = "9311900800";
                callIntent4.setData(Uri.parse("tel:" + call4));
                startActivity(callIntent4);

                break;
            case 5: //childhelpline
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent5 = new Intent(Intent.ACTION_CALL);
                String call5 = "1098";
                callIntent5.setData(Uri.parse("tel:" + call5));
                startActivity(callIntent5);

                break;
            case 6: //indian railway
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent6 = new Intent(Intent.ACTION_CALL);
                String call6 = "1800111139";
                callIntent6.setData(Uri.parse("tel:" + call6));
                startActivity(callIntent6);

                break;
            case 7: // govt
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent7 = new Intent(Intent.ACTION_CALL);
                String call7 = "01127357169";
                callIntent7.setData(Uri.parse("tel:" + call7));
                startActivity(callIntent7);

                break;
            case 8:// consumer
                Toast.makeText(Phone.this, "Calling " + web[+position], Toast.LENGTH_SHORT).show();
                Intent callIntent8 = new Intent(Intent.ACTION_CALL);
                String call8 = "1800114000";
                callIntent8.setData(Uri.parse("tel:" + call8));
                startActivity(callIntent8);

                break;


        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bPMummy: //need user permission
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String mum = Mummy.getText().toString();
                callIntent.setData(Uri.parse("tel:" + mum));
                startActivity(callIntent);
                break;
            case R.id.bMMummy://need user permission

                String phoneNo = Mummy.getText().toString();
                String message = "Hei Mummuy I am in an Emergency/Trouble , PLEASE HELP ME !!! \n My Current Location is " +
                        "Longitude: "+lon +","+ "Latitude: "+lat;

                try {
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                    i.putExtra("address", phoneNo);
                    i.putExtra("sms_body", message);
                    i.setType("vnd.android-dir/mms-sms");
                    startActivity(i);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                break;

            case R.id.bPPapa: //need user permission
                Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                String papa = Papa.getText().toString();
                callIntent2.setData(Uri.parse("tel:" + papa));
                startActivity(callIntent2);
                break;
            case R.id.bMPapa://need user permission

                String phoneNo2 = Papa.getText().toString();
                String message2 = "Hei Papa I am in an Emergency/Trouble , PLEASE HELP ME !!! \n My Current Location is " +
                        "Longitude: "+lon +","+ "Latitude: "+lat;

                try {
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                    i.putExtra("address", phoneNo2);
                    i.putExtra("sms_body", message2);
                    i.setType("vnd.android-dir/mms-sms");
                    startActivity(i);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                break;
            case R.id.bPOther: //need user permission
                Intent callIntent3 = new Intent(Intent.ACTION_CALL);
                String other = Other.getText().toString();
                callIntent3.setData(Uri.parse("tel:" + other));
                startActivity(callIntent3);
                break;
            case R.id.bMOther://need user permission

                String phoneNo3 = Other.getText().toString();
                String message3 = "Hei Friend I am in an Emergency/Trouble , PLEASE HELP ME !!! \n My Current Location is " +
                        "Longitude: "+lon +","+ "Latitude: "+lat;
                try {
                    Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                    i.putExtra("address", phoneNo3);
                    i.putExtra("sms_body", message3);
                    i.setType("vnd.android-dir/mms-sms");
                    startActivity(i);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                break;
        }
    }
}