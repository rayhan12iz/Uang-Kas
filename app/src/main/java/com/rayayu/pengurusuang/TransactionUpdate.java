package com.rayayu.pengurusuang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TransactionUpdate extends AppCompatActivity {
    EditText edtName_new;
    EditText edtAmount_new;
    EditText edtDescription_new;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_update);

        edtName_new = (EditText) findViewById(R.id.new_nama);
        edtAmount_new = (EditText) findViewById(R.id.edt_amount_new);
        edtDescription_new = (EditText) findViewById(R.id.edt_description_new);

    }

    public void newTransaction(View view) {

        String name = edtName_new.getText().toString();
        int amount = Integer.parseInt(edtAmount_new.getText().toString());
        String description = edtDescription_new.getText().toString();
        DatabaseHelper database = new DatabaseHelper(this);
        database.update( name, amount, description);
        Toast.makeText(this, "Transaksi "+name+" berhasil disimpan", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(TransactionUpdate.this, TransactionList.class));
        finish();


    }
}