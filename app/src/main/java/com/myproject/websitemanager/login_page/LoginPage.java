package com.myproject.websitemanager.login_page;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.myproject.websitemanager.MainActivity;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.signup_page.SignUpPage;


public class LoginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email,password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();
       email = findViewById(R.id.t1);
       password = findViewById(R.id.t2);
        Button validuser = findViewById(R.id.validuser1);
        TextView gotosignup = findViewById(R.id.gosignup);
        gotosignup.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), SignUpPage.class);
            startActivity(i);
            finish();
        });
        ProgressBar progressBar = findViewById(R.id.myprogress);


        validuser.setOnClickListener(view -> {
            try {
                String value1 = email.getText().toString();
                String value2 = password.getText().toString();
                mAuth.signInWithEmailAndPassword(value1, value2)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "signInWithEmail:success");
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(LoginPage.this, "Welcome.", Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                                login.putExtra("email",email.getText().toString());
                                startActivity(login);
                                finish();
                                progressBar.setVisibility(View.VISIBLE);

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                email.setError("Email Wrong");
                                password.setError("Password Wrong");
                                Toast.makeText(LoginPage.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                            }
                        });
            }catch (Exception e){
                email.setError("Email Wrong");
                password.setError("Password Wrong");
            }
        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Do you Want to Exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
            alertDialog.create();
            alertDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
}