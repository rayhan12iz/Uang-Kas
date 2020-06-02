package com.rayayu.pengurusuang;

import android.provider.BaseColumns;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;

public class Transaction implements Serializable, BaseColumns {
    public static final int PENGELUARAN = 1;
    public static final int PEMASUKAN = 1;
    private static String id;
    private String name;
    private int type;
    private int amount;
    private String description;
    public Transaction(String id, String name, int type, int amount, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
    public static String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String stringType(){
        if (this.type == PEMASUKAN)
            return "Pengeluaran";
        else
            return "Pemasukan";
    }
    @Override
    public String toString() {
        return this.name+" ["+this.stringType()+"] : "+this.amount;
    }

    public static final String TABLE_NAME = "transactions";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_TYPE = "type";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_DESCRIPTION = "description";
    public static final String SQL_CREATE = "create table transactions " +
            "(_id integer primary key autoincrement, "+
            "name text, type integer, amount integer, description text)";
    public static final String SQL_DELETE = "drop table if exists transactions";




}