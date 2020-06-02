package com.rayayu.pengurusuang;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class TransactionDetail extends AppCompatActivity {
    private Transaction transaction;
    private TextView txtName;
    private TextView txtType;
    private TextView txtAmount;
    private TextView txtDescription;
    private TextView txtid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
        txtName = (TextView) findViewById(R.id.txt_name);
        txtType = (TextView) findViewById(R.id.txt_type);
        txtAmount = (TextView) findViewById(R.id.txt_amount);
        txtDescription = (TextView) findViewById(R.id.txt_description);
        Intent intent = getIntent();
        transaction = (Transaction) intent.getSerializableExtra("transaction.detail");
        txtName.setText(transaction.getName());
        txtType.setText(transaction.stringType());
        txtAmount.setText(Integer.toString(transaction.getAmount()));
        txtDescription.setText(transaction.getDescription());

        Button updateTransaction = (Button) findViewById(R.id.updateTransaction);
        updateTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dataForm = new Intent(getBaseContext(), TransactionUpdate.class);
                startActivity(dataForm);
            }
        });

    }

    public void delTransaction(View view){
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.deleteTransaction(transaction);
        finish();
    }


}
