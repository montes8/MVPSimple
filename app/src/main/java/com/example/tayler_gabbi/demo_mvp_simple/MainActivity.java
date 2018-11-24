package com.example.tayler_gabbi.demo_mvp_simple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button onClickSesion,onClickReistarte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickSesion =  (Button) findViewById(R.id.button_sesion);
        onClickReistarte = (Button)findViewById(R.id.button_register);

        onClickSesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        onClickReistarte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intents = new Intent(MainActivity.this,RegistrarActivity.class);
                startActivity(intents);
            }
        });
    }
}
