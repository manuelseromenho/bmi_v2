package com.a21210.bmi_v2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.a21210.bmi_v2.R.id.response;


public class resultado extends Fragment {

    private static TextView textview;
    private static Button button_resultado;
    TextView response_resultado;

    String resultado_string = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        textview = (TextView) view.findViewById(R.id.id_resultado);
        button_resultado = (Button) view.findViewById(R.id.id_button_result);



        textview.setVisibility(View.INVISIBLE);
        button_resultado.setVisibility(View.INVISIBLE);



        return view;
    }

    public void calculoBMI(double altura, double peso, int but_vis)
    {
        double resultado_double;
        response_resultado = (TextView) getActivity().findViewById(R.id.response);



        //Caso os valores das caixas de texto sejam diferentes de um número,
        //indica messagem de erro, caso os valores sejam números, procede-se
        //ao calculo

        //textview.setText(String.format("%.2f - %.2f", altura, peso)) ;
        if(altura == 0.0 || peso == 0.0 || altura == 0 || peso == 0 )
        {
            //textview.setText("Errado!");
            //button_resultado.setText("Errado");
            response_resultado.setText("Altura ou Peso incorrectos!");
            button_resultado.setVisibility(View.INVISIBLE);
        }
        else
        {
            resultado_double = peso/Math.pow((altura/100),2);
            //resultado_string= String.valueOf(resultado_double);
            //Log.d("HELLO", resultado_string);
            //textview.setText(String.format("%.2f",resultado_double));
            button_resultado.setText("Click!! -> " + String.format("%.2f",resultado_double));
            button_resultado.setVisibility(View.VISIBLE);

        }






        //textview.setText(String.valueOf(resultado_double));

        //Toast.makeText(getActivity(), "this is my Toast message!!! =)", Toast.LENGTH_SHORT).show();

    }


}
