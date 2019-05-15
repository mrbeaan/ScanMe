package ead.mobile.scan_me;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

public class Login_activity extends AppCompatActivity {

    private EditText et_user,et_pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        et_user = (EditText)findViewById(R.id.etxt_username);
        et_pass = (EditText)findViewById(R.id.etxt_password);


    }



    public void login(View view) {

//        Toast.makeText(Login_activity.this, "Mohon tunggu..", Toast.LENGTH_SHORT).show();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String email = et_user.getText().toString().trim();
        String password = et_pass.getText().toString().trim();

        System.out.println(email);
        System.out.println(password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(Login_activity.this, Home_activity.class));
                            finish();

                            //                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
//                            Toast.makeText(Login_activity.this, task.getException().getMessage(),
//                                    Toast.LENGTH_SHORT).show();
                            Log.d("UNIK",task.getException().getMessage());
//                            updateUI(null);
                        }
                        progressDialog.dismiss();
                        // ...
                    }
                });


    }
}
