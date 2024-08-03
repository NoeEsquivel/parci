package com.example.parcial1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroUsuariosActivity extends AppCompatActivity {

    Button btnCancelar;

    EditText campoCodigo;
    EditText campoNombre;
    EditText campoCategoria;
    EditText campoPrerequisito;
    EditText campoPrimaryKey;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroUsuariosActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        campoCodigo = (EditText) findViewById(R.id.campoCodigo);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoCategoria = (EditText) findViewById(R.id.campoCategoria);
        campoPrerequisito = (EditText) findViewById(R.id.campoPrerequisito);
        campoPrimaryKey = (EditText) findViewById(R.id.campoPrimaryKey);

    }


    public void onClick(View view) {
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        examen_desweb conn=new examen_desweb(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_CODIGO,campoCodigo.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_CATEGORIA,campoCategoria.getText().toString());
        values.put(Utilidades.CAMPO_PREREQUISITO,campoPrerequisito.getText().toString());
        values.put(Utilidades.CAMPO_PRIMARYKEY,campoPrimaryKey.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_CODIGO,values);

        Toast.makeText(getApplicationContext(),"Usuario Registrado: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}