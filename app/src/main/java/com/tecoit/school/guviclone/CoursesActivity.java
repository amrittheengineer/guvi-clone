package com.tecoit.school.guviclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CoursesActivity extends AppCompatActivity {

    private RecyclerView courses_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        courses_rv = findViewById(R.id.courses_rv);
        courses_rv.setLayoutManager(new LinearLayoutManager(this));

        List<CourseItem> courseItems = new ArrayList<>();

        courseItems.add(new CourseItem.CourseItemHeader("Beginner Module"));
        courseItems.add(new CourseItem.CourseItemContent("Java - Session 01 - Introduction", true));
        courseItems.add(new CourseItem.CourseItemContent("Java - Session 02 - Java History"));
        courseItems.add(new CourseItem.CourseItemContent("Java - Session 03 - Java Features"));

        courseItems.add(new CourseItem.CourseItemHeader("Intermediate Module"));
        courseItems.add(new CourseItem.CourseItemContent("Java - Session 01 - Introduction"));
        courseItems.add(new CourseItem.CourseItemContent("Java - Session 02 - Java History"));
        courseItems.add(new CourseItem.CourseItemContent("Java - Session 03 - Java Features"));

        CoursesAdapter adapter = new CoursesAdapter(getApplicationContext(), courseItems);
        courses_rv.setAdapter(adapter);

    }
}