package com.example.zavalas.formulariobien;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {
    EditText nombre, edad ;
    TextView textView;
    RadioGroup sexo;
    DatePicker fecha;
    String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembrev", "Diciembre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClic(View view) {
        nombre = (EditText) findViewById(R.id.etnombre);
        edad = (EditText) findViewById(R.id.etedad);
        fecha = (DatePicker) findViewById(R.id.txtFecha);
        sexo = (RadioGroup) findViewById(R.id.rbGenero);

        int id= sexo.getCheckedRadioButtonId();
        View radioButton = sexo.findViewById(id);
        int radioId = sexo.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) sexo.getChildAt(radioId);
        String sexo = (String) btn.getText();

        String texto ="\n Nombre: "+ nombre.getText()+"\n Edad: "+edad.getText()+" años \n Fecha Nac.: "+fecha.getDayOfMonth()+" de "+MONTHS[fecha.getMonth()]+", "+fecha.getYear()+
                "\n Genero: "+sexo;



        Intent i = new Intent(this,MainActivity2Activity.class);
        Bundle bun = new Bundle();
        bun.putString("NOMBRE",texto);
        i.putExtras(bun);
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
