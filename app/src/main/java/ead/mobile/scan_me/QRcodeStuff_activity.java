package ead.mobile.scan_me;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ead.mobile.scan_me.Class.StuffData;

public class QRcodeStuff_activity extends AppCompatActivity {

    private ImageView img_qr_code;
    private TextView txt_nama_barang;

    private DatabaseReference databaseStuff;

    private String v_nama,v_qr,v_id,v_type,v_merk,v_specs,v_status,v_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_stuff);
        Bitmap bmp;

        //Database
        databaseStuff = FirebaseDatabase.getInstance().getReference("stuffList");

        img_qr_code = (ImageView)findViewById(R.id.img_qr_code);
        txt_nama_barang = (TextView)findViewById(R.id.txt_nama_barang);

        Intent intent_qr = getIntent();
        v_nama  = intent_qr.getStringExtra("nama_barang");
        v_id    = intent_qr.getStringExtra("id_barang");
        v_type  = intent_qr.getStringExtra("type_barang");
        v_merk  = intent_qr.getStringExtra("merk_barang");
        v_specs = intent_qr.getStringExtra( "specs_barang");
        v_status = intent_qr.getStringExtra( "status_barang");
        v_date  = intent_qr.getStringExtra("date_barang");

        //decode array
        byte[] byteArray = getIntent().getByteArrayExtra("qr_code");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        v_qr = String.valueOf(bmp);

        txt_nama_barang.setText(v_nama);
        img_qr_code.setImageBitmap(bmp);

    }



    public void save_QR(View view) {
        StuffData stuffData = new StuffData(v_id,v_nama,v_type,v_merk,v_status,v_date,v_specs);
        databaseStuff.child(v_id).setValue(stuffData);
        Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_SHORT).show();
    }


    public void cancel_QR(View view) {
        startActivity(new Intent(QRcodeStuff_activity.this,New_stuff_activity.class));
        finish();
    }
}
