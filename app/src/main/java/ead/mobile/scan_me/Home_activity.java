package ead.mobile.scan_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home_activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser ;

    private TextView txt_name;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        user = firebaseUser.getEmail().toString();

        txt_name = (TextView)findViewById(R.id.txt_username);

//        actoin-bar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarHome);
        setSupportActionBar(toolbar);

        txt_name.setText(user);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_edit_profile :
//                startActivity(new Intent(Home_activity.this, Edit_profile_activity.class));
                Intent intent = new Intent(this, Edit_profile_activity.class);
                startActivity(intent);
                return true;
            case R.id.menu_logout :
                startActivity(new Intent(Home_activity.this, Login_activity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void stuffList(View view) {
        startActivity(new Intent(this, Stuff_list_activity.class));
    }

    public void absenceList(View view) {startActivity( new Intent(this, Absence_List_activity.class));
    }

    public void absence(View view) {startActivity(new Intent(this,Absensi_activity.class));
    }

    public void scanStuff(View view) {startActivity(new Intent(this, Scan_stuff_activity.class));
    }

    public void menu(View view) {
        mAuth.signOut();
        startActivity(new Intent(this,Login_activity.class));
        finish();
    }

    public String position(){
        String position = null;

//        if (user ==)

        return position;
    }
}
