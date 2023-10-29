package com.example.codealpha_project_onlineexamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.codealpha_project_onlineexamapplication.database.WrittenDbHandler;
import com.example.codealpha_project_onlineexamapplication.model.WrittenDetails;

public class WrittenQuestion extends AppCompatActivity {

   EditText question;
   Button create,clear;
   WrittenDetails writtenDetails;
   WrittenDbHandler writtenDbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_written_question);

        question=findViewById(R.id.writtenquestion);
        create=findViewById(R.id.writtencreate);
        clear=findViewById(R.id.writtenclear);
        writtenDetails=new WrittenDetails();
        writtenDbHandler=new WrittenDbHandler(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateQuestion())
                {
                    writtenDetails.setQuestion(question.getText().toString().trim());
                    writtenDbHandler.addQuestions(writtenDetails);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setText("");
            }
        });

    }


    private boolean validateQuestion(){
        if(question.getText().toString().trim().isEmpty())
            return false;
        else
            return true;
    }
}