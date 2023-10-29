package com.example.codealpha_project_onlineexamapplication;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codealpha_project_onlineexamapplication.database.MyDbHandler;
import com.example.codealpha_project_onlineexamapplication.model.Details;


public class SignUp extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button register;
    EditText name,password,email,Cpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        register=findViewById(R.id.login);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Cpassword=findViewById(R.id.Cpassword);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onValidate();
            }
        });

    }

    private void onValidate(){
        String sname=name.getText().toString().trim();
        String semail=email.getText().toString().trim();
        String spassword=password.getText().toString().trim();
        String scpassword=Cpassword.getText().toString().trim();
        if(TextUtils.isEmpty(sname))
        {
            Toast.makeText(getApplicationContext(),"Enter name ",Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(semail).matches())
        {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(spassword))
        {
            Toast.makeText(this, "Enter passowrd", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(scpassword))
        {
            Toast.makeText(this, "Enter confirm password", Toast.LENGTH_SHORT).show();
        }
        else if(!spassword.equals(scpassword))
        {
            Toast.makeText(this, "Wrong Confirm password", Toast.LENGTH_SHORT).show();
        }
        else{
            addAccount(sname,semail,spassword,scpassword);
            startActivity(new Intent(this,Login.class));

        }
    }
    private void addAccount(String name,String email,String pass,String Cpass)
    {
        Toast.makeText(this, ""+email+" "+pass, Toast.LENGTH_SHORT).show();
        MyDbHandler myDbHandler=new MyDbHandler(this);
        Details details=new Details();
        details.setName(name);
        details.setEmail(email);
        details.setPassword(pass);
        details.setCpassword(Cpass);
        myDbHandler.addContacts(details);
    }

}