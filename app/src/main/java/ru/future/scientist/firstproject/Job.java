package ru.future.scientist.firstproject;

import java.util.Objects;

public class Job {
    private long id;
    private int date;
    private int experience;
    private String text_job;
    private boolean is_complete;

    public Job(int date, int experience, String text_job, boolean is_complete) {
        this(0, date, experience, text_job,is_complete);
    }


    public Job(long id, int date, int experience, String text_job, boolean is_complete) {
        this.id = id;
        this.date = date;
        this.experience = experience;
        this.text_job = text_job;
        this.is_complete = is_complete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getText_job() {
        return text_job;
    }

    public void setText_job(String text_job) {
        this.text_job = text_job;
    }

    public boolean isIs_complete() {
        return is_complete;
    }

    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                date == job.date &&
                experience == job.experience &&
                is_complete == job.is_complete &&
                Objects.equals(text_job, job.text_job);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date, experience, text_job, is_complete);
    }
}
