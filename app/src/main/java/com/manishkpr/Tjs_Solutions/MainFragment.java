package com.manishkpr.Tjs_Solutions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainFragment extends Fragment {

	Activity referenceActivity;
	ImageView iv_cat1,iv_cat2,iv_cat3;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_main, null);
		referenceActivity = getActivity();

		iv_cat1 = (ImageView) root.findViewById(R.id.iv_cat1);
		iv_cat2 = (ImageView) root.findViewById(R.id.iv_cat2);
		iv_cat3 = (ImageView) root.findViewById(R.id.iv_cat3);

        iv_cat1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent fruit_activity = new Intent(referenceActivity,Fruit_Products.class);
				startActivity(fruit_activity);
			}
		});

		iv_cat2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent vegetable_activity = new Intent(referenceActivity,Vegetable_Products.class);
				startActivity(vegetable_activity);
			}
		});

		iv_cat3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent meat_activity = new Intent(referenceActivity,Meat_Products.class);
				startActivity(meat_activity);
			}
		});

		return root;
	}

}
