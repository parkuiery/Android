package com.example.recyclerviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstaanceState){
        super.onCreate(savedInstaanceState);
        setContentView(R.layout.activity_secound_activity);

        TextView itemNumberTextView = findViewById(R.id.itemNumberTextView);

        Intent intent =getIntent();
        int itemNumber = intent.getIntExtra("item_number",-1);

        itemNumberTextView.setText("Item Number: " + itemNumber);
    }


}
