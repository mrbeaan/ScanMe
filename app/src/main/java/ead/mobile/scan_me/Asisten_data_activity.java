package ead.mobile.scan_me;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ead.mobile.scan_me.Class.Absence;

public class Asisten_data_activity extends AppCompatActivity {

    private TextView nim,pukul,tanggal,nama;
    private String mnim,mpukul,mtanggal;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private FirebaseDatabase databaseAsisten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asisten_data);

        databaseAsisten = FirebaseDatabase.getInstance();

        nama = (TextView)findViewById(R.id.nama_asisten);
        nim = (TextView)findViewById(R.id.nim);
        pukul = (TextView)findViewById(R.id.pukul);
        tanggal =(TextView)findViewById(R.id.tanggal) ;

        Intent intent = getIntent();
        mnim = intent.getStringExtra("nim");
        mpukul = intent.getStringExtra("pukul");
        mtanggal = intent.getStringExtra("date");

        nim.setText(mnim);
        pukul.setText(mpukul);
        tanggal.setText(mtanggal);

        //Class List
        ArrayList<Item_data_asisten_list> item_data_asisten_lists = new ArrayList<>();
        item_data_asisten_lists.add(new Item_data_asisten_list("Revandika Pratama","RVD", "21/07/2019","19:45"));
        item_data_asisten_lists.add(new Item_data_asisten_list("Revandika Pratama","RVD", "21/07/2019","19:45"));
        item_data_asisten_lists.add(new Item_data_asisten_list("Revandika Pratama","RVD", "21/07/2019","19:45"));
        item_data_asisten_lists.add(new Item_data_asisten_list("Revandika Pratama","RVD", "21/07/2019","19:45"));
        item_data_asisten_lists.add(new Item_data_asisten_list("Revandika Pratama","RVD", "21/07/2019","19:45"));


        //RecyclerView
        recyclerView = findViewById(R.id.recyclerView_data_asisten);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter_data_asisten(item_data_asisten_lists);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Home_activity.class));
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseAsisten.getReference("asistenList").child(mnim).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    nama.setText(dataSnapshot.child("Nama").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void acceptAbsen(View view) {
        Absence absence = new Absence(mnim,nama.getText().toString(),mtanggal,mpukul);
        databaseAsisten.getReference("absenceList").child(mtanggal).child(mnim).setValue(absence);
        Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
    }
}
