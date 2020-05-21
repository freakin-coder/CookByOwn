package com.example.saurav.cookbyown;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by saurav on 5/18/2020.
 */

public class Indian_food extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_indian);
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
