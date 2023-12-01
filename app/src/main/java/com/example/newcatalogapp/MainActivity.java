package com.example.newcatalogapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,userpassword;
    Button btnsignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.Loginusername);
        userpassword = findViewById(R.id.Loginpassword);
        btnsignin = findViewById(R.id.btnsignin);


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String user_name = username.getText().toString();
              String user_password = userpassword.getText().toString();

              if (user_password.isEmpty()) {

              username.requestFocus();
              username.setError("Please enter userename");


              } else if (user_password.isEmpty()) {
                  userpassword.requestFocus();
                  userpassword.setError("Please enter userpassworde");

              } else
                  Toast.makeText(MainActivity.this, "Validate ok", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert =
                        new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Sigin detials");
                alert.setMessage("My username is: "+user_name);
                alert.setCancelable(false);

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();

                ProgressDialog myprogress = new ProgressDialog(MainActivity.this);
                myprogress.setTitle("Please wait");
                myprogress.setMessage("Please wait process start");

                myprogress.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                myprogress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                myprogress.show();
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        int startVariable = 0;
                        try {
                            sleep(3000);
                            myprogress.dismiss();

                        }catch (InterruptedException e){


                        }
                    }
                };
                t.start();
                String adminEmail = "fari@gmail.com";
                String adminPassword = "fast1234";
                if (user_name.equalsIgnoreCase(adminEmail) && user_password.equalsIgnoreCase(adminPassword)){

                    Intent nextscreen = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(nextscreen);


                }else {

                    Toast.makeText(MainActivity.this, "Email or Password is invalid",Toast.LENGTH_LONG).show();

                };







            }
        });



        }


    public void registed(View view) {
    }

    public void register(View view) {

        Intent intent = new Intent(MainActivity.this, signupActivity.class);
        startActivity(intent);
    }
}
