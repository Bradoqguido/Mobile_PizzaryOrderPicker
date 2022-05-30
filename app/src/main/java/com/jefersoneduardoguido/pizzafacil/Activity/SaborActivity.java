package com.jefersoneduardoguido.pizzafacil.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jefersoneduardoguido.pizzafacil.R;
import com.jefersoneduardoguido.pizzafacil.Adapters.SectionsPageAdapter;
import com.jefersoneduardoguido.pizzafacil.Fragments.TabFragmentDoce;
import com.jefersoneduardoguido.pizzafacil.Fragments.TabFragmentSalgado;

public class SaborActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ActivitySabor";
    private ViewPager viewPager;
    private SectionsPageAdapter sectionsPageAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabor);
        Log.d("SaborActivity", "Iniciando");

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Exibe o ViewPaper com o adapter
        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);

        fab = (FloatingActionButton) findViewById(R.id.fabSabor);
        fab.setOnClickListener(this);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    // chama os fragmentos e lhes dá um titulo.
    private void setupViewPager(ViewPager viewPager) {
        Log.d("SaborActivity", "Criando Fragmentos");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragmentSalgado(), "Salgado");
        adapter.addFragment(new TabFragmentDoce(), "Doce");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.fabSabor:
                Log.d("SaborActivity", "Finalizando Activity");
                finish(); // finaliza a activity
                break;
        }

    }
}
