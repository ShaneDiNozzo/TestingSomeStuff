package com.testingsomestuff.shanedinozzo.testingsomestuff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    static float eredmeny;
    static String vegeredmeny;
    static String osztoSzoveg;
    static String nyelv;
    static String suly_s;
    static String magassag_m;
    static String megosztasEzzel;
    static String tti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } //onCreate

    public void _gombNyomas(View view) {

        EditText suly = (EditText) findViewById(R.id.suly);
        float _suly_ = Float.valueOf(suly.getText().toString());
        String s = suly.getText().toString();
        EditText magassag = (EditText) findViewById(R.id.magassag);
        float _magassag_ = Float.valueOf(magassag.getText().toString());
        String m = magassag.getText().toString();

        _szamolas(_suly_, _magassag_);
        _nyelv();
        _tti(nyelv);
        _magassag(nyelv);
        _suly(nyelv);
        _eredmeny(eredmeny);
        _osztoSzoveg(nyelv);
        _alert(s, m, eredmeny, vegeredmeny, suly_s, magassag_m);
    } //_gombNyomas

    public float _szamolas(float _suly_, float _magassag_) {

        float mm = _magassag_ * _magassag_;
        eredmeny = _suly_ / mm;

        return eredmeny;
    } //_szamolas

    public String _nyelv() {

        Button gomb = (Button) findViewById(R.id.szamitas_gomb);

        String buttonText = gomb.getText().toString();

        if (buttonText.equals("Calculate")) {

            nyelv = "angol";
        } else if (buttonText.equals("Kiszámít")) {

            nyelv = "magyar";
        } //if buttonText

        return nyelv;
    } //_nyelv

    public String _osztoSzoveg(String nyelv) {

        if (nyelv.equals("angol")) {

            osztoSzoveg = "I calculated my BMI with the BMI Calculator app. My result is ";
        } else if (nyelv.equals("magyar")) {

            osztoSzoveg = "Kiszámoltam a TTI-met a TTI kalkulátor appal. Az eredményem ";
        } //if buttonText

        return osztoSzoveg;
    } //_osztoSzoveg

    public String _tti(String nyelv) {

        if (nyelv.equals("magyar")) {

            tti = "TTI";
        } else if (nyelv.equals("angol")) {

            tti = "BMI";
        } //if nyelv

        return tti;
    } //_suly

    public String _suly(String nyelv) {

        if (nyelv.equals("magyar")) {

            suly_s = "Súly";
        } else if (nyelv.equals("angol")) {

            suly_s = "Weight";
        } //if nyelv

        return suly_s;
    } //_suly

    public String _magassag(String nyelv) {

        if (nyelv.equals("magyar")) {

            magassag_m = "Magasság";
        } else if (nyelv.equals("angol")) {

            magassag_m = "Height";
        } //if nyelv

        return magassag_m;
    } //_magassag

    public String _eredmeny(float eredmeny) {

        if (eredmeny <= 16) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "Súlyos soványság";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Very severely underweight";
            } //if nyelv
        } else if (eredmeny >= 16 && eredmeny <= 16.99) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "Mérsékelt soványság";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Severely underweight";
            } //if nyelv
        } else if (eredmeny >= 17 && eredmeny <= 18.49) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "Enyhe soványság";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Underweight";
            } //if nyelv
        } else if (eredmeny >= 18.5 && eredmeny <= 24.99) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "Normális testsúly";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Normal (healthy weight)";
            } //if nyelv
        } else if (eredmeny >= 25 && eredmeny <= 29.99) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "Túlsúlyos";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Overweight";
            } //if nyelv
        } else if (eredmeny >= 30 && eredmeny <= 34.99) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "I. fokú elhízás";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Obese Class I (Moderately obese)";
            } //if nyelv
        } else if (eredmeny >= 35 && eredmeny <= 39.99) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "II. fokú elhízás";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Obese Class II (Severely obese)";
            } //if nyelv
        } else if (eredmeny >= 40) {

            if (nyelv.equals("magyar")) {

                vegeredmeny = "III. fokú elhízás";
            } else if (nyelv.equals("angol")) {

                vegeredmeny = "Obese Class III (Very severely obese)";
            } //if nyelv
        } //if eredmeny

        return vegeredmeny;
    } //_eredmeny

    public String _megosztasEzzel(String nyelv) {

        if (nyelv.equals("magyar")) {

            megosztasEzzel = "Megosztás ezzel";
        } else if (nyelv.equals("angol")) {

            megosztasEzzel = "Share via";
        } //if nyelv

        return megosztasEzzel;
    } //_megosztasEzzel

    public void _alert(String s, String m, final float eredmeny, final String vegeredmeny, String suly_s, String magassag_m) {

        _megosztasEzzel(nyelv);

        final Context context = getApplicationContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(magassag_m + ": " + m + " m\n" + suly_s + ": " + s +
                " kg\n" + tti + ": " + eredmeny + "\n" + vegeredmeny)
                .setTitle(R.string.uzenet_cim)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Toast.makeText(context, R.string.tuuuuz, Toast.LENGTH_SHORT).show();
                    } //onClick
                }) //DialogInterface.OnClickListener
                .setNeutralButton(R.string.megosztas, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, osztoSzoveg + eredmeny + ". " + vegeredmeny);
                        startActivity(Intent.createChooser(intent, megosztasEzzel));
                    } //OnClick
                }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_alert
} //MainActivity
