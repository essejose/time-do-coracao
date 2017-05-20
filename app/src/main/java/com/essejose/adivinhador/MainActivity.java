package com.essejose.adivinhador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etChuEditText;
    private TextView tvUltiTextView;

    private TextView nAcertosTextView;

    private TextView textViewTxt;

    private TextView nAcertosTxt, infoText;

    private int chuteJogador;
    private int numeroAleatorio;
    private int numeroAcertos;
    private Random geradorNumero;

    private ImageView iv;

    int[] imagesS = new int[]{R.drawable.s_1, R.drawable.s_2_g, R.drawable.s_3, R.drawable.s_4};
    int[] imagesN = new int[]{R.drawable.n_1, R.drawable.n_2, R.drawable.n_3, R.drawable.n_4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randon();

        etChuEditText = (EditText) findViewById(R.id.etChuteJogador);
        tvUltiTextView = (TextView) findViewById(R.id.tvUltimoChute);

        nAcertosTextView = (TextView) findViewById(R.id.nAcertos);

        nAcertosTxt = (TextView) findViewById(R.id.nAcertosTxt);
        textViewTxt = (TextView) findViewById(R.id.textView);
        infoText = (TextView) findViewById(R.id.infoText);
        iv = (ImageView) findViewById(R.id.imagePrincipal);
    }

    public void chutar(View v) {

        textViewTxt.setVisibility(View.VISIBLE);

        if (TextUtils.isEmpty(
                etChuEditText
                        .getText()
                        .toString())) {
            Toast.makeText(this, "informe seu chute", Toast.LENGTH_LONG).show();
        } else {
            chuteJogador = Integer.parseInt(etChuEditText.getText().toString());

            if (chuteJogador == numeroAleatorio) {
                //  Toast.makeText(this,"Acertou",Toast.LENGTH_SHORT).show();

                infoText.setText("Acertou! De novo ");
                //animacao();
                randon();
                trocaFoto(true);
                pontuar();
            } else if (chuteJogador > numeroAleatorio) {
                // Toast.makeText(this,"Tente um numero Menor",Toast.LENGTH_SHORT).show();
                infoText.setText("Tente um numero Menor ");
                chutarClear();
                trocaFoto(false);
            } else if (chuteJogador < numeroAleatorio) {
                infoText.setText("Tente um numero Maior ");
                chutarClear();
                trocaFoto(false);
                //Toast.makeText(this,"Tente um numero Maior",Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void randon() {
        geradorNumero = new Random();
        numeroAleatorio = geradorNumero.nextInt(11);
    }

    public void chutarClear() {

        tvUltiTextView.setText(etChuEditText
                .getText()
                .toString());

        etChuEditText.setText("");


    }

    public void trocaFoto(boolean reset) {
        int imageId = (int) (Math.random() * imagesS.length);
        if (reset) {
            iv.setImageDrawable(getResources().getDrawable(imagesS[imageId]));
        } else {
            iv.setImageDrawable(getResources().getDrawable(imagesN[imageId]));

        }
    }

    public void animacao() {
        Animation anim = AnimationUtils.loadAnimation(this,
                R.anim.animacao_splash);
        anim.reset();
        //Pegando o nosso objeto criado no layout

        if (iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);
        }
    }

    public void pontuar() {
        nAcertosTxt.setVisibility(View.VISIBLE);
        numeroAcertos = numeroAcertos + 1;
        nAcertosTextView.setText(String.valueOf(numeroAcertos));

    }
}
