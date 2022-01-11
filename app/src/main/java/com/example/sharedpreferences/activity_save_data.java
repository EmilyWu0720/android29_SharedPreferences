package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_save_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        EditText sex = findViewById(R.id.sex);
        Button btSaved = findViewById(R.id.button_Save);
        btSaved.setOnClickListener(v -> {
            boolean ret = write(name.getText().toString());
            boolean ret2 = write(phone.getText().toString());
            boolean ret3 = write(sex.getText().toString());
            if (ret&&ret2&&ret3) finish();
            else Toast.makeText(this, "未輸入資料..", Toast.LENGTH_SHORT).show();
        });
    }
    private boolean write(String s){
        if (s.length() == 0) return false;
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences sharedPreferences= getSharedPreferences("Data", Context.MODE_PRIVATE);
        /**取得SharedPreferences.Editor編輯內容*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /**放入字串，並定義索引為"Saved"*/
        editor.putString("Saved",s);
        /**提交；提交結果將會回傳一布林值*/
        /**若不需要提交結果，則可使用.apply()*/
        return editor.commit();
    }
}