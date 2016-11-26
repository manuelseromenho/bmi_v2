package com.a21210.bmi_v2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class imagem extends AppCompatActivity {

    String image_value;
    ImageView imgview;
    Double resultado_double;

    public imagem(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagem);

        imgview = (ImageView)findViewById(R.id.imageView1);
        Bundle extras = getIntent().getExtras();



        try {
            if (extras != null) {
                image_value = extras.getString("bmi_value");
                //The key argument here must match that used in the other activity
            }
            Log.d("hello", "try here!");

        } catch (NumberFormatException e) {
            Toast.makeText(this, "this is my Toast message!!! =)", Toast.LENGTH_SHORT).show();
            Log.d("hello", "Erro!");
        }

        resultado_double = Double.parseDouble(image_value);

        if(resultado_double < 16)
        {
            imgview.setImageResource(R.drawable.bmiimg5);
        }
        else if (resultado_double >= 16 && resultado_double < 18.5 )
        {
            imgview.setImageResource(R.drawable.bmiimg5);
        }
        else if (resultado_double >= 18.5 && resultado_double < 24.99 )
        {
            imgview.setImageResource(R.drawable.bmiimg4);
        }
        else if (resultado_double >= 24.99 && resultado_double < 29.99 )
        {
            imgview.setImageResource(R.drawable.bmiimg3);
        }
        else if (resultado_double >= 29.99 && resultado_double < 34.99)
        {
            imgview.setImageResource(R.drawable.bmiimg3);
        }
        else if (resultado_double >= 34.99 && resultado_double < 39.99 )
        {
            imgview.setImageResource(R.drawable.bmiimg2);
        }
        else if (resultado_double >= 39.99)
        {
            imgview.setImageResource(R.drawable.bmiimg1);
        }
    }

    public void website_click(View view) {
        // Do something in response to button click
        String url = "http://inforzen.com/temporario/a21210/pdm/index.php?bmi=" + String.format("%.2f",resultado_double);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}
