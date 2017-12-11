package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.username)
    TextInputLayout username;

    @BindView(R.id.password)
    TextInputLayout password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validaUsuario();
            }
        });

        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validaPassword();

            }
        });


    }

    @OnClick(R.id.btConectar)
    public void conectar(){


        if ( validaUsuario()  && validaPassword() ) {
            Intent pxTela = new Intent(this, MainActivity.class);

            pxTela.putExtra("USERNAME", username.getEditText().getText().toString());

            startActivity(pxTela);

        }




    }

    private boolean validaPassword() {
        if (password.getEditText().getText().toString().isEmpty()){
            password.setError("Password não informado");
            return false;
        }else {
            password.setError(null);
            return true;
        }
    }

    private boolean validaUsuario() {
        if (username.getEditText().getText().toString().isEmpty()){
            username.setError("Login não informado");
            return false;
        }else {
            username.setError(null);
            return true;
        }
    }
}
