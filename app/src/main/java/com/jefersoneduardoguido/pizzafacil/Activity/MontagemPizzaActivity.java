package com.jefersoneduardoguido.pizzafacil.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jefersoneduardoguido.pizzafacil.R;

public class MontagemPizzaActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton fab_finaliza_montagem, fab_adiciona_sabor;
    private ListView listview_montagempizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_montagem_pizza);

        fab_finaliza_montagem = (FloatingActionButton) findViewById(R.id.fab_finaliza_montagem);
        fab_finaliza_montagem.setOnClickListener(this);

        fab_adiciona_sabor = (FloatingActionButton) findViewById(R.id.fab_adiciona_sabor);
        fab_adiciona_sabor.setOnClickListener(this);

        listview_montagempizza = (ListView) findViewById(R.id.listview_montagempizza);

        // Corrigir exibição do texto aparece como null, mesmo depois de selecionado o sabor


        listview_montagempizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                adapterView.getItemAtPosition(posicao);
                Toast.makeText(getApplicationContext(), "item: " + posicao, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View view) {


        if(view.getId() == R.id.fab_finaliza_montagem){
            finish();
        }
        if(view.getId() == R.id.fab_adiciona_sabor){
            Intent selecionaSabor = new Intent(this, SaborActivity.class);
            selecionaSabor.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(selecionaSabor);
        }

    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MontagemPizzaActivity.this, MontagemPizzaActivity.class);  //your class
        startActivity(i);
        finish();

    }
}
