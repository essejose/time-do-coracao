package com.essejose.timedocoracao;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextInputLayout nameValue;
    private TextInputLayout idadeValue;
    private Spinner timesValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameValue = (TextInputLayout) findViewById(R.id.nameValue);
        idadeValue = (TextInputLayout) findViewById(R.id.idadeValue);
        timesValue = (Spinner) findViewById(R.id.sptimes);

    }

    public void cadastrar(View v) {

        Intent intencaoConfirmar = new Intent(MainActivity.this,
                ConfirmacaoActivity.class);


        if(TextUtils.isEmpty(nameValue.getEditText().getText().toString())){
            Toast.makeText(this,"informe seu nome",Toast.LENGTH_LONG).show();

        }else if(TextUtils.isEmpty(idadeValue.getEditText().getText().toString())){
            Toast.makeText(this,"informe seu idade",Toast.LENGTH_LONG).show();

        }else if(timesValue.getSelectedItem().toString() == "Selecione o time" ){
            Toast.makeText(this,"informe seu time",Toast.LENGTH_LONG).show();

        }else{
            intencaoConfirmar.putExtra("NOME", nameValue.getEditText().getText().toString());
            intencaoConfirmar.putExtra("IDADE",idadeValue.getEditText().getText().toString());
            intencaoConfirmar.putExtra("TIME",timesValue.getSelectedItem().toString());

            startActivity(intencaoConfirmar);
        }




    }


}
