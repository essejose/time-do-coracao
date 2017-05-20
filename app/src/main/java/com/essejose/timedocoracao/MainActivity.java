package com.essejose.timedocoracao;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout nameValue;
    private TextInputLayout idadeValue;
    private Spinner timesValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameValue = (TextInputLayout) findViewById(R.id.nameValue);
        idadeValue = (TextInputLayout) findViewById(R.id.idadeValue);
        timesValue = (Spinner) findViewById(R.id.sptimes);

    }

    public void cadastrar(View v) {


        Intent intencaoConfirmar = new Intent(MainActivity.this,
                ConfirmacaoActivity.class);

        intencaoConfirmar.putExtra("NOME", nameValue.getEditText().getText().toString());
        intencaoConfirmar.putExtra("IDADE",idadeValue.getEditText().getText().toString());
        intencaoConfirmar.putExtra("TIME",timesValue.getSelectedItem().toString());


        startActivity(intencaoConfirmar);


    }


}
