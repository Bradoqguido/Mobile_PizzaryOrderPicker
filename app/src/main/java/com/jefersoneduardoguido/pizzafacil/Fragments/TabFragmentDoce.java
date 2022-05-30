package com.jefersoneduardoguido.pizzafacil.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jefersoneduardoguido.pizzafacil.R;

/**
 * Created by Jefer on 19/08/2017.
 */

public class TabFragmentDoce extends Fragment {
    private static final String TAG = "TabFragmentDoce";

    private ListView lstdoce;
    private String[] SaborDoce;
    private View itemSelecionado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);
        lstdoce = (ListView) view.findViewById(R.id.lstsalgado);

        SaborDoce = getResources().getStringArray(R.array.sabor_doce);
        lstdoce.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1 , SaborDoce));

        lstdoce.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item_listview = (String) lstdoce.getItemAtPosition(position); // Faz a captura do item

                if(itemSelecionado != null) {
                    itemSelecionado.setBackgroundColor(Color.WHITE); // define o fundo do item selecionado como branco
                }

                itemSelecionado = view;
                itemSelecionado.setBackgroundColor(Color.LTGRAY); // define o fundo do item selecionado como cinza claro

                Toast.makeText(getContext(), item_listview, Toast.LENGTH_SHORT).show();//show the item selected
                // Salvar no BD
            }
        });

        return view;
    }
}
