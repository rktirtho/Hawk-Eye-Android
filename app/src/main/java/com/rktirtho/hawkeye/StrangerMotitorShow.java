package com.rktirtho.hawkeye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StrangerMotitorShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stranger_motitor_show);
        int stId = getIntent().getIntExtra("stId",0);
        String stImage = getIntent().getStringExtra("stImage");
    }
}