package ead.mobile.scan_me;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Absence_List_activity extends AppCompatActivity {

    private TextView selectDate;
    private DatePickerDialog datePickerDialog;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    ArrayList<Item_absence_list> item_absence_lists;
    DatabaseReference databaseAbsence;

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absence__list);
        selectDate = (TextView)findViewById(R.id.txt_date);

        //Database
        databaseAbsence = FirebaseDatabase.getInstance().getReference("absenceList");

        item_absence_lists = new ArrayList<>();

//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));
//        item_absence_lists.add(new Item_absence_list(R.drawable.ic_person,"Revandika Pratama S","RVD","15:00"));


        mRecyclerView = findViewById(R.id.recyclerView_absence);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter        = new Adapter_absence(item_absence_lists);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        //Date
        Date dates = Calendar.getInstance().getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateNow = sdf.format(dates);
        selectDate.setText(dateNow);
    }

    public void selectDate(View view) {
        final Calendar calendar = Calendar.getInstance();
        int mYear   = calendar.get(Calendar.YEAR);
        final int mMonth  = calendar.get(Calendar.MONTH);
        int mDay    = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(Absence_List_activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String [] monthName = {"January", "February",
                        "March", "April", "May", "June", "July",
                        "August", "September", "October", "November",
                        "December"};

                String nameMonth = monthName[mMonth];
                date = dayOfMonth +" - "+ nameMonth +" - "+year;
                selectDate.setText(date);
            }
        },mDay,mMonth,mYear);
        datePickerDialog.show();

//        retrieveData();

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseAbsence.child(selectDate.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot absenceDatasnapshot : dataSnapshot.getChildren()){
                        Item_absence_list item_absence_list = absenceDatasnapshot.getValue(Item_absence_list.class);

                        item_absence_lists.add(item_absence_list);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
