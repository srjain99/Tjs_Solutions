package com.manishkpr.Tjs_Solutions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {

    Button bt_signup,bt_submit,bt_forgot_pass,bt_login,bt_cancel;
    EditText et_editText1,et_editText2;

    int flag_login=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setActionBar();

        bt_signup = (Button) findViewById(R.id.bt_signup);
        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_forgot_pass= (Button) findViewById(R.id.bt_forgotpass);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        et_editText1 = (EditText) findViewById(R.id.editText1);
        et_editText2 = (EditText) findViewById(R.id.editText2);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_editText1.getText().toString().equals("") && et_editText2.getText().toString().equals(""))
                {
                    flag_login = 1;
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(in);
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Invalid Username/Password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);

                alert.setMessage("Are you sure you want to exit?");
                alert.setTitle("Exit");

                alert.create();
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LoginActivity.this.finish();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(in);
            }
        });

        bt_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in2=new Intent(LoginActivity.this,ForgotPassActivity.class);
                startActivity(in2);
            }
        });
    }

    public void setActionBar(){
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.myPrimaryColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(flag_login == 1)
        {
            LoginActivity.this.finish();
        }
    }

    @Override
    public void onBackPressed() {
        bt_cancel.performClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}