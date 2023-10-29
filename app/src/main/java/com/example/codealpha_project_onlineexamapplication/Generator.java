package com.example.codealpha_project_onlineexamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Generator extends AppCompatActivity {

    int pos;
    Button createQuestions,goTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        List<String> types=new ArrayList<>();
        Spinner spinner=findViewById(R.id.spinner);
        types.add("Multiple Choices Questions");
        types.add("Written Questions");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,types);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        createQuestions=findViewById(R.id.createQuestions);
        goTo=findViewById(R.id.goToQuestion);
        createQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos==0)
                {
                    startActivity(new Intent(Generator.this, MultipleChoice.class));
                }
                else {
                    startActivity(new Intent(Generator.this, WrittenQuestion.class));
                }
            }
        });
        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Generator.this, paper.class);
                startActivity(intent);
            }
        });



    }
}