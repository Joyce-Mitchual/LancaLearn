package com.example.grpwork;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.example.grpwork.adapters.Recyclerviewadapter;
import com.example.grpwork.models.Module;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import java.util.ArrayList;

public class CoursesHomeActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    private DatabaseReference myRef;
    private FirebaseDatabase database;

    RecyclerView.Adapter recyclerView_Adapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;

    ArrayList<Module> modules;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_courses_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setBackgroundColor(R.color.black);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        toolBarLayout.setBackgroundColor(R.color.black);
        toolBarLayout.setTitle("Modules");


        //init modules
        modules = new ArrayList<>();

        //init firebase connections
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("modules");


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Module module =  dataSnapshot.getValue(Module.class);
                modules.add(module);

                recyclerView_Adapter.notifyDataSetChanged();

                Log.v("Firebase " , dataSnapshot.getValue().toString());
                //put all user id's in the usersId list

//                String id = dataSnapshot.getKey();
//                if(!(myId.equals(id))) {
//                    userIds.add(id);
//                    //toast("id is : "+id);
//                    //log("id is : " + id);
//                    listToValue(id);
//                }


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


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

        recyclerView_Adapter = new Recyclerviewadapter(context,modules);

        recyclerView.setAdapter(recyclerView_Adapter);

        recyclerView_Adapter.notifyDataSetChanged();

    }
}