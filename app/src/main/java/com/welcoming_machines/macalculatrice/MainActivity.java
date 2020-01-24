package com.welcoming_machines.macalculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private TextView screen;
    private int op1=0;
    private int op2=0;
    private String operator=null;
    private boolean isOp1=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.screen);
        Button btnEgal = (Button)findViewById(R.id.btnEgal);
        btnEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
            }
        });

    }

    private void updateDisplay() {
        int v=op1;
        if(!isOp1) {
            v=op2;
        }

        screen.setText(String.format("%9d",v));
    }


    public void compute() {
        if(isOp1) {
            // do nothing
        } else {
            switch(operator) {
                case "+"  : op1 = op1 + op2; break;
                case "-" : op1 = op1 - op2; break;
                case "*"  : op1 = op1 * op2; break;
                case "/"   : op1 = op1 / op2; break;
                default : return; // do nothing if no operator
            }

            op2 = 0;
            isOp1 = true;
            updateDisplay();
        }
    }

    public void setOperator(View v) {
        switch (v.getId()) {
            case R.id.btnPlus  : operator="+";  break;
            case R.id.btnMoins : operator="-"; break;
            case R.id.btnFois  : operator="*";  break;
            case R.id.btnDiv   : operator="/";   break;
            default :
                Toast.makeText(this, "Opérateur non reconnu",Toast.LENGTH_LONG);
                return; // do nothing if no operator
        }
        isOp1=false;
        updateDisplay();
    }

}
