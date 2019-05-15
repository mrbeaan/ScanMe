package ead.mobile.scan_me.Class;

/**
 * Created by GL552VW on 24/04/2019.
 */

public class Absence {
    private String id,nama,tanggal,pukul;

    public Absence(String id, String nama, String tanggal, String pukul) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.pukul = pukul;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getPukul() {
        return pukul;
    }
}
