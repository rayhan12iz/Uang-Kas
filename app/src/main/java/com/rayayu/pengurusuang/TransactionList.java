package com.rayayu.pengurusuang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TransactionList extends AppCompatActivity {
    private ArrayList<Transaction> transList = new ArrayList<>();

    ArrayAdapter adapter;
    ListView transactionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        transactionList = (ListView) findViewById(R.id.list_transactions);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, transList);
        transactionList.setAdapter(adapter);

        transactionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),
                        TransactionDetail.class);
                intent.putExtra("transaction.detail", transList.get(position));
                startActivity(intent);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        transList = (ArrayList<Transaction>) dbHelper.getTransactions();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, transList);
        transactionList.setAdapter(adapter);
    }


    }

