package com.manishkpr.Tjs_Solutions;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends BaseActivity {
	FragmentStackManager fm,sliding_menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setUpView();
		menuToggeleSetUp(savedInstanceState);
		setActionBar();
	}
	
	void setUpView(){
		fm 		   		= new FragmentStackManager(this);
		sliding_menu	= new FragmentStackManager(this);
		drawer	   = (DrawerLayout) findViewById(R.id.drawer_layout);
		fm.addFragment(new MainFragment(), R.id.main_frame, false, FragmentTransaction.TRANSIT_NONE, false);
		sliding_menu.addFragment(new SlidingMenuFragment(), R.id.slide_fragment, false, FragmentTransaction.TRANSIT_NONE, false);
	}
	
	void menuToggeleSetUp(Bundle savedInstanceState){
		mDrawerToggle = new ActionBarDrawerToggle(this, drawer,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name
		) {
			public void onDrawerClosed(View view) {
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		drawer.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
	
		return true;
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		else if(id==R.id.exit)
		{
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
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

		AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

		alert.setMessage("Are you sure you want to exit?");
		alert.setTitle("Exit");

		alert.create();
		alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				MainActivity.this.finish();
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
