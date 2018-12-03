package com.example.dmajr_nbsa.projetomobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalActivity extends AppCompatActivity {
    private Button bt_novojogo,bt_sair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        bt_novojogo = (Button)findViewById(R.id.btnNovoJogo);
        bt_sair = (Button)findViewById(R.id.btnSair);
        NovoJogo();
        Sair();
    }

    private void NovoJogo(){
        bt_novojogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void Sair(){
        bt_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(FinalActivity.this, MainActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |    Intent.FLAG_ACTIVITY_CLEAR_TASK);
                //startActivity(intent);
                //finish();
                finishAffinity();
            }
        });
    }
}