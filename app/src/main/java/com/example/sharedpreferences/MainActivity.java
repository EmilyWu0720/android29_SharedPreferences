package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void savebtn(View view){

        EditText nameField = findViewById(R.id.nameField);
        EditText phoneField = findViewById(R.id.phoneField);
        EditText sexField = findViewById(R.id.sexField);

        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences sharedPreferences= getSharedPreferences("Data", Context.MODE_PRIVATE);
        /**取得SharedPreferences.Editor編輯內容*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /**放入字串，並定義索引為"Saved"*/
        editor.putString("name",nameField.getText().toString());
        editor.putString("phone",phoneField.getText().toString());
        editor.putString("sex",sexField.getText().toString());
        editor.commit();

    }

    public void readbtn(View view){
        TextView nameField = findViewById(R.id.nameField);
        TextView phoneField = findViewById(R.id.phoneField);
        TextView sexField = findViewById(R.id.sexField);
        
        nameField.setText(readDataname());
        phoneField.setText(readDataphone());
        sexField.setText(readDatasex());

    }
    public String readDataname(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return sharedPreferences.getString("name","未存任何資料");
    }
    public String readDataphone(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return sharedPreferences.getString("phone","未存任何資料");
    }
    public String readDatasex(){
        /**創建SharedPreferences，索引為"Data"*/
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        /**回傳在"Saved"索引之下的資料；若無儲存則回傳"未存任何資料"*/
        return sharedPreferences.getString("sex","未存任何資料");
    }

    public void clearbtn(View view){
        /**創建SharedPreferences*/
        SharedPreferences sharedPreferences = getSharedPreferences("Data",Context.MODE_PRIVATE);
        /**取得SharedPreferences.Editor*/
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /**利用clear清除掉所有資料*/
        editor.clear();
        /**不返回結果的提交*/
        /**若需要提交結果，則可使用.commit()*/
        editor.apply();

    }
}