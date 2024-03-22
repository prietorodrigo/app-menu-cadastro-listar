package com.example.cadastrolistar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ActivityListar extends AppCompatActivity {

    /*private ListView list;*/

    private TextView list;
    ArrayList<Lista> lista = null;
    String s="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        list = findViewById(R.id.lstListar);
        lista = (ArrayList<Lista>) getIntent().getSerializableExtra("lista");

//        String array[] = new String[lista.size()];
//        for (int i=0; i<lista.size(); i++) {
//            array[i] = lista.get(i).getNome();
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ActivityListar.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, array);
//        list.setAdapter(adapter);

        for (int i=0; i<lista.size(); i++) {
            s += "Nome:\t"+lista.get(i).getNome()+"\n";
            s += "Sobrenome:\t"+lista.get(i).getSobreNome()+"\n";
            s += "Identidade:\t"+lista.get(i).getIdentidade()+"\n";
            s += "Endereço:\t"+lista.get(i).getEndereco()+"\n";
            s += "Telefone:\t"+lista.get(i).getTelefone()+"\n\n";
        }
        list.setText(s);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_register) {
            onBackPressed();
            return true;
        }
        else if (item.getItemId()==R.id.action_list) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("string", s);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        s = savedInstanceState.getString("string");
        list.setText(String.valueOf(s));
    }
}