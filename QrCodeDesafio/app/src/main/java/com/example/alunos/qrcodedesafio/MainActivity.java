package com.example.alunos.qrcodedesafio;

import android.content.Intent;

import android.net.Uri;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{    

    private Button btn_scan;
    private TextView rtl_nome, rtl_endereco;
    private IntentIntegrator qrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_scan = findViewById(R.id.btn_scan);
        rtl_nome = findViewById(R.id.rtl_nome);
        rtl_endereco = findViewById(R.id.rtl_endereco);
        qrScan = new IntentIntegrator(this);
        btn_scan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {

        qrScan.initiateScan();

    }

    @Override
    protected void onActivityResult(int request, int result, Intent data)
    {

        IntentResult resultado = IntentIntegrator.parseActivityResult(request, result, data);

        if (resultado != null) {

            try{

                JSONObject obj = new JSONObject(resultado.getContents());
                rtl_nome.setText(obj.getString("name"));
                rtl_endereco.setText(obj.getString("address"));

            }
            catch (JSONException e)
            {

                String string = resultado.getContents();

                if(!((string.indexOf("http://www")!=0) && (string.indexOf(".com")!=0)))
                {
                    e.printStackTrace();
                    Toast.makeText(this, resultado.getContents(), Toast.LENGTH_LONG).show();

                }
                else
                {

                    Intent intencao = new Intent(Intent.ACTION_VIEW, Uri.parse(string.toLowerCase()));
                    startActivity(intencao);

                }
            }
        }
        else
        {

            super.onActivityResult(request, result, data);

        }
    }



}
