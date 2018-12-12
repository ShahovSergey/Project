package ru.future.scientist.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    JobAdapter adapter;
    JobGenerator generator = new JobGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddJobActivity.getStartIntent(this);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateList();
    }

    private void updateList() {
        List<Job> jobs = AppDatabase.getInstance(this).jobDao().getAll();
        adapter.update(jobs);
    }


    private void initList() {
        RecyclerView rvJobs = findViewById(R.id.rvAction);
        rvJobs.setHasFixedSize(true);
        rvJobs.setLayoutManager(new LinearLayoutManager(this));
        List<Job> jobs = AppDatabase.getInstance(this).jobDao().getAll();
        adapter = new JobAdapter(jobs, item -> {
            Toast.makeText(this, item.getText_job(), Toast.LENGTH_LONG).show();
        });
        rvJobs.setAdapter(adapter);
    }
}
