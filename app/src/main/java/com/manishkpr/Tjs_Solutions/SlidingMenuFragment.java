package com.manishkpr.Tjs_Solutions;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SlidingMenuFragment extends Fragment {
	List<String>data;
	ListView list_view;
	SlidingMenuListAdapter adapter;
	Activity referenceActivity;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sliding_menu, null);
		setUpView(root);
		referenceActivity = getActivity();

		list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch(position)
				{
					case 0:
						Intent fruit_activity = new Intent(referenceActivity,Fruit_Products.class);
						startActivity(fruit_activity);
						break;
					case 1:
						Intent vegetable_activity = new Intent(referenceActivity,Vegetable_Products.class);
						startActivity(vegetable_activity);
						break;
					case 2:
						Intent meat_activity = new Intent(referenceActivity,Meat_Products.class);
						startActivity(meat_activity);
						break;
				}
			}
		});

		return root;
	}
	void setUpView(ViewGroup root){
		list_view  =  (ListView)root.findViewById(R.id.list_view);
		initList();
	}
	void initList(){
		data = new ArrayList<String>();

		data.add("Fruits");
		data.add("Vegetables");
		data.add("Meat");
		
		adapter = new SlidingMenuListAdapter(getActivity(),data);
		list_view.setAdapter(adapter);
	}

}
