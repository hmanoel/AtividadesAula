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

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button bt_scan;
    private TextView rtl_name, rtl_address;
    private IntentIntegrator code_qr;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_scan = findViewById(R.id.bt_scan);
        rtl_name = findViewById(R.id.rtl_name);
        rtl_address = findViewById(R.id.rtl_address);
        code_qr = new IntentIntegrator(this);
        bt_scan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {

        code_qr.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        IntentResult aftermath = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(aftermath == null)
        {

            super.onActivityResult(requestCode, resultCode, data);

        }
        else
        {

            if(!(aftermath.getContents() == null))
            {

                try
                {

                    JSONObject code = new JSONObject(aftermath.getContents());
                    rtl_name.setText(code.getString("name"));
                    rtl_address.setText(code.getString("address"));

                }
                catch (JSONException e)
                {

                    e.printStackTrace();
                    Toast.makeText(this, aftermath.getContents(), Toast.LENGTH_LONG).show();

                }

            }
            else
            {

                Toast.makeText(this, "Result not found", Toast.LENGTH_LONG).show();

            }

        }
    }

}
