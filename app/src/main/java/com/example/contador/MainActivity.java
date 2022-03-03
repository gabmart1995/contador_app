package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int counter = 0;

    TextView textResult;

    class EventKeyboard implements TextView.OnEditorActionListener {

        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

            if ( actionId == EditorInfo.IME_ACTION_DONE ) {
                resetCounter( null );
            }

            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se inicializa los elementos del xml
        textResult = ( TextView ) findViewById( R.id.contador_pulsaciones );

        // como crear eventos
        EventKeyboard eventKeyboard = new EventKeyboard();
        EditText n_reset = (EditText) findViewById( R.id.n_reset );
        n_reset.setOnEditorActionListener( eventKeyboard );
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

        // obtenemos una instancia del teclado y cerramos
        InputMethodManager keyboard = (InputMethodManager) getSystemService( INPUT_METHOD_SERVICE );
        keyboard.hideSoftInputFromWindow( textNumber.getWindowToken(), 0 );
    }
}