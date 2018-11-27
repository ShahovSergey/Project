package ru.future.scientist.firstproject;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class JobAdapter extends RecyclerView.Adapter {

    public static class JobViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate;
        TextView tvXp;
        TextView tvJob;
        CheckBox cbIsComplete;


        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvXp = itemView.findViewById(R.id.tvXp);
            tvJob = itemView.findViewById(R.id.tvJob);
            cbIsComplete = itemView.findViewById(R.id.cbIsComplete);
        }
        public void bind(Job job) {
            tvDate.setText(job.getDate());
            tvJob.setText(job.getText_job());
            tvXp.setText(job.getExperience());
        }
    }
}
