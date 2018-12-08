package ru.future.scientist.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final Intent intent = AddJobActivity.getStartIntent(this);
            startActivity(intent);
        });
    }

//    @Override
 //   public boolean onCreateOptionsMenu(Menu menu) {
   //     // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.menu_main, menu);
       // initList();
 //       return true;
   // }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    private void initList() {
        RecyclerView rvJobs = findViewById(R.id.rvAction);
        rvJobs.setHasFixedSize(true);
        rvJobs.setLayoutManager(new LinearLayoutManager(this));
        adapter = new JobAdapter(generator.getJob(5));
        rvJobs.setAdapter(adapter);
    }
}
