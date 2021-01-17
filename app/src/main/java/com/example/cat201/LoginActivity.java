package com.example.cat201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    protected EditText et_login_email;
    protected EditText et_login_password;
    protected Button login_button;
    protected TextView login_signup;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login_email=findViewById(R.id.login_et_email);
        et_login_password=findViewById(R.id.login_et_password);
        login_button=findViewById(R.id.login_btn);
        login_signup=findViewById(R.id.login_tv_signup);
        mFirebaseAuth=FirebaseAuth.getInstance();

        login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=et_login_email.getText().toString().trim();
                String password=et_login_password.getText().toString().trim();

                if(email.isEmpty()||password.isEmpty()){

                    AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Please enter your email and password").setTitle("warning").setPositiveButton("ok",null);
                    AlertDialog dialog=builder.create();
                    dialog.show();

                }
                else{
                    mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this,
                            new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                GotoMainActivity();

                            }
                            else{

                                Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }

            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=et_login_email.getText().toString().trim();
                String password=et_login_password.getText().toString().trim();

                if(email.isEmpty()||password.isEmpty()){

                    AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Please enter your email and password").setTitle("warning").setPositiveButton("ok",null);
                    AlertDialog dialog=builder.create();
                    dialog.show();

                }
                else{

                    mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this,
                            new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                GotoMainActivity();

                            }
                            else{

                                Toast.makeText(LoginActivity.this,"Error",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                }

            }
        });

    }

    private void GotoMainActivity(){

        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);


    }



}