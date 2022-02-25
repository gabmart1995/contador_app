package com.example.contador;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incrementCounter( View view ) {
        counter++;
        showResult();
    }

    public void decrementCounter( View view ) {
        if ( counter > 0 ) {
            counter--;
            showResult();
        }
    }

    public void resetCounter( View view ) {
        counter = 0;
        showResult();
    }

    public void showResult() {
        TextView textResult = ( TextView ) findViewById( R.id.contador_pulsaciones );
        textResult.setText( "Contador " + counter );
    }
}