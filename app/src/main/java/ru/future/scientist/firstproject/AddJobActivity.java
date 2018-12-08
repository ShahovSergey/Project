package ru.future.scientist.firstproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class AddJobActivity extends AppCompatActivity {

    private TextInputLayout tilTextJob;
    private TextInputLayout tilExperience;
    private TextInputLayout tilDate;
    private TextInputLayout tilTime;
    private JobGenerator generator = new JobGenerator();

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddJobActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);

        tilTextJob = findViewById(R.id.tilTextJob);
        tilExperience = findViewById(R.id.tilExperience);
        tilDate = findViewById(R.id.tilDate);
        tilTime = findViewById(R.id.tilTime);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Job job = generator.getJob();
            tilTextJob.getEditText().setText(job.getText_job());
            tilExperience.getEditText().setText(String.valueOf(job.getExperience()));

            Date date = new Date(job.getDate());
            SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy"); // e.g. 24.10.2018
            tilDate.getEditText().setText(formatDate.format(date));
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm"); // e.g. 15:46
            tilTime.getEditText().setText(formatTime.format(date));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_job, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAdd) {
            String textJob = tilTextJob.getEditText().getText().toString();
            String experienceString = tilExperience.getEditText().getText().toString();
            int experience = experienceString.isEmpty() ? 0 : Integer.valueOf(experienceString);
            String dateTime = tilDate.getEditText().getText().toString() + " " + tilTime.getEditText().getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm"); // e.g. 24.10.2018 15:46
            long date;
            try {
                date = format.parse(dateTime).getTime();
            } catch (ParseException e) {
                date = new Date().getTime();
                Log.e("AddPersonActivity", "Date parse error", e);
            }
            Job job = new Job(date, experience, textJob, false);
            //AppDatabase.getInstance(this).personDao().insertPerson(job);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
