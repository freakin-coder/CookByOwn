package com.example.saurav.cookbyown;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by saurav on 5/17/2020.
 */

public class Login extends AppCompatActivity  {

    String password;

    EditText editText;
    Button button;
    TextView Userview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);


        Bundle extras=getIntent().getExtras();     //user name pass
        if(extras!=null){
            String username=extras.getString("Saurav");
            Userview=(TextView) findViewById(R.id.userid);
            Userview.setText("Hi "+username+"!");

        }


        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");


        editText= (EditText)findViewById(R.id.editText);
        button= (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text= editText.getText().toString();

                if (text.equals(password)){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }

            }
        });

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
                Toast.makeText(Login.this,"Login First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tof:
                Toast.makeText(Login.this,"Login First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.qt:
                finish();
                break;
            case R.id.abt:
                Toast.makeText(Login.this,"Login First", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}

