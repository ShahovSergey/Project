package ru.future.scientist.firstproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JobGenerator {

    private static final String[] text_jobs = new String[]{"Помочь бабушке", "Полить цветок", "Сделать уроки", "Помыть полы", "Помочь маме", "Помочь отцу"};
    private static final int experience = 100;
    private static final long date = 28112018;

    private Random random = new Random();

    public Job getJob() {
        final String text_job = text_jobs[random.nextInt(text_jobs.length)];
        return new Job(date, experience, text_job, false );
    }

    public List<Job> getJob(final int count){
        List<Job> jobs = new ArrayList<>(count);
        for(int i=0; i < count; i++) {
            jobs.add(getJob());
        }
        return jobs;
    }
}
