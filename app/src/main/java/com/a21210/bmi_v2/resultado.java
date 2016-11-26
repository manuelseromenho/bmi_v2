package com.a21210.bmi_v2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import static com.a21210.bmi_v2.R.id.response;


public class resultado extends Fragment {

    private static TextView textview;
    private static Button button_resultado;
    TextView response_resultado;
    TableRow tr;
    TableLayout tl;
    double resultado_double;

    String resultado_string = "";

    private OnFragmentInteractionListener resultadoListener;
    public interface OnFragmentInteractionListener
    {
        void imageClick(double resultado_bmi);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);

        //textview = (TextView) view.findViewById(R.id.id_resultado);
        //button_resultado = (Button) view.findViewById(R.id.id_button_result);

        final Button button_resultado = (Button) view.findViewById(R.id.id_button_result);
        button_resultado.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                imageButton(v);
            }
        });



        //textview.setVisibility(View.INVISIBLE);
        button_resultado.setVisibility(View.INVISIBLE);



        return view;
    }

    /*public resultado()
    {// Required empty public constructor
    }*/

    public void calculoBMI(double altura, double peso, int but_vis)
    {

        response_resultado = (TextView) getActivity().findViewById(R.id.response);
        tl = (TableLayout) getActivity().findViewById(R.id.table_layout);


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

            response_resultado.setText(".     .");


            for(int i = 0, j = tl.getChildCount(); i < j; i++) {
                View view = tl.getChildAt(i);
                if (view instanceof TableRow) {
                    TableRow row = (TableRow) view;
                    row.setBackgroundColor(Color.TRANSPARENT);
                }
            }


            if(resultado_double < 16)
            {
                tr = (TableRow)getActivity().findViewById(R.id.table_row2);
                tr.setBackgroundColor(Color.RED);
            }
            else if (resultado_double >= 16 && resultado_double < 18.5 )
               {
                   tr = (TableRow)getActivity().findViewById(R.id.table_row3);
                   tr.setBackgroundColor(Color.RED);
               }
            else if (resultado_double >= 18.5 && resultado_double < 24.99 )
               {
                   tr = (TableRow)getActivity().findViewById(R.id.table_row4);
                   tr.setBackgroundColor(Color.RED);
               }
            else if (resultado_double >= 24.99 && resultado_double < 29.99 )
               {
                   tr = (TableRow)getActivity().findViewById(R.id.table_row5);
                   tr.setBackgroundColor(Color.RED);
               }
            else if (resultado_double >= 29.99 && resultado_double < 34.99)
               {
                   tr = (TableRow)getActivity().findViewById(R.id.table_row6);
                   tr.setBackgroundColor(Color.RED);
               }
            else if (resultado_double >= 34.99 && resultado_double < 39.99 )
               {
                   tr = (TableRow)getActivity().findViewById(R.id.table_row7);
                   tr.setBackgroundColor(Color.RED);
               }
            else if (resultado_double >= 39.99)
               {
                   tr = (TableRow)getActivity().findViewById(R.id.table_row8);
                   tr.setBackgroundColor(Color.RED);
               }
        }






        //textview.setText(String.valueOf(resultado_double));

        //Toast.makeText(getActivity(), "this is my Toast message!!! =)", Toast.LENGTH_SHORT).show();

    }

    public void imageButton(View view)
    {
        if (resultadoListener != null) {
            resultadoListener.imageClick(resultado_double);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            resultadoListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        resultadoListener = null;
    }




}
