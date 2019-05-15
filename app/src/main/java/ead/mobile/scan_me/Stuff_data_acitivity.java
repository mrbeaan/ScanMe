package ead.mobile.scan_me;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ead.mobile.scan_me.Class.StuffData;

public class Stuff_data_acitivity extends AppCompatActivity {

    private TextView txt_id,txt_name;
    private String id,name;

    private DatabaseReference databaseStuffdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff_data);

        databaseStuffdata = FirebaseDatabase.getInstance().getReference("stuffList");

        txt_id = (TextView)findViewById(R.id.id_stuff);
        txt_name = (TextView)findViewById(R.id.stuff_name);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");

        txt_id.setText(id);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,Home_activity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseStuffdata.child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                StuffData stuffData = dataSnapshot.getValue(StuffData.class);
                if (dataSnapshot.exists()){
                    txt_name.setText(dataSnapshot.child("name").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void okData(View view) {
        startActivity(new Intent(this,Home_activity.class));
        finish();
    }

    public void updateData(View view) {
    }
}
