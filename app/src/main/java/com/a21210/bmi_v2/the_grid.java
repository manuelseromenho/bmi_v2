package com.a21210.bmi_v2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class the_grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_grid);

        ListView listView1;

        listView1 = (ListView) findViewById(R.id.list_grid_id);

            try {
                //String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/bmi.txt";
                String filePath = "/storage/emulated/0/Android/data/com.a21210.bmi_v2/files/sdcard/bmi.txt";
                //Toast.makeText(this, filePath, Toast.LENGTH_SHORT).show();
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "Cp1252"), 100);

                String line;
                ArrayList<String> lines = new ArrayList<String>();
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }

                br.close();

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lines);


                listView1.setAdapter(adapter);


            } catch (Exception e) {
                e.printStackTrace();
            }

        //Toast.makeText(this, "TEST List Button", Toast.LENGTH_SHORT).show();
    }
}
