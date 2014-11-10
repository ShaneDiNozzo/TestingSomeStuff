package com.testingsomestuff.shanedinozzo.testingsomestuff;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void _gombNyomas(View view) {
        Context context = getApplicationContext();
        Toast.makeText(context, "Megnyomtad a gombot", Toast.LENGTH_SHORT).show();
    }
}