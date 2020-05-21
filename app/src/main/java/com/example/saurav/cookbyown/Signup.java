package com.example.saurav.cookbyown;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);

        editText1= (EditText)findViewById(R.id.password);
        editText2= (EditText)findViewById(R.id.confpass);
        editText3= (EditText)findViewById(R.id.mail);
        button= (Button) findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();

                if(text1.equals("") || text2.equals("")){
                    Toast.makeText(Signup.this, "No password entered", Toast.LENGTH_SHORT).show();
                }else {
                    if(text1.equals(text2)){
                        SharedPreferences settings=getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password",text1);
                        editor.apply();


                        Intent intent = new Intent(getApplicationContext(), Login.class);

                        intent.putExtra("Saurav",text3);  // user name pass


                        startActivity(intent);
                        finish();


                    }else {
                        Toast.makeText(Signup.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
