package com.jefersoneduardoguido.pizzafacil.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.jefersoneduardoguido.pizzafacil.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    //cria as variaveis
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, promocao, novopedido; // variaveis dos botoes flutuantes
    private Animation fab_open, fab_close, rotate_forward, rotate_backward; // variaveis de animação dos botoes flutuantes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ActivityMain", "Iniciando");

        startObjects(); // chama uma função que inicia os objetos

        fab.setOnClickListener(this);
        promocao.setOnClickListener(this);
        novopedido.setOnClickListener(this);
    }

    // Método que inicia os objetos do layout
    public void startObjects() {
        Log.d("ActivityMain", "Chamando os objetos");
        fab = (FloatingActionButton) findViewById(R.id.fab);
        promocao = (FloatingActionButton) findViewById(R.id.fab_promocao);
        novopedido = (FloatingActionButton) findViewById(R.id.fab_novopedido);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);

    }

    // Metodo que verifica a interação com o usuário
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.fab:
                animateFAB(); // Chama a função de animação do botão
                break;

            case R.id.fab_novopedido:
                Intent pedido = new Intent(this, PedidoActivity.class);
                pedido.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pedido);
                Log.d("ActivityMain", "Novo Pedido");
                break;

            case R.id.fab_promocao:
                Intent promocao = new Intent(this, MontagemPizzaActivity.class);
                promocao.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(promocao);
                Log.d("ActivityMain", "Promoção");
                break;

        }
    }

    public void animateFAB() { // Método que executa a animação dos botões presentes na activity
        Log.d("ActivityMain", "Instanciando animação");

        if (isFabOpen) { // Termina a animação

            fab.startAnimation(rotate_backward); // Finaliza a animação do botão principal
            promocao.startAnimation(fab_close); // Define o botão promocao invisivel
            novopedido.startAnimation(fab_close); // Define o botão novopedido invisivel
            promocao.setClickable(false); // Define o botão promocao como não clicavel
            novopedido.setClickable(false); // Define o botão novopedido como não clicavel
            isFabOpen = false;
            Log.d("Raj", "close"); // Cria um log de registro de ação

        } else { // Inicia a animação

            fab.startAnimation(rotate_forward); // Inicia a animação do botão principal
            promocao.startAnimation(fab_open); // Define o botão promocao visivel
            novopedido.startAnimation(fab_open); // Define o botão novopedido visivel
            promocao.setClickable(true); // Define o botão promocao como clicavel
            novopedido.setClickable(true); // Define o botão novopedido como clicavel
            isFabOpen = true;
            Log.d("Raj", "open"); // Cria um log de registro de ação

        }
    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        finish();

    }

}
