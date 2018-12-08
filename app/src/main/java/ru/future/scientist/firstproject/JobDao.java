package ru.future.scientist.firstproject;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface JobDao {
    @Query("SELECT * FROM jobs")
    List<Job> getAll();

    @Query("SELECT * FROM jobs WHERE id = :id")
    Job getById(long id);

    @Insert
    long insertJob(Job job);
}