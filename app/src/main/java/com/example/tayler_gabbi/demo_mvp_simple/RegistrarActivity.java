package com.example.tayler_gabbi.demo_mvp_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tayler_gabbi.demo_mvp_simple.model.PresenterRegistrarImpl;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.RegistrarPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.RegistrarView;

public class RegistrarActivity extends AppCompatActivity implements RegistrarView{

    private EditText nombre,usuario,contrasenia;
    private Button btnRegistrar;
    private RegistrarPresenter registrarPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nombre = findViewById(R.id.edit_text_name);
        usuario = findViewById(R.id.edit_text_usuario);
        contrasenia = findViewById(R.id.edit_text_password);
        btnRegistrar = findViewById(R.id.button_register_ingresar);
        registrarPresenter = new PresenterRegistrarImpl(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nombre.getText().toString();
                String usu = usuario.getText().toString();
                String pass = contrasenia.getText().toString();

                registrarPresenter.registrarUsuario(name,usu,pass);

            }
        });


    }

    @Override
    public void registrarSuccess() {

        Toast.makeText(this,"usuario registrado",Toast.LENGTH_LONG).show();

    }

    @Override
    public void nameError() {

        Toast.makeText(this,"Ingrese nombre",Toast.LENGTH_LONG).show();

    }

    @Override
    public void usuarioError() {

        Toast.makeText(this,"Ingrese nombre de usuario",Toast.LENGTH_LONG).show();

    }

    @Override
    public void passwordError() {

        Toast.makeText(this,"Ingrese  Contraseña",Toast.LENGTH_LONG).show();

    }
}
