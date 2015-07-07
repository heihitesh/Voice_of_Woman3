package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class Login extends Activity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    EditText UserName, Password;
    Button Login, SignUp;
    CheckBox remember;
    DataBaseHelper helper = new DataBaseHelper(this);
    int counter = 4; // for a limited attempt
    SharedPreferences someData, checkbox;
    public static String filename = "MySharedString";


    private final static String TAG = "MainActivity";
    public final static String PREFS = "PrefsFile";

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        initilize();
        rememberdata();

    }

    private void rememberdata() {

        someData = getSharedPreferences(filename, 0);
        String User = someData.getString("UserName", "Could not Load ");
        //first param is the open the string form the putString (Line no -58 )
        //and the second param is the default string . when it is unable to find sharedString
        String Pass = someData.getString("Password", "Could not load ");
        Boolean Check = someData.getBoolean("Check", true);

        UserName.setText(User);
        Password.setText(Pass);
        if (Check.equals(true)) {
            remember.setChecked(true);
        } else if (Check.equals(false)) {
            remember.setChecked(false);

        }

    }

    private void initilize() {
        UserName = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.BLoginIN);
        SignUp = (Button) findViewById(R.id.bSignUp);
        remember = (CheckBox) findViewById(R.id.cbRemember);
        remember.setOnCheckedChangeListener(this);
        Login.setOnClickListener(this);
        SignUp.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BLoginIN:

                String usa = UserName.getText().toString();
                int le = usa.length();

                if (le >= 1) { //is user name is empty

                    String us = UserName.getText().toString();
                    String pass = Password.getText().toString();
                    UserName.setBackgroundColor(Color.TRANSPARENT);
                    Password.setBackgroundColor(Color.TRANSPARENT);

                    String password = helper.searchPass(us); //gettting the pass to check
                    String name = helper.searchName(us); // getting the real name to be displyed if the username ad pass matches

                    //if the password = pass ..means right password acc to the login DATABASE
                    if (password.equals(pass)) {
                        Intent i = new Intent(Login.this, MainActivity.class);
                        i.putExtra("UserName", us); // passing teh text
                        i.putExtra("Name", name);
                        startActivity(i);

                    } else {
                        Toast.makeText(this, "User Name and Password Dont Match ", Toast.LENGTH_SHORT).show();
                        UserName.setBackgroundResource(R.drawable.onwronngclick);
                        Password.setBackgroundResource(R.drawable.onwronngclick);

                        if (counter >= 1) {
                            Login.setBackgroundResource(R.drawable.onwronngclick);
                            Login.setText("LOG IN ATTEMPT : " + (counter - 1));
                            counter--;
                        }
                        if (counter == 0) {
                            Login.setEnabled(false);
                            Toast.makeText(this, "You Have Exceeded the Limit , Please Try Again Later", Toast.LENGTH_LONG).show();
                            Login.setBackgroundResource(R.drawable.onwronngclick);
                            Login.setText("LOGIN FAILED!!!");
                        }
                    }

                } else {

                    Toast.makeText(this, "Please Enter the User Name ", Toast.LENGTH_SHORT).show();
                    UserName.setBackgroundColor(Color.RED);


                }
                break;
            case R.id.bSignUp:


                try {
                    Intent i1 = new Intent(Login.this, Sign_Up.class);
                    startActivity(i1); // opens the new activty of sign up
                } catch (Exception e) {
                    //Making a Dialog Box
                    Dialog d = new Dialog(this);
                    d.setTitle("Cant Sign Up Please Try Again :");
                    String error = e.toString();
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }


                break;


        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (isChecked) {

            String usern = UserName.getText().toString();
            String pass = Password.getText().toString();
            //saving the string
            SharedPreferences.Editor editor = someData.edit();
            editor.putString("UserName", usern);
            editor.putString("Password", pass);
            editor.putBoolean("Check", true);
            editor.commit(); //finilizing the editor

        } else {

            SharedPreferences.Editor editor = someData.edit();
            editor.putString("UserName", "");
            editor.putString("Password", "");
            editor.putBoolean("Check", false);
            editor.commit(); //finilizing the editor


        }
    }
}


