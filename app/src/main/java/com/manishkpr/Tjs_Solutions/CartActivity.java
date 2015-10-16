package com.manishkpr.Tjs_Solutions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CartActivity extends ActionBarActivity {

    ListView lv_cart;
    static ArrayList<String> name ;
    static ArrayList<Integer> rate ;
    int tt ;
    TextView total;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setActionBar();

        lv_cart = (ListView) findViewById(R.id.lv_cart_list);
        total = (TextView) findViewById(R.id.tv_total);
        tt=0;

        name = new ArrayList<String>();
        rate = new ArrayList<Integer>();
        name = getIntent().getExtras().getStringArrayList("fname");
        rate = getIntent().getExtras().getIntegerArrayList("frate");

        for(int i = 0 ; i < rate.size() ; i++)
        {
            tt += parseInt(rate.get(i).toString());
        }
        total.setText(tt + "");

    final MyAdapter adapter = new MyAdapter(CartActivity.this, R.layout.cart_layout, name);
        lv_cart.setAdapter(adapter);

        lv_cart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(CartActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to remove this item?");
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("OK", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        name.remove(positionToRemove);
                        rate.remove(positionToRemove);
                        tt=0;
                        for (int i = 0; i < rate.size(); i++) {
                            tt += parseInt(rate.get(i).toString());
                        }
                        total.setText(tt + "");
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context context, int resource, ArrayList<String> name) {
            super(context, resource, name);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v2 = getLayoutInflater().inflate(R.layout.cart_layout,null);
            TextView tv_name = (TextView) v2.findViewById(R.id.tv_ct_name);
            tv_name.setText(name.get(position));
            TextView tv_rate = (TextView) v2.findViewById(R.id.tv_ct_rate);
            tv_rate.setText(rate.get(position).toString());

            return v2;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.checkout:
                Intent cart = new Intent(CartActivity.this,PaymentActivity.class);
                startActivity(cart);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setActionBar(){
        getSupportActionBar().setTitle("Cart");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.getResources().getColor(R.color.myPrimaryColor)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setElevation(0);
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("cname", name);
        resultIntent.putExtra("crate", rate);
        setResult(Fruit_Products.RESULT_OK, resultIntent);
        super.onBackPressed();
    }
}
