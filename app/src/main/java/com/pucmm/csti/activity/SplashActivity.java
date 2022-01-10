package com.pucmm.csti.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pucmm.csti.R;
import com.pucmm.csti.utils.UserSession;

public class SplashActivity extends AppCompatActivity {

    private final static int SPLASH_TIME_OUT = 3500;
    //to get user session data
    private UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String email = "rafaelrfq@gmail.com";
        String password = "123456";

        // Do this only the first time
//        firebaseAuth.createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Log.e("SplashActivity", "registration successful");
//                        } else {
//                            Log.e("SplashActivity", "registration failed");
//                        }
//                    }
//                });

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    Log.e("SplashActivity", "signInWithEmailAndPassword:success");
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("SplashActivity", "signInWithEmailAndPassword:failure\n" + e.getMessage());
                    }
                });

        new Handler(Looper.getMainLooper()).postDelayed(() -> {

                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();

        }, SPLASH_TIME_OUT);
    }
}