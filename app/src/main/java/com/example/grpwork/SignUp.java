package com.example.grpwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variables

    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks to find all xml element in activity_sign_up.xml

        regName=findViewById(R.id.reg_name);
        regUsername=findViewById(R.id.reg_username);
        regEmail=findViewById(R.id.reg_email);
        regPhoneNo=findViewById(R.id.reg_phoneNo);
        regPassword=findViewById(R.id.reg_password);
        regBtn=findViewById(R.id.reg_btn);
        regToLoginBtn=findViewById(R.id.reg_login_btn);



    }//Onclick Method end


   /*
    private boolean validateName(){
        String val=regName.getEditText().getText().toString();

        if (val.isEmpty()){

            regName.setError("Field cannot be empty ");
            return false;

        }
        else {
            regName.setError(null);//hide the error
            regName.setErrorEnabled(false);//remove space from the error
            return true;
        }


    }

    private boolean validateUsername(){
        String val=regName.getEditText().getText().toString();
        String noWhiteSpace="(?=\\s+$)";

        if (val.isEmpty()){

            regName.setError("Field cannot be empty ");
            return false;

        }

        else if (val.length()>=15){
            regName.setError("Username too long");
            return false;
        }

        else if (!val.matches(noWhiteSpace)){
            regName.setError("White Space are not allowed");
            return false;
        }
        else {
            regName.setError(null);

            return true;
        }


    }

    private boolean validateEmail(){
        String val=regName.getEditText().getText().toString();
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]";


        if (val.isEmpty()){

            regName.setError("Field cannot be empty ");
            return false;

        }
        else if(val.matches(emailPattern)){
            regName.setError("Invaild email address");
            return false;
        }
        else {
            regName.setError(null);
            return true;
        }


    }

    private boolean validatePhoneNo(){
        String val=regName.getEditText().getText().toString();

        if (val.isEmpty()){

            regName.setError("Field cannot be empty ");
            return false;

        }
        else {
            regName.setError(null);
            return true;
        }


    }

    private boolean validatePassword(){
        String val=regPassword.getEditText().getText().toString();
        String passwordVal="^"+
               "(?=.*[A-Z])"+ //one upper case
                "(?=.*[a-zA=Z])" + //any letter
                "(?=\\s+$)"+    //no whitespace
                ".{4,}"+ //at least four characters
                "$";

        if (val.isEmpty()){

            regName.setError("Field cannot be empty ");
            return false;

        }
        else if(val.matches(passwordVal)){
            regName.setError("Password is too weak");
            return false;
        }
        else {
            regName.setError(null);
            return true;
        }


    }




    */


    public void registerUser(View view) {

       // if (!validateName() | !validatePassword()| !validatePhoneNo() | !validateEmail()| !validateUsername() ){
         //   return;
       // }




//        rootNode= FirebaseDatabase.getInstance();
//        reference=rootNode.getReference("users");
//
//        //get all the values
//        String name=regName.getEditText().getText().toString();
//        String username=regUsername.getEditText().getText().toString();
//        String email=regEmail.getEditText().getText().toString();
//        String phoneNo=regPhoneNo.getEditText().getText().toString();
//        String password=regPassword.getEditText().getText().toString();
//
//
//        UserHelperClass helperClass=new UserHelperClass(name,username,email,phoneNo,password);
//
//        reference.child(username).setValue(helperClass);

        Intent intent  = new Intent(this, CoursesHome.class);
        startActivity(intent);

    }


    }










      /*  regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                //get all the values
                String name=regName.getEditText().getText().toString();
                String username=regUsername.getEditText().getText().toString();
                String email=regEmail.getEditText().getText().toString();
                String phoneNo=regPhoneNo.getEditText().getText().toString();
                String password=regPassword.getEditText().getText().toString();


                UserHelperClass helperClass=new UserHelperClass(name,username,email,phoneNo,password);

                reference.child(phoneNo).setValue(helperClass);



            }
        });  //register Button method


       */
