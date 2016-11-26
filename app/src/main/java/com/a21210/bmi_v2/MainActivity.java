package com.a21210.bmi_v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity
        extends AppCompatActivity
        implements dados.OnFragmentInteractionListener, resultado.OnFragmentInteractionListene
{
    private String filename = "bmi.txt";
    public String filepath = "/sdcard";
    File myExternalFile;
    String myData = "";
    String texto_string = "";
    TextView response;

    private static EditText altura_text ;
    private static EditText peso_text;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        response = (TextView) findViewById(R.id.response);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_accessibility);
    }

    public void onButtonClick(double altura, double peso, int but_vis)
    {
        resultado resultado = (resultado)getSupportFragmentManager().findFragmentById(R.id.fragment2);

        resultado.calculoBMI(altura,peso,but_vis);

        //utilizado para esconder o teclado após o click no botão calcular
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);






        //Toast.makeText(this, "this is my Toast message!!! =)", Toast.LENGTH_SHORT).show();

        //Context context = getApplicationContext();
        /*CharSequence texty = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this,texty, duration);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0, 400);
        toast.show();*/


    }

    public void SaveButton()
    {
        EditText altura_text ;
        EditText peso_text;
        TextView textview;


        String altura_string;
        String peso_string;
        String resultado_string;

        double altura_double = 0;
        double peso_double = 0;
        double resultado_double;

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String data = df.format(c.getTime());

        //The data is extracted only after the button being pressed
        altura_text = ((EditText)findViewById(R.id.editText5));
        peso_text = ((EditText)findViewById(R.id.editText6));
        //textview = (TextView) view.findViewById(R.id.id_resultado);

        altura_string = altura_text.getText().toString();
        peso_string = peso_text.getText().toString();

        //Toast.makeText(this, data + " Altura = " + altura_string + " Peso = " + peso_string, Toast.LENGTH_SHORT).show();

        Button saveButton;
        saveButton = (Button) findViewById(R.id.button2);
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveButton.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
            response.setText(myExternalFile.toString());
        }

        try {
            altura_double = Double.parseDouble(altura_string);
            peso_double = Double.parseDouble(peso_string);

            resultado_double = peso_double/Math.pow((altura_double/100),2);
            //resultado_string= String.valueOf(resultado_double);
            resultado_string = String.format("%.2f",resultado_double);
            //texto_string = data + altura_string + " " + peso_string + " " + resultado_string + "\n";
            texto_string = data + " " + resultado_string + "\n";
            //Toast.makeText(this, texto_string, Toast.LENGTH_SHORT).show();

            //
            try {
                FileOutputStream fos = new FileOutputStream(myExternalFile, true);
                fos.write(texto_string.getBytes());
                fos.close();
                response.setText("Gravado em" + myExternalFile.toString());
            } catch (IOException e) {
                e.printStackTrace();
                response.setText("Erro na gravação!!");
            }


            //Log.d("hello", "try here!");
        } catch (NumberFormatException e) {
            response.setText("Dados errados!!");
            //Log.d("hello", "Erro!");
            //necessário forçar as variáveis altura_double e peso_double a 0.0,
            //pois caso contrário seria utilizado o valor anterior da caixa de texto
            //em que tem um caracter diferente de número (comportamento do android, não propositado)
            altura_double = 0.0;
            peso_double = 0.0;
        }
    }

    public void ListButton()
    {
        //Toast.makeText(this, "TEST List Button", Toast.LENGTH_SHORT).show();
        Intent lista = new Intent(MainActivity.this,the_grid.class);
        startActivity(lista);
    }

    public void imageClick(double resultado_bmi)
    {
        Intent imagem_intent = new Intent(MainActivity.this,imagem.class);

        String resultado_bmi_string = String.valueOf(resultado_bmi);
        imagem_intent.putExtra("bmi_value",resultado_bmi_string);
        startActivity(imagem_intent);
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }



}
