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
 * Created by GL552VW on 18/04/2019.
 */

public class Adapter_absence extends RecyclerView.Adapter<Adapter_absence.ViewHolder> {
    private ArrayList<Item_absence_list> mitem_absence_list;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView namaAsisten, kode, pukul, id;

        public ViewHolder(View itemView) {
            super(itemView);
            this.id = itemView.findViewById(R.id.id_asisten);
//            this.imageView = itemView.findViewById(R.id.icon_person);
            this.namaAsisten = itemView.findViewById(R.id.nama_asisten);
            this.kode = itemView.findViewById(R.id.kode_asisten);
            this.pukul = itemView.findViewById(R.id.jam_absence);
        }
    }

    public Adapter_absence(ArrayList<Item_absence_list> mitem_absence_list) {
        this.mitem_absence_list = mitem_absence_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_absence_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item_absence_list current_item = mitem_absence_list.get(position);

//        holder.imageView.setImageResource(current_item.getImgResource());
        holder.id.setText(current_item.getTxtid());
        holder.namaAsisten.setText(current_item.getTxtNamaAsisten());
        holder.kode.setText(current_item.getTxtKode());
        holder.pukul.setText(current_item.getTxtPukul());
    }

    @Override
    public int getItemCount() {
        return mitem_absence_list.size();
    }


}
