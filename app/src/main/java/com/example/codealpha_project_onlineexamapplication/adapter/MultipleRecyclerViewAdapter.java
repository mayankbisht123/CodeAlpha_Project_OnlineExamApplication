package com.example.codealpha_project_onlineexamapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.codealpha_project_onlineexamapplication.R;
import com.example.codealpha_project_onlineexamapplication.model.MultipleDetails;

import java.util.List;

public class MultipleRecyclerViewAdapter extends RecyclerView.Adapter<MultipleRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private int i=1;
    private List<MultipleDetails> multipleDetails;

    public MultipleRecyclerViewAdapter(Context context,List<MultipleDetails> multipleDetails){
        this.context=context;
        this.multipleDetails=multipleDetails;

    }
    @NonNull
    @Override
    public MultipleRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowmultiple,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleRecyclerViewAdapter.ViewHolder holder, int position) {
        MultipleDetails cont=multipleDetails.get(position);
        holder.question.setText("Q"+i+" "+cont.getQuestion());
        holder.option1.setText(cont.getOption1());
        holder.option2.setText(cont.getOption2());
        holder.option3.setText(cont.getOption3());
        holder.option4.setText(cont.getOption4());
        i++;
    }

    @Override
    public int getItemCount() {
        return multipleDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView question;
        public RadioButton option1,option2,option3,option4;


        public ViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            question=itemView.findViewById(R.id.Question);
            option1=itemView.findViewById(R.id.radioButton);
            option2=itemView.findViewById(R.id.radioButton2);
            option3=itemView.findViewById(R.id.radioButton3);
            option4=itemView.findViewById(R.id.radioButton4);

        }
        @Override
        public void onClick(View v) {

        }
    }
}


