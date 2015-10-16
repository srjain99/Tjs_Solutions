package com.manishkpr.Tjs_Solutions;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Fruit_Products extends ActionBarActivity {

    ListView lv_fruitproducts;
    String[] fruits = {"Apple","Banana","Orange"};
    String[] fruit_rates = {"50","30","40"};
    ArrayList<String> name;
    ArrayList<Integer> rate;
    Intent fruit_cart;
    int[] fruit_images = {R.drawable.apple,R.drawable.banana,R.drawable.orange};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);
        setActionBar();

        lv_fruitproducts = (ListView) findViewById(R.id.lv_products);
        lv_fruitproducts.setAdapter(new MyAdapter(Fruit_Products.this, R.layout.products, fruits));

        name=new ArrayList<String>();
        rate=new ArrayList<Integer>();

        lv_fruitproducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_name = (TextView) view.findViewById(R.id.tv_pr_name);
                TextView tv_rate = (TextView) view.findViewById(R.id.tv_pr_rateperkg);
                CheckBox cb = (CheckBox) view.findViewById(R.id.cb_product);

                if (cb.isChecked()) {
                    cb.setChecked(false);
                } else {
                    cb.setChecked(true);
                    Toast.makeText(Fruit_Products.this,tv_name.getText().toString() + " selected!" , Toast.LENGTH_SHORT).show();
                }

                switch (position) {
                    case 0:
                        if (cb.isChecked()) {
                            name.add(tv_name.getText().toString());
                            rate.add(parseInt(tv_rate.getText().toString()));
                        }
                        break;
                    case 1:
                        if (cb.isChecked()) {
                            name.add(tv_name.getText().toString());
                            rate.add(parseInt(tv_rate.getText().toString()));
                        }
                        break;
                    case 2:
                        if (cb.isChecked()) {
                            name.add(tv_name.getText().toString());
                            rate.add(parseInt(tv_rate.getText().toString()));
                        }
                        break;
                    case 3:
                        if (cb.isChecked()) {
                            name.add(tv_name.getText().toString());
                            rate.add(parseInt(tv_rate.getText().toString()));
                        }
                        break;
                }


            }
        });


    }

    class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context, int resource, String[] name) {
            super(context, resource, name);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v1 = getLayoutInflater().inflate(R.layout.products,null);
            ImageView iv_fruits = (ImageView) v1.findViewById(R.id.iv_product);
            iv_fruits.setBackgroundResource(fruit_images[position]);
            TextView tv_name = (TextView) v1.findViewById(R.id.tv_pr_name);
            tv_name.setText(fruits[position]);
            TextView tv_rate = (TextView) v1.findViewById(R.id.tv_pr_rateperkg);
            tv_rate.setText(fruit_rates[position]);
            return v1;
        }
    }

    public void setActionBar(){
        getSupportActionBar().setTitle("Fruits");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.myPrimaryColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fruits, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.add_to_cart:
                fruit_cart = new Intent(Fruit_Products.this, CartActivity.class);
                fruit_cart.putExtra("fname", name);
                fruit_cart.putExtra("frate", rate);
                startActivityForResult(fruit_cart, 0);

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode)
        {
            case 0 : {
                if (resultCode == Fruit_Products.RESULT_OK) {
                    name = data.getStringArrayListExtra("cname");
                    rate = data.getIntegerArrayListExtra("crate");
                }
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
