package com.example.cadastrolistar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private EditText e1;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    private EditText e5;
    private Button btn1;
    ArrayList<Lista> lista = new ArrayList<Lista>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // A partir daqui vem a lógica
        e1 = findViewById(R.id.edtNome);
        e2 = findViewById(R.id.edtSobrenome);
        e3 = findViewById(R.id.edtIdentidade);
        e4 = findViewById(R.id.edtEndereco);
        e5 = findViewById(R.id.edtTelefone);
        btn1 = findViewById(R.id.btnCadastrar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lista cadastro = new Lista();
                cadastro.setName(e1.getText().toString());
                cadastro.setSobreNome(e2.getText().toString());
                cadastro.setIdentidade(Integer.parseInt(e3.getText().toString()));
                cadastro.setEndereco(e4.getText().toString());
                cadastro.setTelefone(Integer.parseInt(e5.getText().toString()));
                lista.add(cadastro);

                Toast.makeText(getApplicationContext(),"Cadastro feito com sucesso", Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_register) {
            return true;
        }
        else if (item.getItemId()==R.id.action_list) {
            Intent i = new Intent(getApplicationContext(), ActivityListar.class);
            i.putExtra("lista", (Serializable) lista);

            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}