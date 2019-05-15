package ead.mobile.scan_me;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scan_stuff_activity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;
    private TextView txt_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_stuff);

        txt_id = (TextView)findViewById(R.id.stuff_name);

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
        Intent intent = new Intent(this, Stuff_data_acitivity.class);
        intent.putExtra("ID",mresult);
        startActivity(intent);
        zXingScannerView.resumeCameraPreview(this);
    }
}
