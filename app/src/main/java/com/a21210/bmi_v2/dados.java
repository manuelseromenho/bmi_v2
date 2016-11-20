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
import android.widget.Toast;


public class dados extends Fragment {

    private static EditText altura_text;
    private static EditText peso_text;

    String altura_string;
    String peso_string;

    double altura_double = 0;
    double peso_double = 0;


    private OnFragmentInteractionListener mListener;
    public interface OnFragmentInteractionListener
    {
        public void onButtonClick(double altura, double peso);
    }

    public dados() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dados,container,false);

        final Button button = (Button) view.findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onButtonPressed(v);
            }
        });


        return view;
    }

    public void onButtonPressed(View view) {

        //The data is extracted only after the button being pressed
        altura_text = ((EditText)getView().findViewById(R.id.editText5));
        peso_text = ((EditText)getView().findViewById(R.id.editText6));

        altura_string = altura_text.getText().toString();
        peso_string = peso_text.getText().toString();


        Log.d("HELLO", "this is altura" + altura_string);
        Log.d("HELLO", "this is peso" + peso_string);

        try {
            altura_double = Double.parseDouble(altura_string);
            peso_double = Double.parseDouble(peso_string);
        } catch (NumberFormatException e) {
            Log.v("Alerta!!", "Erro!");
        }

        if (mListener != null) {
            mListener.onButtonClick(altura_double, peso_double);
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
