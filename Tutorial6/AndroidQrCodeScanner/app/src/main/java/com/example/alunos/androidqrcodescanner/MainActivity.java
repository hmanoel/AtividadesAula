package com.example.alunos.androidqrcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Inteface
    private Button btScan;
    private TextView lblNome, lblEndereco;
    //Scanner
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btScan = findViewById(R.id.bt_scan);
        lblNome = findViewById(R.id.lbl_nome);
        lblEndereco = findViewById(R.id.lbl_endereco);
        qrScan = new IntentIntegrator(this);
        btScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Result not found", Toast.LENGTH_LONG).show();
            }else{
                try {
                    JSONObject obj = new JSONObject(result.getContents());
                    lblNome.setText(obj.getString("name"));
                    lblEndereco.setText(obj.getString("address"));

                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
