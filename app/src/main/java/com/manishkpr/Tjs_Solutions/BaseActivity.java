package com.manishkpr.Tjs_Solutions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;

public class BaseActivity extends ActionBarActivity{
	public ActionBarDrawerToggle mDrawerToggle;
	public DrawerLayout drawer;
    
    CharSequence mDrawerTitle;
	CharSequence mTitle;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBar();
	}
	public void setActionBar(){
		getSupportActionBar().setTitle("TJS");
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.myPrimaryColor)));
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setElevation(0);
	}

	@Override
	public void onBackPressed() {

		AlertDialog.Builder alert = new AlertDialog.Builder(BaseActivity.this);

		alert.setMessage("Are you sure you want to exit?");
		alert.setTitle("Exit");

		alert.create();
		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				BaseActivity.this.finish();
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
	
}
