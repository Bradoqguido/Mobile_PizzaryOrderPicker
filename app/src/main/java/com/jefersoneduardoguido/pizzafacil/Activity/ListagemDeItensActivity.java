package com.jefersoneduardoguido.pizzafacil.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jefersoneduardoguido.pizzafacil.R;

public class ListagemDeItensActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton finaliza_listagem, volta_item;
    private ListView listview_listagem;
    private String[] bebidas, porcoes, borda, tamanho_pizza, mesas;
    private int item;
    private View itemSelecionado;
    private int contador = 0; // Variável que irá verificar se o um botão for pressionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_de_itens);

        finaliza_listagem = (FloatingActionButton) findViewById(R.id.finaliza_listagem);
        finaliza_listagem.setOnClickListener(this);

        volta_item = (FloatingActionButton) findViewById(R.id.volta_item);
        volta_item.setOnClickListener(this);

        listview_listagem = (ListView) findViewById(R.id.listview_listagem);

        // Cria uma nova intent que recebe o numero da ação do usuário
        Intent intent = getIntent();
        item = intent.getIntExtra("ITEM", 0);


        ArrayAdapter<String> adapter; // Cria um adaptador que irá receber os dados referentes á escolha do usuário
        switch (item){
            case 0:
                mesas = getResources().getStringArray(R.array.mesas); // Chama o array mesa
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, mesas); // Define o array de dados e como será exibido
                listview_listagem.setAdapter(adapter);
                break;
            case 1:
                tamanho_pizza = getResources().getStringArray(R.array.tamanho_pizza); // Chama o array tamanho_pizza
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, tamanho_pizza); // Define o array de dados e como será exibido
                listview_listagem.setAdapter(adapter);

                borda = getResources().getStringArray(R.array.borda); // Chama o array borda
                break;
            case 2:
                porcoes = getResources().getStringArray(R.array.porcoes); // Chama o array porcoes
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, porcoes); // Define o array de dados e como será exibido
                listview_listagem.setAdapter(adapter);
                break;
            case 3:
                bebidas = getResources().getStringArray(R.array.bebidas); // Chama o array bebidas
                adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, bebidas); // Define o array de dados e como será exibido
                listview_listagem.setAdapter(adapter);
                break;
        }

        listview_listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String item_listview = (String) listview_listagem.getItemAtPosition(position);

                if(itemSelecionado != null) {
                    itemSelecionado.setBackgroundColor(Color.WHITE); // define o fundo do item selecionado como branco
                }
                itemSelecionado = view;
                itemSelecionado.setBackgroundColor(Color.LTGRAY); // define o fundo do item selecionado como cinza claro

                switch (item) {
                    case 0:
                        // Salvar no BD
                        Toast.makeText(getApplicationContext(), item_listview, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        if (contador == 0) {
                            // Salvar no BD
                            contador++;
                        }
                        if (contador == 1){
                            // Salvar no BD
                            contador++;
                        }
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), item_listview, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), item_listview, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        // Finaliza a activity se os botões forem pressionados
        if(view.getId() == R.id.finaliza_listagem);

        switch (item){
            case 0:
                finish();
                break;
            case 1:

                switch (contador){// Se o contador for igual a true, ou seja, o array que exibe as bordas for mostrado, inicia a seleção dos sabores no próximo clique no botão continuar

                    case 1:
                        ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_dropdown_item_1line, borda); // Define o array de dados e como será exibido
                        listview_listagem.setAdapter(adapter);
                        break;
                    case 2:
                        Intent selecaoSabor = new Intent(ListagemDeItensActivity.this, MontagemPizzaActivity.class);
                        selecaoSabor.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(selecaoSabor);
                        finish();
                        break;

                }

                break;
            case 2:
                finish();
                break;
            case 3:
                finish();
                break;
        }

        if (view.getId() == R.id.volta_item){
            finish();
        }
    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(ListagemDeItensActivity.this, ListagemDeItensActivity.class);  //your class
        startActivity(i);
        finish();
    }
}

