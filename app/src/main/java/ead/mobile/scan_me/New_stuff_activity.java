package ead.mobile.scan_me;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class New_stuff_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText et_id_barang,et_date,et_nama_barang,et_type,et_merk,et_specs;
    private Button btn_generate;
    private ImageView img_qr;
    private DatePickerDialog mDateSetListener;
    private Spinner spinner_status;

    private String v_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_stuff);

        et_id_barang = (EditText)findViewById(R.id.etxt_id_barang);
        et_nama_barang = (EditText)findViewById(R.id.etxt_nama_barang);
        et_type     = (EditText)findViewById(R.id.et_type);
        et_merk     = (EditText)findViewById(R.id.et_merk);
        et_specs    = (EditText)findViewById(R.id.et_specs);

        btn_generate = (Button)findViewById(R.id.btn_generate_qr);

        //Calendar
        et_date  = (EditText)findViewById(R.id.et_date);

        //Spinner
        spinner_status = (Spinner)findViewById(R.id.spinner_status);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.status_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_status.setAdapter(adapter);
        spinner_status.setOnItemSelectedListener(this);
    }

    //Spinner status
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String status_barang = parent.getItemAtPosition(position).toString();
        v_status    = String.valueOf(status_barang);
//        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Generate QR
    public void generateQR(View view) {
        String id_barang = et_id_barang.getText().toString().trim();
        String nama_barang = et_nama_barang.getText().toString();
        //nonVisible
        String type_barang = et_type.getText().toString();
        String merk_barang = et_merk.getText().toString();
        String specs_barang = et_specs.getText().toString();
        String date_barang = et_date.getText().toString();


        if (id_barang != null){
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            try{
                BitMatrix bitMatrix = multiFormatWriter.encode(id_barang, BarcodeFormat.QR_CODE,
                        200, 200);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                //Intent bitmap
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();

                Intent qr_intent = new Intent(New_stuff_activity.this, QRcodeStuff_activity.class);
                qr_intent.putExtra("nama_barang",nama_barang);
                qr_intent.putExtra("qr_code", byteArray);

                //nonVisible
                qr_intent.putExtra("id_barang", id_barang);
                qr_intent.putExtra("type_barang",type_barang);
                qr_intent.putExtra("merk_barang",merk_barang);
                qr_intent.putExtra("specs_barang", specs_barang);
                qr_intent.putExtra("date_barang", date_barang);
                qr_intent.putExtra("status_barang", v_status);

                startActivity(qr_intent);


            }catch (WriterException e){
                e.printStackTrace();
            }
        }

    }

    public void date_picker(View view) {
        final Calendar calendar = Calendar.getInstance();
        int Myear = calendar.get(Calendar.YEAR);
        final int Mmonth = calendar.get(Calendar.MONTH);
        int Mday = calendar.get(Calendar.DAY_OF_MONTH);

            mDateSetListener = new DatePickerDialog(New_stuff_activity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String [] month_name = {"January", "February",
                            "March", "April", "May", "June", "July",
                            "August", "September", "October", "November",
                            "December"};

                    String monthName = month_name[Mmonth];
                    et_date.setText(dayOfMonth+" - "+monthName+" - "+year);
                }
            },Mday,Mmonth,Myear);
            mDateSetListener.show();
    }



}
