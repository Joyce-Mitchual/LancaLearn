package com.example.grpwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {

    Button callSignUp,login_btn;
    ImageView image;
    TextView logoText, sloganText;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);

//Hooks
        callSignUp=findViewById(R.id.signup_screen);





             callSignUp.setOnClickListener(new View.OnClickListener() {

                 @Override
            public void onClick(View view) {

                Intent intent=new Intent(Dashboard.this,SignUp.class);
                startActivity(intent);


            }
        });




    }


    private Boolean validateUsername(){
        String val=username.getEditText().getText().toString();

        if (val.isEmpty()){
            username.setError("Field is empty ");
            return false;
        }

        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;

        }
    }


    private Boolean validatePassowrd(){
        String val= password.getEditText().getText().toString();

        if(val.isEmpty()){
            password.setError("Field cannot be empty ");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;

        }



    }


    public void loginUser(View view) {
        if(!validatePassowrd()| !validateUsername()){
            return;
        }

        else {
            isUser();
        }
    }


    private void isUser(){
        String userEnteredUsername=username.getEditText().getText().toString().trim();
        String userEnteredPassword=username.getEditText().getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser=reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB= snapshot.child(userEnteredUsername).child("password").getValue(String.class);


                    if(passwordFromDB.equals(userEnteredPassword)){

                        username.setError(null);
                        username.setErrorEnabled(false);

                        //retrive information and place below

                     //   Intent intent=new Intent(getApplicationContext(),Nextpage.class);


                        //startActivity(intent);


                    }
                    else {
                        password.setError("Wrong Passowrd");
                        password.requestFocus();
                    }

                }

                else{
                    username.setError("No such User exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}