package ead.mobile.scan_me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Content_stuff_list_activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_stuff_list);

        ArrayList<Item_stuff_list> Item_stuff_lists = new ArrayList<>();
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_locker,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_locker,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_computer,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_locker,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_computer,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_locker,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_computer,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_computer,"Nama Barang", "Good"));
        Item_stuff_lists.add(new Item_stuff_list(R.drawable.ic_locker,"Nama Barang", "Good"));

        mRecyclerView = findViewById(R.id.recyclerView_stuff);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new Adapter_stuff(Item_stuff_lists);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
