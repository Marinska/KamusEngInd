package com.umaribnuzm.kamusengindo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase   ;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class showKamus extends Activity {
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText txtInggris;
    private EditText txtIndonesia;
    private com.umaribnuzm.kamusengindo.DataKamus dataKamus = null;
    public static final String INGGRIS ="inggris";
    public static final String INDONESIA ="indonesia";
    /**Called when the activity is first created.*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataKamus = new com.umaribnuzm.kamusengindo.DataKamus(this);
        db = dataKamus.getWritableDatabase();
        dataKamus.createTable(db);
        dataKamus.generateData(db);
        setContentView(R.layout.activity_main);
        txtInggris = (EditText)
                findViewById(R.id.txtInggris);
        txtIndonesia = (EditText)
                findViewById(R.id.txtIndonesia);
    }
    public void getTerjemahan(View view){
        String result = "";
        String englishword = txtInggris.getText().toString();
        kamusCursor = db.rawQuery("SELECT ID, INGGRIS, INDONESIA"
                + " FROM kamus where INGGRIS='"+
                englishword
                + "' ORDER BY INGGRIS", null);
        if (kamusCursor.moveToFirst()) {
            result = kamusCursor.getString(2);
            for (; !kamusCursor.isAfterLast();
                 kamusCursor.moveToNext()) {
                result = kamusCursor.getString(2);
            }
        }
        if(result.equals("")) {
            result = "Terjemahan Not Found";
        }
        txtIndonesia.setText(result);
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        kamusCursor.close();
        db.close();
    }
}
