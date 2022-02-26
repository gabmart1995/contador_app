package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int counter = 0;

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se inicializa los elementos del xml
        textResult = ( TextView ) findViewById( R.id.contador_pulsaciones );
    }

    public void incrementCounter( View view ) {
        counter++;
        textResult.setText( "" + counter );
    }

    public void decrementCounter( View view ) {

        CheckBox checkNegative = ( CheckBox ) findViewById( R.id.negtives );

        if ( counter > 0 ) {
            counter--;

        } else {

            if ( !checkNegative.isChecked() ) {
                counter = 0;

            } else  {
                counter--;

            }
        }

        textResult.setText( "" + counter );
    }

    public void resetCounter( View view ) {

        EditText textNumber = ( EditText ) findViewById( R.id.n_reset );

        try {
            // getText obtiene un Objeto Editable a String con toString
            counter = Integer.parseInt( textNumber.getText().toString() );

        } catch ( Exception error ) {
            counter = 0;

        }

        // limpiamos el campo de texto
        textNumber.setText( "" );
        textResult.setText( "" + counter );
    }
}