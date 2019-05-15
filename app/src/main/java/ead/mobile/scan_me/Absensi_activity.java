package ead.mobile.scan_me;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Absensi_activity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView zXingScannerView;
    private String time,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        zXingScannerView = new ZXingScannerView(this);
        setContentView(zXingScannerView);
    }


        @Override
    protected void onResume() {
        super.onResume();
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String mresult = String.valueOf(result);
        Intent intent = new Intent(this,Asisten_data_activity.class);
        getTime();
        getDate();
        intent.putExtra("nim",mresult);
        intent.putExtra("pukul",time);
        intent.putExtra("date", date);
        startActivity(intent);
        zXingScannerView.resumeCameraPreview(this);

//        Log.v("TAG", result.getText());
//        Log.v("TAG", result.getBarcodeFormat().toString());
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
//        builder.setMessage(result.getText());
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//        zXingScannerView.resumeCameraPreview(this);

    }

    public String getTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        time = simpleDateFormat.format(calendar.getTime());

        return time;
    }

    public String getDate(){
        Date calendar = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        date = sdf.format(calendar);
        return date;
    }
}
