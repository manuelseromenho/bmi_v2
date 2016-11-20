package com.a21210.bmi_v2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class MainActivity
        extends FragmentActivity
        implements dados.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
