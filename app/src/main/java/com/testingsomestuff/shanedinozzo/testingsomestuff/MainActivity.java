package com.testingsomestuff.shanedinozzo.testingsomestuff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends ActionBarActivity {

    static float eredmeny;
    static String vegeredmeny;
    static String osztoSzoveg;
    static String nyelv;
    static String suly_s;
    static String magassag_m;
    static String megosztasEzzel;
    static String tti;
    static String magassagHiany;
    static String sulyHiany;
    static float decimalEredmeny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    } //onCreate

    public void _gombNyomas(View view) {

        final EditText suly = (EditText) findViewById(R.id.suly);
        String s = suly.getText().toString();
        final EditText magassag = (EditText) findViewById(R.id.magassag);
        String m = magassag.getText().toString();

        _nyelv();
        _magassagError(nyelv);
        _sulyError(nyelv);

        if(TextUtils.isEmpty(m)) {

            magassag.setError(magassagHiany);
            return;
        } //if TextUtils

        if(TextUtils.isEmpty(s)) {

            suly.setError(sulyHiany);
            return;
        } //if TextUtils

        float _suly_ = Float.valueOf(suly.getText().toString());
        float _magassag_ = Float.valueOf(magassag.getText().toString());

        _szamolas(_suly_, _magassag_);
        _decimal(eredmeny);
        _tti(nyelv);
        _magassag(nyelv);
        _suly(nyelv);
        _eredmeny(eredmeny);
        _osztoSzoveg(nyelv);
        _alert(s, m, decimalEredmeny, vegeredmeny, suly_s, magassag_m);
    } //_gombNyomas

    public String _magassagError(String nyelv) {

        if (nyelv.equals("magyar")){

            magassagHiany = "Add meg a magasságot!";
        } else if (nyelv.equals("angol")) {

            magassagHiany = "Enter the height!";
        } //if nyelv

        return magassagHiany;
    } //_magassagError

    public String _sulyError(String nyelv) {

        if (nyelv.equals("magyar")){

            sulyHiany = "Add meg a súlyt!";
        } else if (nyelv.equals("angol")) {

            sulyHiany = "Enter the weight!";
        } //if nyelv

        return sulyHiany;
    } //_sulyError

    public float _szamolas(float _suly_, float _magassag_) {

        float mm = _magassag_ * _magassag_;
        eredmeny = _suly_ / mm;

        return eredmeny;
    } //_szamolas

    public float _decimal(float eredmeny) {

        DecimalFormat df = new DecimalFormat("#.##");
        decimalEredmeny = Float.parseFloat(df.format(eredmeny));

        return decimalEredmeny;
    } //_decimal

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

    public void _alert(String s, String m, final float decimalEredmeny, final String vegeredmeny,
                       String suly_s, String magassag_m) {

        _megosztasEzzel(nyelv);

        final Context context = getApplicationContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(magassag_m + ": " + m + " m\n" + suly_s + ": " + s +
                " kg\n" + tti + ": " + decimalEredmeny + "\n" + vegeredmeny)
                .setTitle(R.string.uzenet_cim)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        TextView eredmenySzoveg = (TextView) findViewById(R.id.eredmenySzoveg);
                        TextView eredmenySzam = (TextView) findViewById(R.id.eredmenySzam);

                        DecimalFormat df = new DecimalFormat("#.##");
                        String decEred = String.valueOf(Float.parseFloat(df.format(eredmeny)));

                        eredmenySzoveg.setText(vegeredmeny);
                        eredmenySzam.setText(decEred);
                        Toast.makeText(context, R.string.tuuuuz, Toast.LENGTH_SHORT).show();
                    } //onClick
                }) //DialogInterface.OnClickListener
                .setNeutralButton(R.string.megosztas, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, osztoSzoveg + decimalEredmeny  +
                                ". " + vegeredmeny + ".");
                        startActivity(Intent.createChooser(intent, megosztasEzzel));
                    } //OnClick
                }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_alert
} //MainActivity
