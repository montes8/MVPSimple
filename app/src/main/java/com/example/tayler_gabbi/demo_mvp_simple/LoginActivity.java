package com.example.tayler_gabbi.demo_mvp_simple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tayler_gabbi.demo_mvp_simple.database.ConexionSQLiteHelper;
import com.example.tayler_gabbi.demo_mvp_simple.model.PresenterImpl;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.LoginPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private EditText edNombre,edPassword;
    private Button btLogearse;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edNombre = findViewById(R.id.edit_usuario);
        edPassword = findViewById(R.id.edit_pasword);
        btLogearse = findViewById(R.id.button_ingresar);

        final ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"database",null,1);

        loginPresenter = new PresenterImpl(this);

        btLogearse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = edNombre.getText().toString();
                String contrasenia = edPassword.getText().toString();

                loginPresenter.perfomLogin(usuario,contrasenia,conn);


            }
        });

    }

    @Override
    public void loginValidations() {

        Toast.makeText(this,"Ingrese Usuario y Contraseña",Toast.LENGTH_LONG).show();

    }

    @Override
    public void loginSuccess() {

        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginError() {

        Toast.makeText(this,"Usuario o congraseña Invalido",Toast.LENGTH_LONG).show();
    }
}
