package com.example.codealpha_project_onlineexamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.codealpha_project_onlineexamapplication.database.MultipleDbHandler;
import com.example.codealpha_project_onlineexamapplication.model.MultipleDetails;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice extends AppCompatActivity {
    EditText question,option1,option2,option3,option4;
    Button create,clear;
    MultipleDbHandler multipleDbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);
        MultipleDetails multipleDetails=new MultipleDetails();

        question=findViewById(R.id.multiplequestion);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        create=findViewById(R.id.multiplecreate);
        clear=findViewById(R.id.multipleclear);
        multipleDbHandler=new MultipleDbHandler(this);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validQuestion()) {
                    List<MultipleDetails> multipleDetailsList=new ArrayList<>();
                    multipleDetails.setQuestion(question.getText().toString().trim());
                    multipleDetails.setOption1(option1.getText().toString().trim());
                    multipleDetails.setOption2(option2.getText().toString().trim());
                    multipleDetails.setOption3(option3.getText().toString().trim());
                    multipleDetails.setOption4(option4.getText().toString().trim());
                    multipleDbHandler.addQuestions(multipleDetails);
                    multipleDetailsList=multipleDbHandler.getQuestions();
                    for(MultipleDetails li:multipleDetailsList)
                    {
                        Log.d("nunu",""+li.getQuestion()+" "+li.getOption1());
                    }
                }
                else {
                    Toast.makeText(MultipleChoice.this, "Fill all your options", Toast.LENGTH_SHORT).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setText("");
                option1.setText("");
                option2.setText("");
                option3.setText("");
                option4.setText("");
            }
        });



    }
    private boolean validQuestion(){
        if(question.getText().toString().trim().isEmpty() || option1.getText().toString().trim().isEmpty() ||
                option2.getText().toString().trim().isEmpty() ||
                option3.getText().toString().trim().isEmpty() ||
                option4.getText().toString().trim().isEmpty()){
            return false;
        }
        else
            return true;
    }
}