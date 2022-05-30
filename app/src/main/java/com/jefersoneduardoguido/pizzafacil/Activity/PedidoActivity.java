package com.jefersoneduardoguido.pizzafacil.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jefersoneduardoguido.pizzafacil.R;

import java.util.ArrayList;

public class PedidoActivity extends AppCompatActivity implements View.OnClickListener{

    public static String ITEM = "ITEM";

    // Atributos da classe
    private AlertDialog alerta;
    private FloatingActionButton finalizarpedido, adicionaitem;
    private ListView listView_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        // Inicia os objetos
        finalizarpedido = (FloatingActionButton) findViewById(R.id.finalizarpedido);
        finalizarpedido.setOnClickListener(this);

        adicionaitem = (FloatingActionButton) findViewById(R.id.adicionaitem);
        adicionaitem.setOnClickListener(this);

        listView_pedido = (ListView) findViewById(R.id.listview_pedido);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.finalizarpedido:
                finish();
                break;
            case R.id.adicionaitem:
                escolha_pedido();
        }
    }

    private void escolha_pedido() {

        // Lista de itens para o pedido
        ArrayList<String> itens = new ArrayList<String>();
        itens.add("Mesa");
        itens.add("Pizza");
        itens.add("Porção");
        itens.add("Bebida");

        // Adapter utilizando um layout customizado com um TextView
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.dialog_listview, itens);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione uma Ação");

        //define o diálogo como uma lista, passa o adapter.
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int posicao) {
                alerta.dismiss(); // Faz o dialogo desaparecer

                Intent listagemDeitens = new Intent(PedidoActivity.this, ListagemDeItensActivity.class);
                listagemDeitens.putExtra("ITEM", posicao); // Envia a posição do adicional selecionado
                startActivity(listagemDeitens); // Inicia uma intent para a classe ListagemDeItensActivity
            }
        });

        alerta = builder.create(); // Cria o dialogo
        alerta.show(); // Exibe o dialogo
    }


    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(PedidoActivity.this, PedidoActivity.class);  //your class
        startActivity(i);
        finish();

    }

}
