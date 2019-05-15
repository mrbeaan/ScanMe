package ead.mobile.scan_me;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GL552VW on 15/04/2019.
 */

public class Adapter_stuff extends RecyclerView.Adapter<Adapter_stuff.ViewHolder> {
    private ArrayList<Item_stuff_list> mitem_stuff_lists;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_ic;
        public TextView nama_barang, status_barang;

        public ViewHolder(View itemView) {
            super(itemView);
            img_ic = itemView.findViewById(R.id.img_icon);
            nama_barang = itemView.findViewById(R.id.nama_barang);
            status_barang = itemView.findViewById(R.id.status_barang);
        }
    }

    public Adapter_stuff(ArrayList<Item_stuff_list> item_stuff_lists) {
        mitem_stuff_lists = item_stuff_lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stuff_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item_stuff_list current_item = mitem_stuff_lists.get(position);

        holder.img_ic.setImageResource(current_item.getmImageResource());
        holder.nama_barang.setText(current_item.getTxtNama());
        holder.status_barang.setText(current_item.getTxtStatus());
    }

    @Override
    public int getItemCount() {
        return mitem_stuff_lists.size() ;
    }
}
