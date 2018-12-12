package ru.future.scientist.firstproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {

    List<Job> jobs;
    private OnItemClickListener itemClickListener;

    public JobAdapter(List<Job> jobs, OnItemClickListener itemClickListener) {
        this.jobs = jobs;
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Job item);
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_action, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        holder.bind(jobs.get(position),itemClickListener);
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
        public void bind(Job job,  final OnItemClickListener itemClickListener) {
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(job));

            tvDate.setText(new Date(job.getDate()).toString());
            tvJob.setText(job.getText_job());
            tvXp.setText(String.valueOf(job.getExperience()));
        }
    }

    public void update(List<Job> people){
        this.jobs.clear();
        this.jobs.addAll(people);
        notifyDataSetChanged();
    }


}
