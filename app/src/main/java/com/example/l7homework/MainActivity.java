package com.example.l7homework;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer firstOperand, secondOperand, difference, product, qutient, sum;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberclicked(View view) {
        String number = ((MaterialButton) view).getText().toString();
        if (number.equals("AC")) {
            textView.setText("0");
            firstOperand = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClicked(View view) {
        String number = ((MaterialButton) view).getText().toString();
        switch (number) {
            case "+":
                firstOperand = Integer.valueOf(textView.getText().toString());
                operation = "+";
                break;
            case "-":
                firstOperand = Integer.valueOf(textView.getText().toString());
                operation = "-";
                break;
            case "X":
                firstOperand = Integer.valueOf(textView.getText().toString());
                operation = "X";
                break;
            case "/":
                firstOperand = Integer.valueOf(textView.getText().toString());
                operation = "/";
                break;
            case "=":
                secondOperand = Integer.valueOf(textView.getText().toString());
                switch (operation) {
                    case "+":
                        sum = firstOperand + secondOperand;
                        textView.setText(sum.toString());
                        break;
                    case "-":
                        difference = firstOperand - secondOperand;
                        textView.setText(difference.toString());
                        break;
                    case "X":
                        product = firstOperand * secondOperand;
                        textView.setText(product.toString());
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            qutient = firstOperand / secondOperand;
                            textView.setText(qutient.toString());
                        } else {

                        }
                        break;
                }
        }
        isOperationClick = true;
    }
}