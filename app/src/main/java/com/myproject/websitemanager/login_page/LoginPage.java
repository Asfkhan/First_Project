package com.myproject.websitemanager.login_page;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.myproject.websitemanager.MainActivity;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.signup_page.SignUpPage;


public class LoginPage extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAuth = FirebaseAuth.getInstance();
       EditText email = findViewById(R.id.t1);
        EditText password = findViewById(R.id.t2);
        Button validuser = findViewById(R.id.validuser1);
        TextView gotosignup = findViewById(R.id.gosignup);
        gotosignup.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), SignUpPage.class);
            startActivity(i);
            finish();
        });
        ProgressBar progressBar = findViewById(R.id.myprogress);


        validuser.setOnClickListener(view -> {
            progressBar.setVisibility(View.GONE);
            String value1 = email.getText().toString();
            String value2 = password.getText().toString();
            mAuth.signInWithEmailAndPassword(value1, value2)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LoginPage.this, "Welcome.",Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(login);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginPage.this, "Authentication failed.",Toast.LENGTH_SHORT).show();

                        }
                    });

        });

    }


}