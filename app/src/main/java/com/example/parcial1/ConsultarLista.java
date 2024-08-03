package com.example.parcial1;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class ConsultarLista extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    examen_desweb conn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista);

        conn=new examen_desweb(getApplicationContext(),"bd_usuarios",null,1);

        listViewPersonas= (ListView) findViewById(R.id.listViewPersonas);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String informacion="Codigo: "+listaUsuarios.get(pos).getCodigo()+"\n";
                informacion+="Nombre: "+listaUsuarios.get(pos).getNombre()+"\n";
                informacion+="Categoria: "+listaUsuarios.get(pos).getCategoria()+"\n";
                informacion+="Prerequisito: "+listaUsuarios.get(pos).getPrerequisito()+"\n";
                informacion+="PrimaryKey: "+listaUsuarios.get(pos).getPrimarykey()+"\n";

                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_LONG).show();
            }
        });

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setCodigo(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setCategoria(cursor.getString(2));
            usuario.setPrerequisito(cursor.getString(3));
            usuario.setPrimarykey(cursor.getString(4));

            listaUsuarios.add(usuario);
        }
        obtenerlista();

    }

    private void obtenerlista(){
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getCodigo()+" - "
                    +listaUsuarios.get(i).getNombre());
        }
    }
}