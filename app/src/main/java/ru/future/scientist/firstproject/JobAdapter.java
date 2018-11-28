package ru.future.scientist.firstproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    List<Job> jobs;

    public JobAdapter(List<Job> jobs) {
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_action, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.bind(jobs.get(position));
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

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
            tvDate.setText(new Date(job.getDate()).toString());
            tvJob.setText(job.getText_job());
            tvXp.setText(String.valueOf(job.getExperience()));
        }
    }
}
