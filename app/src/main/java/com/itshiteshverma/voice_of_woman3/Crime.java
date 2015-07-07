package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hitesh Verma on 6/30/2015.
 */
public class Crime extends Activity implements View.OnClickListener {
    int id[] ={R.id.bfemalefeo,R.id.bEvetea,R.id.bAcid,R.id.bdowry,R.id.bMolestation};
    Button back , image ;
    GridLayout gl;
    LinearLayout l1;
    TextView ti;
    Animation animAlpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crime);
        gl = (GridLayout) findViewById(R.id.GridLayout);
        ti = (TextView) findViewById(R.id.Title);
        back = (Button) findViewById(R.id.bBack);
        image = (Button) findViewById(R.id.bImage);
        image.setOnClickListener(this);
        back.setOnClickListener(this);
        back.setVisibility(View.INVISIBLE);
        l1 = (LinearLayout) findViewById(R.id.Linear);
        for( int x :id){

            View v = (View) findViewById(x);
            v.setOnClickListener(this);
        }

        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);  //initilizing the animation

    }


    //Hndler is the part of the thread .. and handle it
    Handler handler = new Handler() { //alwasy import   android.os.Handler
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            gl.setVisibility(View.GONE);
            ti.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
            l1.setBackgroundResource(R.drawable.crime);
            back.setVisibility(View.VISIBLE);
            back.setGravity(Gravity.CENTER);
        }
    };



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bfemalefeo:

                String si ="Female infanticide is one of the issues that are gaining much prominence from all quarters these days, but a recent report in one of the leading national dailies about a baby girl abandoned in a dustbin came as a shock,yet again.\n" +
                        "\n" +
                        "One tends to question, what effect do the media awareness programs and different initiatives taken by the government and non-government organizations really have? Are they really effective in bringing about any change in the outlook of the society?\n" +
                        "Reasons for selective abortions are many, from carrying the family name forward, lighting the funeral pyre to hoping for a male breadwinner in the family. But the reason, which tops the list, is dowry - a price paid by the parents to marry off their daughters.\n" +
                        "\n" +
                        "\n";


                String title = "Female Foeticide";
                Intent intent = new Intent(Crime.this,Custom.class);
                intent.putExtra("Text", si);
                intent.putExtra("Title", title);
                startActivity(intent);
                break;

            case R.id.bdowry:

                String si1 ="The practice of a woman giving a \"dowry\" or gift to a man at *marriage is said to have had its origins in the system of streedhan (woman's share of parental wealth given to her at the time of her marriage). As a woman had no right to inherit a share of the ancestral property, streedhan was seen as a way by which the family ensured that she had access to some of its wealth. There is no clear proof as to when this practice was first started in India,\n" +
                        "\n" +
                        "Dowry though illegal in India, but the law is almost universally ignored. For poor and middle class families it is a burden, which they are forced to bear. \n" +
                        "\n" +
                        " The police department specifically should be dealt with strictly and made corruption free. At times when the FIRs are filed by the girls family against her husband and in-laws for dowry related atrocities, the grooms family manages to bribe the police and make an easy escape.\n" +
                        "\n"
                        ;

                        String title1 = "Dowry";
                Intent intent1 = new Intent(Crime.this,Custom.class);
                intent1.putExtra("Text",si1);
                intent1.putExtra("Title",title1);
                startActivity(intent1);

                break;
            case R.id.bEvetea:

                String si2 ="Women have landed on the moon. Reached for the stars and touched them. They have proved themselves equal to men in every way. Yet every 5 minutes a woman is sexually harassed. Every 2 minutes one woman is molested. Eve teasing is something that she has to contend with everyday.\n" +
                        "\n" +
                        " \tWell, most women are of the opinion that they have to equip themselves to handle the situation efficiently. According to most learning, an art of self-defence is the best way. Hence, martial arts training centres have mushroomed in the cities. Many times, it is found that women are blamed for becoming victims of eve teasers. \"The woman must have asked for it\" or \"she is dressed to invite trouble. It is important that our girls be brought up with enough self-esteem to deal with comments like this.\n";
                String title2 = "Eve Teasing";
                Intent intent2 = new Intent(Crime.this,Custom.class);
                intent2.putExtra("Text",si2);
                intent2.putExtra("Title",title2);
                startActivity(intent2);

                break;

            case R.id.bAcid:

                String si3 ="When acid is thrown on a person, the results can be horrifying. Nitric, hydrochloric, or sulfuric acids all have a catastrophic effect on human flesh. It causes the skin tissue to melt, often exposing the bones below the flesh, sometimes even dissolving the bone. When acid attacks the eyes, it damages these vital organs permanently. Many acid attack survivors have lost the use of one or both eyes. The victim is traumatized physically, psychologically and socially.\n" +
                        "\n" +
                        " \tThe victims are attacked for many reasons. In some cases, the attack takes place because a young girl or woman has spurned the sexual advances of a male or has rejected a proposal of marriage. Recently, however, there have been acid attacks on children, older women and sometimes also men. These attacks are often the result of family or land disputes, dowry demands or a desire for revenge.  \n" +
                        "\n" +
                        " \tReasons for acid attacks during the years, the highest rate of occurrence took place over Land Disputes and Family dispute, the next highest rate of these brutal incidents are due to refusal of relationship/sex throughout the country. \n";

                        String title3 = "Acid Attacks";
                Intent intent3 = new Intent(Crime.this,Custom.class);
                intent3.putExtra("Text",si3);
                intent3.putExtra("Title",title3);
                startActivity(intent3);

                break;

            case R.id.bMolestation:

                String si4 ="Any form of sexual violation that does not fall within the narrow ambit of the offence of rape falls under Sections 354 and 509 of the IPC. Even though these sections intend to protect womens modesty, the IPC nowhere defines what constitutes modesty. Since the understanding of modesty is moralistically constructed, the Section can get subjectively interpreted to apply to only certain kinds of women (chaste, sexually innocent/passive, etc) who can be said to be the sole possessors of modesty";
                String title4 = "Molestation";
                Intent intent4 = new Intent(Crime.this,Custom.class);
                intent4.putExtra("Text",si4);
                intent4.putExtra("Title",title4);
                startActivity(intent4);

                break;

            case R.id.bImage:

                v.startAnimation(animAlpha);
                // for animation (V is the View For the animation)
                // it will open the activity after some delay .. good to see the animations


//making a child thread

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        long futureTime = System.currentTimeMillis() + 600; //all this code  will wait for 10 sec
                        while (System.currentTimeMillis() < futureTime) {
                            synchronized (this) {
                                try {
                                    wait(futureTime - System.currentTimeMillis());  /// subtracting
                                } catch (Exception e) {

                                }
                            }
                            handler.sendEmptyMessage(0); // calls the handler to handle the thread
                        }
                    }
                };

                // WE NEED A HADLER TO MANUPILATE THE VIEW INSIDE A THREAD
                Thread hitThread = new Thread(r); // runnig the thread
                hitThread.start(); //start the thread




                break;

            case R.id.bBack:
                gl.setVisibility(View.VISIBLE);
                ti.setVisibility(View.VISIBLE);
                v.setVisibility(View.VISIBLE);
                l1.setBackgroundResource(R.drawable.back);
                back.setVisibility(View.INVISIBLE);
                image.setVisibility(View.VISIBLE);

                break;
        }
    }
}
