package com.example.codealpha_project_onlineexamapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.codealpha_project_onlineexamapplication.adapter.WrittenRecyclerViewAdapter;
import com.example.codealpha_project_onlineexamapplication.database.WrittenDbHandler;
import com.example.codealpha_project_onlineexamapplication.model.WrittenDetails;

import java.util.List;

public class pager2 extends AppCompatActivity {

    WrittenDbHandler writtenDbHandler;
    List<WrittenDetails> writtenDetailsList;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager2);

        writtenDbHandler=new WrittenDbHandler(this);
        writtenDetailsList=writtenDbHandler.getQuestions();
        for(WrittenDetails li:writtenDetailsList) {
            Log.d("nyny", "" +li.getQuestion());
        }

        back=findViewById(R.id.back);
        RecyclerView recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        WrittenRecyclerViewAdapter writtenRecyclerViewAdapter = new WrittenRecyclerViewAdapter(this, writtenDetailsList);
        recyclerView.setAdapter(writtenRecyclerViewAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pager2.this, paper.class));
                finish();
            }
        });


    }
}