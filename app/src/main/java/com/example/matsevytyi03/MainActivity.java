package com.example.matsevytyi03;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    private String inpt1;

    private String inpt2;

    private String operator;

    double result;

    InputMethodManager inputMethodManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.outputWindow);
        display.setFocusable(false);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        inpt1 = "0";
        inpt2 = "0";
        operator = "";
        result = 0;



    }

    public void hideKeyboard(View view) {
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        clear(view);
    }

    private void clearField(){
        if(display.getText().toString().contains("n") || display.getText().toString().contains("N")) display.setText("");
    }

    public void inpt0(View view) {
        clearField();
        display.setText(display.getText() + "0");
    }

    public void inpt1(View view) {
        clearField();
        display.setText(display.getText() + "1");
    }

    public void inpt2(View view) {
        clearField();
        display.setText(display.getText() + "2");
    }

    public void inpt3(View view) {
        clearField();
        display.setText(display.getText() + "3");
    }

    public void inpt4(View view) {
        clearField();
        display.setText(display.getText() + "4");
    }

    public void inpt5(View view) {
        clearField();
        display.setText(display.getText() + "5");
    }

    public void inpt6(View view) {
        clearField();
        display.setText(display.getText() + "6");
    }

    public void inpt7(View view) {
        clearField();
        display.setText(display.getText() + "7");
    }

    public void inpt8(View view) {
        clearField();
        display.setText(display.getText() + "8");
    }

    public void inpt9(View view) {
        clearField();
        display.setText(display.getText() + "9");
    }

    public void addDecimalpart(View view) {
        clearField();
        display.setText(display.getText() + ".");
    }

    public void changeSign(View view) {
        inpt1 = display.getText().toString();
        result = Double.parseDouble(display.getText().toString()) * -1;
        setResult(result);
    }

    public void minus(View view) {
        inpt1 = display.getText().toString();
        operator = "-";
        display.setText("");
    }

    public void plus(View view) {
        inpt1 = display.getText().toString();
        operator = "+";
        display.setText("");
    }

    public void multiply(View view) {
        inpt1 = display.getText().toString();
        operator = "*";
        display.setText("");
    }

    public void sqrt(View view) {
        inpt1 = display.getText().toString();
        double result = Math.sqrt(Double.parseDouble(inpt1));
        setResult(result);
    }

    public void divide(View view) {
        inpt1 = display.getText().toString();
        operator = "/";
        display.setText("");
    }

    public void equals(View view) {
        inpt2 = display.getText().toString();
        switch (operator) {
            case "+":
                result = Double.parseDouble(inpt1) + Double.parseDouble(inpt2);
                break;
            case "-":
                result = Double.parseDouble(inpt1) - Double.parseDouble(inpt2);
                break;
            case "*":
                result = Double.parseDouble(inpt1) * Double.parseDouble(inpt2);
                break;
            case "/":
                result = Double.parseDouble(inpt1) / Double.parseDouble(inpt2);
                break;
        }
        operator = "";
        setResult(result);
    }

    public void backspace(View view) {
        if(display.getText().length() > 0) display.setText(display.getText().toString().substring(0, display.getText().toString().length() - 1));
    }

    public void clear(View view) {
        display.setText("");
    }

    public void setResult(double result1) {
        String strResult = String.valueOf(result1);

        strResult = strResult.replaceAll("(\\.\\d*?)0*$", "$1");
        if(strResult.endsWith(".")) strResult = strResult.substring(0, strResult.length() - 1);
        if(strResult.length() > 13) strResult = strResult.substring(0, 13);
        display.setText(strResult);
    }




}