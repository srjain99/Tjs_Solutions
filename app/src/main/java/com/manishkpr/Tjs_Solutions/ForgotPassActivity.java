package com.manishkpr.Tjs_Solutions;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.manishkpr.Tjs_Solutions.R;

public class ForgotPassActivity extends ActionBarActivity {

    Button btn_submit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        setActionBar();
        btn_submit2= (Button) findViewById(R.id.bt_submit2);

        btn_submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgotPassActivity.this, "An E-mail has been sent on the id provided by you. Please click on the link in the mail.", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forgot_pass, menu);
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

    public void setActionBar(){
        getSupportActionBar().setTitle("Forgot Password");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.myPrimaryColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);
    }
}
