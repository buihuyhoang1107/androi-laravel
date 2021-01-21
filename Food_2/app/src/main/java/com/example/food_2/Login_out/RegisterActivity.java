package com.example.food_2.Login_out;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.food_2.Home.MainActivity;
import com.example.food_2.Model.Nguoidung;
import com.example.food_2.R;
import com.example.food_2.remote.RegisterLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class        RegisterActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    EditText ten, email, pass, comfirm;
    Button btn_dangky;

    static final int USER_LOADER_ID = 1000;
    LoaderManager loaderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.ten = findViewById(R.id.editTen);
        this.email = findViewById(R.id.editEmail);
        this.pass = findViewById(R.id.editMatKhau);
        this.comfirm = findViewById(R.id.editNhapLaiMK);
        this.btn_dangky = findViewById(R.id.btnDangKy);

        loaderManager = LoaderManager.getInstance(this);

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterNguoiDung(v);
            }
        });

    }
    public boolean checkPass(String pass, String comfirm){
        if(pass.equals(comfirm)){
            return true;
        }
        return false;
    }
    public void RegisterNguoiDung(View view){
        if(this.ten.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Không được để trống tên !",Toast.LENGTH_SHORT).show();
        }
        else if(this.email.getText().toString().trim().matches(emailPattern) == false){
            Toast.makeText(getApplicationContext(),"email không đúng định dạng !",Toast.LENGTH_SHORT).show();
        }
        else if(this.pass.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Không được để trống mật khẩu !",Toast.LENGTH_SHORT).show();
        }
        else if(!checkPass(this.pass.getText().toString(), this.comfirm.getText().toString())){
            Toast.makeText(getApplicationContext(),"Nhập lại mật khẩu không khớp!",Toast.LENGTH_SHORT).show();
        }
        else {
            Bundle info = new Bundle();
            info.putString("ten", this.ten.getText().toString());
            info.putString("email", this.email.getText().toString());
            info.putString("pass", this.pass.getText().toString());
            if (loaderManager.getLoader(USER_LOADER_ID) == null) {

                loaderManager.initLoader(USER_LOADER_ID,info,this);
            } else {
                loaderManager.restartLoader(USER_LOADER_ID, info, this);
            }

        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new RegisterLoader(this, args.getString("ten"), args.getString("email"), args.getString("pass"));
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject2 = new JSONObject(data);
            Toast.makeText(this,"Đăng kí thành công!",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}