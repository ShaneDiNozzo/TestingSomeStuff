package com.testingsomestuff.shanedinozzo.testingsomestuff;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    static Float eredmeny;

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
        String m = suly.getText().toString();

        _szamolas(_suly_, _magassag_);
        _toast(s, m, eredmeny);
    } //_gombNyomas

    public void _toast(String s, String m, float eredmeny) {

        Context context = getApplicationContext();
        Toast.makeText(context, "Magasság:  " + m + "\nSúly:             " + s +
                "\nBMI:          " + eredmeny, Toast.LENGTH_SHORT).show();
    } //_toast

    public float _szamolas(float _suly_, float _magassag_) {

        float mm = _magassag_ * _magassag_;
        eredmeny = _suly_ / mm;

        return eredmeny;
    } //_szamolas

    // _alert is not used at this time.
    public void _alert() {

        final Context context = getApplicationContext();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_fire_missiles)
                .setTitle(R.string.uzenet_cim)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, R.string.tuuuuz, Toast.LENGTH_SHORT).show();
                    } //onClick
                }) //DialogInterface.OnClickListener
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, R.string.visszavonulas, Toast.LENGTH_SHORT).show();
                    } //OnClick
                }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_alert
} //MainActivity