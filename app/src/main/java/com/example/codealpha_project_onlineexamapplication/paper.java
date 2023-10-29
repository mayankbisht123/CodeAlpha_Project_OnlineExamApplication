package com.example.codealpha_project_onlineexamapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.codealpha_project_onlineexamapplication.adapter.MultipleRecyclerViewAdapter;
import com.example.codealpha_project_onlineexamapplication.database.MultipleDbHandler;
import com.example.codealpha_project_onlineexamapplication.model.MultipleDetails;

import java.util.List;

public class paper extends AppCompatActivity {

    MultipleDbHandler multipleDbHandler;
    List<MultipleDetails> multipleDetailsList;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paper);

        multipleDbHandler=new MultipleDbHandler(this);
        multipleDetailsList=multipleDbHandler.getQuestions();
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MultipleRecyclerViewAdapter multipleRecyclerViewAdapter = new MultipleRecyclerViewAdapter(this, multipleDetailsList);
        recyclerView.setAdapter(multipleRecyclerViewAdapter);

        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paper.this, pager2.class));
                finish();
            }
        });


    }
}