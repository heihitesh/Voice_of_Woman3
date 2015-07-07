package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class MainActivity extends Activity implements View.OnClickListener {

    public static String filename = "MySharedString";  //static means that the file name will not change
    SharedPreferences someData;
    LinearLayout main_view;
    private ViewFlipper viewFlipper, flip;
    private float lastX;
    Button bi, Home, Extra, Phone, Crime, Where;
    TextView Name, UserName;
    ImageView Fwd, Back;
    Animation animAlpha;
    TextView About;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_view = (LinearLayout) findViewById(R.id.MainId);
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);

        someData = getSharedPreferences(filename, 0);

        //second param is the default loader

      loadbackground();
        intilize();
        flipper();


    }


    private void flipper() {
        flip = (ViewFlipper) findViewById(R.id.viewFlipper);
        flip.setOnClickListener(this);
        flip.setFlipInterval(4000);  //this will automatically flip after 1 sec
        flip.showNext();
        flip.startFlipping();
    }


    private void intilize() {
        Home = (Button) findViewById(R.id.bHome);
        Extra = (Button) findViewById(R.id.bExtra);
        Back = (ImageView) findViewById(R.id.ivBack);
        Fwd = (ImageView) findViewById(R.id.ivFwd);
        Phone = (Button) findViewById(R.id.bPhone);
        Crime = (Button) findViewById(R.id.bCrimes);
        Name = (TextView) findViewById(R.id.tvname);
        UserName = (TextView) findViewById(R.id.tvuname);
        Where = (Button) findViewById(R.id.bWhere);
        Where.setOnClickListener(this);
        //setting the name and Username from the Login Activity
        String name = getIntent().getStringExtra("Name");
        String uname = getIntent().getStringExtra("UserName");
        Name.setText(name);
        UserName.setText(uname);
        About = (TextView) findViewById(R.id.tvAbout);

        String about = "violence against women is a manifestation of historically unequal power relations between men and women and that violence against women is one of the crucial social mechanisms by which women are forced into a subordinate position compared with men.\n" +
                "violence against women is understood as a violation of human rights and a form of discrimination against women and shall mean all acts of gender-based violence that result in, or are likely to result in, physical, sexual, psychological or economic harm or suffering to women, including threats of such acts, coercion or arbitrary deprivation of liberty, whether occurring in public or in private life\n" +
                "Violence against women can fit into several broad categories. These include violence carried out by individuals as well as states. Some of the forms of violence perpetrated by individuals are rape; domestic violence; sexual harassment\n" +
                "The aim of our website is to spread awareness among the women against the various acts of crime and violence against them so that they can stand up for their rights and bring a change in the mindset of people and society\n";

        About.setText(about);

        Phone.setOnClickListener(this);
        Back.setOnClickListener(this);
        Fwd.setOnClickListener(this);
        Home.setOnClickListener(this);
        Extra.setOnClickListener(this);
        Crime.setOnClickListener(this);

        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim);  //initilizing the animation

    }

    private void loadbackground() {
        someData = getSharedPreferences(filename, 0);
        String dataReturn = someData.getString("sharedString", "Could not Load ");
        //first param is the open the string form the putString (Line no -58 )
        //and the second param is the default string . when it is unable to find sharedString

        if (dataReturn.equals("pic")) {
            main_view.setBackgroundResource(R.drawable.pic);

        } else if (dataReturn.equals("pic_one")) {
            main_view.setBackgroundResource(R.drawable.pic_one);

        } else if (dataReturn.equals("pic_two")) {
            main_view.setBackgroundResource(R.drawable.pic_two);

        } else {
            main_view.setBackgroundResource(R.drawable.back);

        }
    }




    @Override
    //This method gona a start the Menu options when menu or setting button is clicked  ..cool_menu.xml
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        //delete the return form the super
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return true;
        //it will return true because it hava boolean return type
    }

    @Override
    //this
    public boolean onOptionsItemSelected(MenuItem item) {
        //no need to return the super value
        switch (item.getItemId()) {
            case R.id.aboutUS:
                Intent i = new Intent("com.itshiteshverma.travis01.About");
                startActivity(i);
                break;
            case R.id.preferences:
                Intent p = new Intent(MainActivity.this,Prefs.class);
                startActivity(p);
                break;

            case R.id.exit:
                Intent e = new Intent("com.itshiteshverma.travis01.Exit");
                startActivity(e);
                //finish(); //close our app
                break;
            case R.id.dexit:
                Toast.makeText(this, "GOOD BYE !!", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
        return false;//if none of them a choosen it will return false
    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override //Edited by me // called when menu items is selected
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.menu_red:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else
                    item.setChecked(true);
                main_view.setBackgroundResource(R.drawable.pic);


                //
                String stringData = "pic";

                //saving the string
                SharedPreferences.Editor editor = someData.edit();
                editor.putString("sharedString", stringData);
                editor.commit(); //finilizing the editor

                return true; // dont use break

            case R.id.menu_green:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else
                    item.setChecked(true);
                main_view.setBackgroundResource(R.drawable.pic_one);

                //
                String stringData2 = "pic_one";

                //saving the string
                SharedPreferences.Editor editor1 = someData.edit();
                editor1.putString("sharedString", stringData2);
                editor1.commit(); //finilizing the editor


                return true;
            case R.id.menu_yellow:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else
                    item.setChecked(true);
                main_view.setBackgroundResource(R.drawable.pic_two);

                //
                String stringData3 = "pic_two";

                //saving the string
                SharedPreferences.Editor editor2 = someData.edit();
                editor2.putString("sharedString", stringData3);
                editor2.commit(); //finilizing the editor


                return true;
            case R.id.menu_mypic:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else
                    item.setChecked(true);
                main_view.setBackgroundResource(R.drawable.back);

                String stringData4 = "back";

                //saving the string
                SharedPreferences.Editor editor3 = someData.edit();
                editor3.putString("sharedString", stringData4);
                editor3.commit(); //finilizing the editor


                return true;
            default:
                return super.onOptionsItemSelected(item); // when none of the oprions are selected //whithout erros
        }
    }
/////////////////////////////////////////////////////////////////////////////////////
    //for the slide show
   /* public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();

                if (lastX < currentX) {

                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_left);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                    if (viewFlipper.getDisplayedChild() == 3)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_right);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                    // Show the next Screen
                    viewFlipper.showNext();
                }
                break;
            }
        }
        return false;
    }
*/
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewFlipper:
                flip.showNext(); //show the next button or text when clicked flipper
                break;
            case R.id.ivBack:

                if (viewFlipper.getDisplayedChild() == 0)
                    break;

                viewFlipper.setInAnimation(this, R.anim.in_from_left);
                viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                // Show The Previous Screen
                viewFlipper.showPrevious();

                break;

            case R.id.ivFwd:

                if (viewFlipper.getDisplayedChild() == 6)
                    break;

                viewFlipper.setInAnimation(this, R.anim.in_from_right);
                viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                // Show the next Screen
                viewFlipper.showNext();

                break;

            case R.id.bPhone:
/*
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:100"));
                startActivity(callIntent);


*/
                v.startAnimation(animAlpha);
                // for animation (V is the View For the animation)
                // it will open the activity after some delay .. good to see the animations
                Thread phone = new Thread() {
                    public void run() {
                        try {
                            sleep(605);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Intent OpenMainActivity = new Intent("com.itshiteshverma.voice_of_woman3.Phone");
                            startActivity(OpenMainActivity);
                        }
                    }

                };
                phone.start();

                break;

            case R.id.bExtra:

                v.startAnimation(animAlpha);
                // for animation (V is the View For the animation)
                // it will open the activity after some delay .. good to see the animations
                Thread extra = new Thread() {
                    public void run() {
                        try {
                            sleep(605);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Intent OpenMainActivity = new Intent(MainActivity.this, ExtraThings.class);
                            startActivity(OpenMainActivity);
                        }
                    }

                };
                extra.start();
                break;

            case R.id.bHome:

                v.startAnimation(animAlpha);
                // for animation (V is the View For the animation)
               Toast.makeText(this,"You Are At Home",Toast.LENGTH_SHORT).show();
                break;

            case R.id.bCrimes:

                v.startAnimation(animAlpha);
                // for animation (V is the View For the animation)
                // it will open the activity after some delay .. good to see the animations
                Thread crime = new Thread() {
                    public void run() {
                        try {
                            sleep(605);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Intent OpenMainActivity = new Intent("com.itshiteshverma.voice_of_woman3.Crime");
                            startActivity(OpenMainActivity);
                        }
                    }

                };
                crime.start();
                break;

            case R.id.bWhere:

                Intent intent = new Intent(MainActivity.this, WhereDialog.class);
                startActivity(intent);

                break;
        }
    }
}

