package ead.mobile.scan_me;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class Splash_screen_activity extends AppCompatActivity {

    public static int Splash_Time = 4000;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAuth.getCurrentUser() != null){
                    startActivity(new Intent(Splash_screen_activity.this,Home_activity.class));
                }else {
                startActivity(new Intent(Splash_screen_activity.this, Login_activity.class));
                }
                finish();
            }
        },Splash_Time);
    }

}
