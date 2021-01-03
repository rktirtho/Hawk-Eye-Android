package com.rktirtho.hawkeye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText etUserName, etPassword;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidate()){
                    String userName = etUserName.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();
                    boolean isLogin = true;
                    String token="";
//                    User user = new User();
                    // send json request


                    if(isLogin){
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this, "Username on Password mismatch", Toast.LENGTH_SHORT)
                                .show();
                    }
                }

            }
        });
    }


    private void init(){
        etUserName = findViewById(R.id.input_email);
        etPassword = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);
    }

    private boolean isValidate(){
        if (etUserName.getText().toString().trim() ==  "" ){
            etUserName.setError("Required");
            return false;
        }else if(etPassword.getText().toString().trim() == ""){
            etPassword.setError("Required");
            return false;
        }
        return true;
    }

}