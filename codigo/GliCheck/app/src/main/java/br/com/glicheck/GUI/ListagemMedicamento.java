package br.com.glicheck.GUI;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.glicheck.Controller.MedicamentoController;
import br.com.glicheck.R;

public class ListagemMedicamento extends AppCompatActivity {

    private ListView  lstMedicamento;
    private Button btnAdcionarMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_medicamento);

        MedicamentoController listagem = new MedicamentoController(getBaseContext());
        Cursor cursor = listagem.listaMedicamento();

        String[] nomeCampos = new String[] {"nome", "quantidade"};

        //SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext()), R.

    }
}
