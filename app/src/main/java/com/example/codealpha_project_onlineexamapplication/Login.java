package com.example.codealpha_project_onlineexamapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.codealpha_project_onlineexamapplication.database.MyDbHandler;
import com.example.codealpha_project_onlineexamapplication.model.Details;

import java.util.ArrayList;
import java.util.List;


public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;
    TextView signup;
    final static String id="name.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.singup);

       MyDbHandler myDbHandler=new MyDbHandler(this);
        List<Details> details=myDbHandler.getContacts();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean boo=false;
                for(Details d:details)
                {

                    Log.d("mymy", "Details: " + d.getEmail() + ", " + d.getPassword());
                    if(d.getEmail().equals(email.getText().toString())
                            && d.getPassword().equals(password.getText().toString()))
                    {
                        boo=true;
                        SharedPreferences sharedPreferences=getSharedPreferences("Account",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putBoolean("check",true);
                        editor.apply();
                        Intent intent=new Intent(Login.this, Generator.class);
                        intent.putExtra(id,d.getName());
                        startActivity(intent);
                        break;
                    }
                }
                if(!boo)
                    Toast.makeText(getApplicationContext(), "No user found", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Login.this, "Confirms", Toast.LENGTH_SHORT).show();

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,SignUp.class));
            }
        });

    }
}