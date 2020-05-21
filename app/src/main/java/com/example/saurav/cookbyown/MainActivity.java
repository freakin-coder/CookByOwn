package com.example.saurav.cookbyown;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView lst;
    String [] items={"Indian","Chinese","Mexican","Italian","Spanish","American"};
    String [] desc={"Be Indian, Taste Indian","Love Chinese, Desi chinese","Authentic Mexican cook instantly","Sweet Italian dishes recipe","Salty Spanish, Crave for spanish","American blend, with a desi touch"};

    Integer[]logo={R.drawable.indian,R.drawable.chinese,R.drawable.mexican,R.drawable.italian,R.drawable.spanish,R.drawable.american};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst=(ListView) findViewById(R.id.types_of_food);
        CustomListView customListView=new CustomListView(this,items,desc,logo);
        lst.setAdapter(customListView);


        lst.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                int itemPosition = position;

                String itemValue = (String) lst.getItemAtPosition(position);

                if (itemPosition==0){
                    Intent intent = new Intent(getApplicationContext(), Indian_food.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    Toast.makeText(MainActivity.this, itemValue, Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.log:
                Intent intent = new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
                finish();
                break;
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.helpguide.org/articles/healthy-eating/cooking-at-home.htm"));
                startActivity(intent);
                finish();
                break;
            case R.id.tof:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.qt:
                finish();
                break;
            case R.id.abt:
                 intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
