package ead.mobile.scan_me;

/**
 * Created by GL552VW on 15/04/2019.
 */

public class Item_stuff_list {
    private int mImageResource;
    private String txtNama,txtStatus;

    public Item_stuff_list(int mImageResource, String txtNama, String txtStatus) {
        this.mImageResource = mImageResource;
        this.txtNama = txtNama;
        this.txtStatus = txtStatus;
    }

    public int getmImageResource(){

        return mImageResource;
    }

    public String getTxtNama(){
        return txtNama;
    }

    public String getTxtStatus(){
        return txtStatus;
    }
}
