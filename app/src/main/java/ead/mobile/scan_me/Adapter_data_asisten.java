package ead.mobile.scan_me;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GL552VW on 24/04/2019.
 */

public class Adapter_data_asisten extends RecyclerView.Adapter<Adapter_data_asisten.ViewHolder> {

    private ArrayList<Item_data_asisten_list> item_data_asisten_lists;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txt_nama_asisten, txt_kode_asisten, txt_riwayat_tanggal, txt_riwayat_pukul;

        public ViewHolder(View itemView) {
            super(itemView);
            this.txt_nama_asisten = itemView.findViewById(R.id.nama_asisten);
            this.txt_kode_asisten = itemView.findViewById(R.id.kode_asisten);
            this.txt_riwayat_tanggal = itemView.findViewById(R.id.riwayat_tanggal);
            this.txt_riwayat_pukul  = itemView.findViewById(R.id.riwayat_pukul);
        }
    }

    public Adapter_data_asisten(ArrayList<Item_data_asisten_list> item_data_asisten_lists) {
        this.item_data_asisten_lists = item_data_asisten_lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_absence_asisten, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item_data_asisten_list currentItem = item_data_asisten_lists.get(position);

        holder.txt_nama_asisten.setText(currentItem.getNamaAsisten());
        holder.txt_kode_asisten.setText(currentItem.getKodeAsisten());
        holder.txt_riwayat_tanggal.setText(currentItem.getRiwayatTanggal());
        holder.txt_riwayat_pukul.setText(currentItem.getRiwayatPukul());
    }

    @Override
    public int getItemCount() {
        return item_data_asisten_lists.size();
    }
}
