package com.example.grpwork;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.grpwork.adapters.Recyclerviewadapter;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CoursesHome extends AppCompatActivity {


    RecyclerView recyclerView;


    RecyclerView.Adapter recyclerView_Adapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;

    String[] numbers = {
            "Data Structures",
            "AI ",
            "Design Patterns",
            "Algorithms",
            "Software Development",
            "Data Structures",
            "AI ",
            "Design Patterns",
            "Algorithms",
            "Software Development"
    };

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackgroundColor(R.color.colorAccent);
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        toolBarLayout.setTitle("Courses");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Context context = getApplicationContext();
//        TextView tv =  (TextView) findViewById(R.id.user_name);
//        ImageView imageView =  (ImageView) findViewById(R.id.user_photo);

//        Glide.with(context)
//                .load(R.raw.userp)
//                .into(imageView);
//        tv.setText("New User");



        recyclerView = (RecyclerView) findViewById(R.id.list_items);

        //Change 2 to your choice because here 2 is the number of Grid layout Columns in each row.
        recyclerViewLayoutManager = new GridLayoutManager(context, 2);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView_Adapter = new Recyclerviewadapter(context,numbers);

        recyclerView.setAdapter(recyclerView_Adapter);

    }
}