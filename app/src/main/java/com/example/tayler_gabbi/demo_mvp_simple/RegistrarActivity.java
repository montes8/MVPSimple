package com.example.tayler_gabbi.demo_mvp_simple;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tayler_gabbi.demo_mvp_simple.database.ConexionSQLiteHelper;
import com.example.tayler_gabbi.demo_mvp_simple.model.PresenterRegistrarImpl;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.RegistrarPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.RegistrarView;

public class RegistrarActivity extends AppCompatActivity implements RegistrarView{

    private EditText nombre,usuario,contrasenia;
    private Button btnRegistrar;
    private RegistrarPresenter registrarPresenter;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nombre = findViewById(R.id.edit_text_name);
        usuario = findViewById(R.id.edit_text_usuario);
        contrasenia = findViewById(R.id.edit_text_password);
        btnRegistrar = findViewById(R.id.button_register_ingresar);
        registrarPresenter = new PresenterRegistrarImpl(this);



        Toolbar toolbars = (Toolbar) findViewById(R.id.toolbar_register);
        setSupportActionBar(toolbars);
        getSupportActionBar().setTitle("Formulario de registro");
        toolbars.setNavigationIcon(R.drawable.ic_atras);
        toolbars.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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
        conn = new ConexionSQLiteHelper(this,"database",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre",nombre.getText().toString());
        values.put("usuario",usuario.getText().toString());
        values.put("contrasenia",contrasenia.getText().toString());

        Long idResultante = db.insert("USUARIO","id",values);

            Toast.makeText(this,"usuario registrado"+idResultante,Toast.LENGTH_LONG).show();



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
