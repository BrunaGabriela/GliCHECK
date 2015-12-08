package br.com.glicheck.GUI;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by f.de.souza.filho on 12/8/2015.
 */
public class MedicamentoDetalheActivity extends ListActivity implements AdapterView.OnItemClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarDetalheMedicamento()));
        ListView listView = getListView();
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public List<String> listarDetalheMedicamento(){

        return Arrays.asList("Metformina 850mg",
                             "Quantidade: 30",
                             "Ingestao: 2 Comprimidos");

    }
}
