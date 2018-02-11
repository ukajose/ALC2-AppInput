package com.example.android.appinput;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String result;
    String result2;
    String result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displaySurname() {
        EditText edit = (EditText) findViewById(R.id.surname);
        TextView EditView = (TextView) findViewById(R.id.surname);
        result = edit.getText().toString();
        EditView.setText(result);
    }

    private void displaymidname() {
        EditText edit = (EditText) findViewById(R.id.midname);
        TextView EditView = (TextView) findViewById(R.id.midname);
        result1 = edit.getText().toString();
        EditView.setText(result1);
    }

    private void displayLastname() {
        EditText edit = (EditText) findViewById(R.id.lastname);
        TextView EditView = (TextView) findViewById(R.id.lastname);
        result2 = edit.getText().toString();
        EditView.setText(result2);
    }

    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }

    public void sendMessage(View view) {
        displayLastname();
        displaymidname();
        displaySurname();
        String priceMsg = createOrderSummary();
        //displayMessage(priceMsg);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, priceMsg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(priceMsg);
    }

    private String createOrderSummary() {

        String priceMsg = "Name: " + result + "\nSubject  " + result1 + "\nMessage ? :  " + result2 + "\nThank You !! ";
        return priceMsg;
    }

}
