package com.testingsomestuff.shanedinozzo.testingsomestuff;

//import android.app.AlertDialog;
import android.content.Context;
//import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    static float eredmeny;
    static String vegeredmeny;

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
        _eredmeny(eredmeny);

        Log.i("_gombNyomas metódus", "Lefutott");
    } //_gombNyomas

    public void _toast(String s, String m, float eredmeny) {
        //TODO A _toast helyett az Alert használata!

        Context context = getApplicationContext();
        Toast.makeText(context, "Magasság:  " + m + "\nSúly:             " + s +
                "\nBMI:          " + eredmeny, Toast.LENGTH_SHORT).show();

        Log.i("_toast metódus", "Lefutott");
    } //_toast

    public void _toastVegeredmeny(String vegeredmeny) {
        //TODO A _toastVegeredmeny helyett az Alert használata!

        Context context = getApplicationContext();
        Toast.makeText(context, vegeredmeny, Toast.LENGTH_SHORT).show();

        Log.i("_toastVegeredmeny metódus", "Lefutott");
    } //_toastVegeredmeny

    public float _szamolas(float _suly_, float _magassag_) {

        float mm = _magassag_ * _magassag_;
        eredmeny = _suly_ / mm;

        Log.i("_szamolas metódus", "Lefutott");

        return eredmeny;
    } //_szamolas

    public String _eredmeny(float eredmeny) {
        //TODO Megírni az eredménytáblázatot az if-ben!

        if (eredmeny < 15) {
            vegeredmeny = "Az eredmény kisebb, mint 15";

            Log.i("eredmeny IF", "Lefutott (nagyobb mint 15)");
        } else {
            vegeredmeny = "Az eredmény nagyobb mint 15";

            Log.i("_eredmeny metódus", "Kisebb mint 15");
        }

        _toastVegeredmeny(vegeredmeny);
        return vegeredmeny;
    } //_eredmeny

    // _alert is not used at this time.
    /*public void _alert() {
        //TODO Alertet csinálni az eredménnyel!
        //TODO Az Alertre MEGOSZTÁS gomb kell!

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
    } //_alert*/
} //MainActivity