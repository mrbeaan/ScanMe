package ead.mobile.scan_me;

import android.widget.ImageView;

/**
 * Created by GL552VW on 18/04/2019.
 */

public class Item_absence_list {
    private int imgResource,txtid;
    private String txtNamaAsisten, txtKode, txtPukul;

    public Item_absence_list(int id, String txtNamaAsisten, String txtKode, String txtPukul) {
//        this.imgResource = imgResource;
        this.txtid = id;
        this.txtNamaAsisten = txtNamaAsisten;
        this.txtKode = txtKode;
        this.txtPukul = txtPukul;
    }

//    public int getImgResource() {
//        return imgResource;
//    }


    public int getTxtid() {
        return txtid;
    }

    public String getTxtNamaAsisten() {
        return txtNamaAsisten;
    }

    public String getTxtKode() {
        return txtKode;
    }

    public String getTxtPukul() {
        return txtPukul;
    }
}
