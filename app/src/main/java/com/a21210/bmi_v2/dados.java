package com.a21210.bmi_v2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class dados extends Fragment {

    private static EditText altura_text ;
    private static EditText peso_text;
    private static TextView textview;

    String altura_string;
    String peso_string;

    double altura_double = 0;
    double peso_double = 0;


    private OnFragmentInteractionListener mListener;
    public interface OnFragmentInteractionListener
    {
        public void onButtonClick(double altura, double peso);
        public void SaveButton();
    }

    public dados() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dados,container,false);
        final Button button = (Button) view.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onButtonPressed(v);
            }
        });

        final Button button_save = (Button) view.findViewById(R.id.button2);
        button_save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onButtonSaved(v);
            }
        });

        return view;
    }

    public void onButtonPressed(View view) {

        //The data is extracted only after the button being pressed
        altura_text = ((EditText)getView().findViewById(R.id.editText5));
        peso_text = ((EditText)getView().findViewById(R.id.editText6));
        //textview = (TextView) view.findViewById(R.id.id_resultado);


        altura_string = altura_text.getText().toString();
        peso_string = peso_text.getText().toString();


        Log.d("hello", "this is altura" + altura_string);
        Log.d("hello", "this is peso" + peso_string);

        try {
            altura_double = Double.parseDouble(altura_string);
            peso_double = Double.parseDouble(peso_string);
            Log.d("hello", "try here!");
        } catch (NumberFormatException e) {
            Log.d("hello", "Erro!");
            //necessário forçar as variáveis altura_double e peso_double a 0.0,
            //pois caso contrário seria utilizado o valor anterior da caixa de texto
            //em que tem um caracter diferente de número (comportamento do android, não propositado)
            altura_double = 0.0;
            peso_double = 0.0;
            //textview.setText("HELLO");
        }

        if (mListener != null) {
            mListener.onButtonClick(altura_double, peso_double);
        }
    }

    public void onButtonSaved(View view){

        if (mListener != null) {
            mListener.SaveButton();
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
