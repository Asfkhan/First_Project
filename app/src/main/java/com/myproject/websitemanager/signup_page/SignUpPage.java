package com.myproject.websitemanager.signup_page;


import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.myproject.websitemanager.R;
import com.myproject.websitemanager.login_page.LoginPage;

public class SignUpPage extends AppCompatActivity {
    private FirebaseAuth mAuth;
    SavedUserImages savedUserImages;
    FirebaseDatabase database;

    DatabaseReference mDataBase;

    ImageView userImg;
    ImageView UserImgBtn;
    Uri uri1;
    String userimgUrl, newuser;
    EditText userEditTxt, password, confirmpassword,newemail;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        mAuth = FirebaseAuth.getInstance();
        database =FirebaseDatabase.getInstance();
        mDataBase = database.getReference("Users");
        userImg = findViewById(R.id.userimg_id);
        UserImgBtn = findViewById(R.id.userImgBtn_id);
        userEditTxt = findViewById(R.id.NewuserName_id);

        ActivityResultLauncher<Intent> activityResultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                    uri1 = data.getData();
                }
                userImg.setImageURI(uri1);

            } else {
                Toast.makeText(SignUpPage.this, "NO Image Selected", Toast.LENGTH_LONG).show();
            }
        });
        UserImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                activityResultLauncher1.launch(i);


            }
        });
        newemail = findViewById(R.id.e1);
        confirmpassword = findViewById(R.id.p1);
        password = findViewById(R.id.password_id);
        TextView gotologin = findViewById(R.id.gologin);

        gotologin.setOnClickListener(view -> {
            Intent back = new Intent(this, LoginPage.class);
            startActivity(back);
            finish();
        });

        add = findViewById(R.id.add1);
                add.setOnClickListener(view -> {
                    try {
                        String val1 = newemail.getText().toString();
                    String val2 = confirmpassword.getText().toString();
                    mAuth.createUserWithEmailAndPassword(val1, val2)
                            .addOnCompleteListener(SignUpPage.this, task -> {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    Toast.makeText(SignUpPage.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                                    Intent main = new Intent(SignUpPage.this, LoginPage.class);
                                    saveimg();
                                    startActivity(main);
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    // If sign in fails, display a message to the user.
                                    newemail.setError("Enter Email Address Properly");
                                    confirmpassword.setError("Enter Atleat 6 password character");
                                }
                            });
                    }catch (Exception e){
                        newemail.setError("Enter Email Address Properly");
                        userEditTxt.setError("Your Name Field Is Empty");
                        confirmpassword.setError("Enter Atleat 6 password character");
                    }

                });


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do You Want To Save Changes")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    FirebaseAuth.getInstance().signOut();
                    finish();
                }).setNegativeButton("NO", (dialogInterface, i) -> dialogInterface.cancel());
        builder.create();
        builder.show();

    }

    private void saveimg() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("Users")
                .child(uri1.getLastPathSegment());
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpPage.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_dialog);
        AlertDialog dialog = builder.create();
        dialog.show();
        storageReference.putFile(uri1).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask1 = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask1.isComplete());
                Uri urlimage1 = uriTask1.getResult();
                userimgUrl = urlimage1.toString();
                uploadData();
                SignUpPage.this.uploadData();
                dialog.dismiss();
            }
        }).addOnFailureListener(e -> dialog.dismiss());
    }

    private void uploadData() {
        String KeyId = mDataBase.push().getKey();
        newuser = userEditTxt.getText().toString();
        SavedUserImages saveduserImagesclass = new SavedUserImages(userimgUrl,newuser,newemail.getText().toString());
        try {
            mDataBase.child(KeyId).setValue(saveduserImagesclass)
                    .addOnCompleteListener(task -> {
                        if (task.isComplete()) {
                            userEditTxt.setText("");
                            newemail.setText("");
                            userImg.setImageResource(R.drawable.ic_baseline_account_circle_24);
                            Toast.makeText(SignUpPage.this, "Created SuccessFully", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }).addOnFailureListener(e -> Toast.makeText(SignUpPage.this, e.getMessage(), Toast.LENGTH_SHORT).show());
        }catch(Exception e){
            Toast.makeText(this, "Sorry Cannot Create Page....", Toast.LENGTH_SHORT).show();
        }


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