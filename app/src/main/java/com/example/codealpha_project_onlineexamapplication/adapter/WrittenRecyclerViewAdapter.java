package com.example.codealpha_project_onlineexamapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.codealpha_project_onlineexamapplication.R;
import com.example.codealpha_project_onlineexamapplication.model.WrittenDetails;

import java.util.List;

public class WrittenRecyclerViewAdapter extends RecyclerView.Adapter<WrittenRecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<WrittenDetails> writtenDetails;
    private int i=1;

    public WrittenRecyclerViewAdapter(Context context,List<WrittenDetails> writtenDetails){
        this.context=context;
        this.writtenDetails=writtenDetails;

    }
    @NonNull
    @Override
    public WrittenRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowwritten,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull WrittenRecyclerViewAdapter.ViewHolder holder, int position) {
        WrittenDetails cont=writtenDetails.get(position);
        holder.question.setText("Q"+i+" "+cont.getQuestion());
        i++;



    }

    @Override
    public int getItemCount() {
        return writtenDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView question;


        public ViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            question=itemView.findViewById(R.id.writquestion);

        }
        @Override
        public void onClick(View v) {

        }
    }
}


