package com.a21210.bmi_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class the_grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_grid);

        Toast.makeText(this, "TEST List Button", Toast.LENGTH_SHORT).show();
    }
}
