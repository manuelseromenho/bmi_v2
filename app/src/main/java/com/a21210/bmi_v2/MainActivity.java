package com.a21210.bmi_v2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity
        implements dados.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
    }

    public void onButtonClick(double altura, double peso)
    {
        resultado resultado = (resultado)getSupportFragmentManager().findFragmentById(R.id.fragment2);

        resultado.calculoBMI(altura,peso);

        //Toast.makeText(this, "this is my Toast message!!! =)", Toast.LENGTH_SHORT).show();

        //Context context = getApplicationContext();
        /*CharSequence texty = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this,texty, duration);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0, 400);
        toast.show();*/


    }


}
