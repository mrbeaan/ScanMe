package ead.mobile.scan_me;

/**
 * Created by GL552VW on 24/04/2019.
 */

public class Item_data_asisten_list {
    private String namaAsisten, kodeAsisten, riwayatTanggal, riwayatPukul;

    public Item_data_asisten_list(String namaAsisten, String kodeAsisten, String riwayatTanggal, String riwayatPukul) {
        this.namaAsisten = namaAsisten;
        this.kodeAsisten = kodeAsisten;
        this.riwayatTanggal = riwayatTanggal;
        this.riwayatPukul = riwayatPukul;
    }

    public String getNamaAsisten() {
        return namaAsisten;
    }

    public String getKodeAsisten() {
        return kodeAsisten;
    }

    public String getRiwayatTanggal() {
        return riwayatTanggal;
    }

    public String getRiwayatPukul() {
        return riwayatPukul;
    }
}
