package com.example.tayler_gabbi.demo_mvp_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

import com.example.tayler_gabbi.demo_mvp_simple.model.PresenterImpl;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.LoginPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private EditText edNombre,edPassword;
    private Button btLogearse;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = findViewById(R.id.edit_usuario);
        edPassword = findViewById(R.id.edit_pasword);
        btLogearse = findViewById(R.id.button_ingresar);

        loginPresenter = new PresenterImpl(this);

        btLogearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = edNombre.getText().toString();
                String contrasenia = edPassword.getText().toString();

                loginPresenter.perfomLogin(usuario,contrasenia);


            }
        });

    }

    @Override
    public void loginValidations() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginError() {

    }
}
