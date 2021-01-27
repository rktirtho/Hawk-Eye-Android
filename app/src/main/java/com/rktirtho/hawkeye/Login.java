package com.rktirtho.hawkeye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rktirtho.hawkeye.client.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private Button loginButton;

    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Loading ...");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String userName = etUserName.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();
                    boolean isLogin = true;
                    String token="";
//                    User user = new User();
                    // send json request

                    if (etUserName.getText().toString().trim().equals("")){
                        etUserName.setError("Required");
                        return;

                    }else if(etPassword.getText().toString().trim().equals("")){
                        etPassword.setError("Required");
                        return;
                    }else {

//                        progressDoalog.show();
                        Call<Boolean> call = RetrofitClient.getInstance()
                        .getSecurityService().login(userName, password);



                        call.enqueue(new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                if(response.isSuccessful()){
                                    if (response.body() == true){
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        progressDoalog.dismiss();
                                    }else{
                                        Toast.makeText(Login.this, "Wrong Username or password ", Toast.LENGTH_SHORT).show();
                                        progressDoalog.dismiss();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                progressDoalog.dismiss();
                            }
                        });

                    }

            }
        });
    }


    private void init(){
        etUserName = findViewById(R.id.input_email);
        etPassword = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);
    }


}