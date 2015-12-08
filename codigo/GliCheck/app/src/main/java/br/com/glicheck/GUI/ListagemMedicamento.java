package br.com.glicheck.GUI;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import br.com.glicheck.Controller.MedicamentoController;
import br.com.glicheck.R;

public class ListagemMedicamento extends AppCompatActivity implements View.OnClickListener{

    MedicamentoController db;
    private ListView  lista;
    Button btnAddMedicamento;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_medicamento);

        btnAddMedicamento = (Button)findViewById(R.id.btnAddMedicacao);
        btnAddMedicamento.setOnClickListener(this);

        db = new MedicamentoController(getApplicationContext());
        cursor = db.carregaMedicamento();

        String[] nomeCampos = new String[] {"_id","nome"};
        int[] idViews = new int[] {R.id.txtID, R.id.txtNomeMedicamento};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.itens_medicamento, cursor, nomeCampos, idViews, 0);

        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adapter);

        registerForContextMenu(lista);


    }

    public void onClick(View v){

        switch (v.getId()){
            case (R.id.btnAddMedicacao):
                Intent itCadastroMedicamento = new Intent(this, CadastroMedicamento.class);
                startActivity(itCadastroMedicamento);
                onDestroy();
        }

    }
    @Override
    public void onBackPressed()
    {
        finish();
        super.onBackPressed();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Selecione um Ação");
        menu.add(0, v.getId(), 0, "Alterar");//
        menu.add(0, v.getId(), 0, "Deletar");
        menu.add(0, v.getId(), 0, "Atualizar Estoque");

    }



    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        if(item.getTitle()=="Alterar"){
            //Toast.makeText(getApplicationContext(),"Alterando...",Toast.LENGTH_LONG).show();
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String codigo;
                    cursor.moveToPosition(position);
                    codigo = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                    Intent it = new Intent(ListagemMedicamento.this, AlterarMedicamento.class);
                    it.putExtra("codigo", codigo);
                    startActivity(it);
                    finish();
                }
            });

        }
        else if(item.getTitle()=="Deletar") {
            Toast.makeText(getApplicationContext(), "Deletando...", Toast.LENGTH_LONG).show();


        }
        else if(item.getTitle()=="Atualizar Estoque"){
                Toast.makeText(getApplicationContext(),"Atualizar Estoque...",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }

}






//        setContentView(R.layout.activity_listagem_medicamento);
//
//        lstMedicamento = (ListView)findViewById(R.id.lstMedicamento);
//
//        btnAdcionarMedicamento = (Button)findViewById(R.id.btnAdcionarMedicamento);
//        btnAdcionarMedicamento.setOnClickListener(this);
//
//        medicamento = new ArrayList<Medicamento>();
//        db.listaMedicamento(medicamento);
//
//        medicamentoAdapter = new MedicamentoAdapter(this, medicamento);
//
//        lstMedicamento.setAdapter(medicamentoAdapter);