package com.itshiteshverma.voice_of_woman3;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Hitesh Verma on 6/29/2015.
 */
public class Sign_Up extends Activity implements View.OnClickListener {
    Button Save;
    EditText Name, EmailAdd, UserName, Pass, ConfimPass;
    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_in);
        Save = (Button) findViewById(R.id.bSave);
        Save.setOnClickListener(this);
        Name = (EditText) findViewById(R.id.etName);
        EmailAdd = (EditText) findViewById(R.id.etEmailAdd);
        UserName = (EditText) findViewById(R.id.etUsername);
        Pass = (EditText) findViewById(R.id.etPassword);
        ConfimPass = (EditText) findViewById(R.id.etConfirmPassword);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bSave:
                boolean didItWorked = true;

                try {

                    String name = Name.getText().toString();
                    String email = EmailAdd.getText().toString();
                    String uname = UserName.getText().toString();
                    String pass = Pass.getText().toString();
                    String cpass = ConfimPass.getText().toString();

                    if (!pass.equals(cpass)) { //if password doesnot match
                        Toast.makeText(Sign_Up.this, "Password doesnt Match ", Toast.LENGTH_SHORT).show();
                        Pass.setBackgroundColor(Color.RED);
                        ConfimPass.setBackgroundColor(Color.RED);
                    } else {

                        CustomDialogClass cdd=new CustomDialogClass(Sign_Up.this);
                        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        cdd.show();


                        ConfimPass.setBackgroundColor(Color.TRANSPARENT);
                        Pass.setBackgroundColor(Color.TRANSPARENT);

                        // will create a DAta base object
                        Contact c = new Contact();
                        c.setname(name);
                        c.setEmail(email);
                        c.setPass(pass);
                        c.setUname(uname);
                        helper.insertContact(c); //inserting data in DB
                    }
                } catch (Exception e) {
                    didItWorked = false;
                    //Making a Dialog Box
                    Dialog d = new Dialog(this);
                    d.setTitle("Cant Sign Up Please Try Again :");
                    String error = e.toString();
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                } finally {
                    if (didItWorked) {


                    } else {
                        //Making a Dialog Box
                        Dialog d = new Dialog(this);
                        d.setTitle("Staus");
                        TextView tv = new TextView(this);
                        tv.setText("Saved UnSuccesfully");
                        tv.setTextColor(Color.BLACK);
                        tv.setBackgroundColor(Color.RED);
                        d.setContentView(tv);
                        d.show();
                    }


                    break;
                }

        }
    }
}
