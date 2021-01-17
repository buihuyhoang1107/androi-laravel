package com.example.food_2.Login_out;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.example.food_2.Home.MainActivity;
import com.example.food_2.R;
import com.example.food_2.remote.LoginLoader;
import com.example.food_2.Model.Nguoidung;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{
    EditText userName, edPassword;
    TextView btnDangKy;
    Button btnDangNhap;
    String UserName, Password;

    static final int USER_LOADER_ID = 1000;
    LoaderManager loaderManager;

    public static Nguoidung  nguoidung = new Nguoidung();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_person);
        userName = (EditText) findViewById(R.id.editDangNhap_Email);
        edPassword = (EditText) findViewById(R.id.editDangNhap_MK);
        btnDangNhap = (Button) findViewById(R.id.btnLogin);
        btnDangKy = (TextView) findViewById(R.id.btnDangKy);

        loaderManager = LoaderManager.getInstance(this);


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginNguoiDung(v);
            }
        });
    }
    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Yêu cầu nhập tài khoản", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Yêu cầu nhập mật khẩu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void Dangky(View view) {
                Intent downloadIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivities(new Intent[]{downloadIntent});
    }
    public void LoginNguoiDung(View view){
        this.UserName = userName.getText().toString();
        this.Password = edPassword.getText().toString();
        if (validateLogin(UserName,Password))
        {
            Bundle info = new Bundle();
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
        return new LoginLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            JSONArray itemsArray = new JSONArray(data);

            if(itemsArray.length() > 0){
                int flag = 0;
                for (int i = 0; i < itemsArray.length(); i++)
                {
                    JSONObject jsonObject2 = itemsArray.getJSONObject(i);
                    if(this.UserName.equals(jsonObject2.getString("gmail")) &&
                            this.Password.equals(jsonObject2.getString("matkhau")) &&
                            jsonObject2.getString("phanquyen").equals("0"))
                    {
                        nguoidung.setId(jsonObject2.getInt("id"));
                        nguoidung.setTen(jsonObject2.getString("ten"));
                        nguoidung.setGmail(jsonObject2.getString("gmail"));
                        nguoidung.setMatkhau(jsonObject2.getString("matkhau"));
                        nguoidung.setPhanquyen(jsonObject2.getInt("phanquyen"));
                        nguoidung.setAction(jsonObject2.getInt("action"));
                        flag = 1;
                        break;
                    }
                }
                if(flag > 0){
                    Toast.makeText(this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this,"Đăng nhập thất bại!",Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this,"Tài khoản hoặc mật khẩu không chính xác!",Toast.LENGTH_SHORT).show();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}