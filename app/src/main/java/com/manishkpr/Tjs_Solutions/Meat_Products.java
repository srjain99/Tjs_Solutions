package com.manishkpr.Tjs_Solutions;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;


public class Meat_Products extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comingsoon);
        setActionBar();
    }

    public void setActionBar(){
        getSupportActionBar().setTitle("Meat");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.myPrimaryColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Meat_Products.this.finish();
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
