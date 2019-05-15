package ead.mobile.scan_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Stuff_list_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff_list);
    }

    public void newStuff(View view) {
        startActivity(new Intent(this, New_stuff_activity.class));
    }

    public void stuffList(View view) {
        startActivity(new Intent(this, Content_stuff_list_activity.class));
    }
}
