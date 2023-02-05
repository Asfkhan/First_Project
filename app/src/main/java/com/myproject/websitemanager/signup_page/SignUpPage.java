package com.myproject.websitemanager.signup_page;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.myproject.websitemanager.MainActivity;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.login_page.LoginPage;

public class SignUpPage extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        mAuth = FirebaseAuth.getInstance();
        EditText newemail = findViewById(R.id.e1);
        EditText confirmpassword = findViewById(R.id.p1);
        TextView gotologin = findViewById(R.id.gologin);

        gotologin.setOnClickListener(view -> {
            Intent back = new Intent(this,LoginPage.class);
            startActivity(back);
            finish();
        });

        Button add = findViewById(R.id.add1);
        add.setOnClickListener(view -> {
            String val1 = newemail.getText().toString();
            String val2 = confirmpassword.getText().toString();
            mAuth.createUserWithEmailAndPassword(val1, val2)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(SignUpPage.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                            Intent main = new Intent(this, MainActivity.class);
                            startActivity(main);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpPage.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }
                    });
        });

    }

}