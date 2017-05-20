package com.essejose.timedocoracao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmacaoActivity extends AppCompatActivity {


    private TextView ConfirmacaoTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        ConfirmacaoTxt = (TextView) findViewById(R.id.ConfirmacaoTxt);

        if (getIntent() != null) {
            String nome = getIntent().getStringExtra("NOME");
            String idade = getIntent().getStringExtra("IDADE");
            String time = getIntent().getStringExtra("TIME");

            ConfirmacaoTxt.setText(
                    getString(R.string.confirmacao_cadastro, nome, time, idade)
            );
        }

    }
}
