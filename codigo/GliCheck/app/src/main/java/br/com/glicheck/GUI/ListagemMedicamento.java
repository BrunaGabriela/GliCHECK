package br.com.glicheck.GUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.glicheck.Class.Medicamento;
import br.com.glicheck.Class.MedicamentoAdapter;
import br.com.glicheck.Controller.MedicamentoController;
import br.com.glicheck.DataBase.CriaBanco;
import br.com.glicheck.R;

public class ListagemMedicamento extends Activity implements View.OnClickListener{

    MedicamentoController db;
    private ListView  lstMedicamento;
    private Button btnAdcionarMedicamento;
    ArrayList<Medicamento> medicamento;

    MedicamentoAdapter medicamentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_medicamento);

        lstMedicamento = (ListView)findViewById(R.id.lstMedicamento);

        btnAdcionarMedicamento = (Button)findViewById(R.id.btnAdcionarMedicamento);
        btnAdcionarMedicamento.setOnClickListener(this);

        medicamento = new ArrayList<Medicamento>();
        db.listaMedicamento(medicamento);

        medicamentoAdapter = new MedicamentoAdapter(this, medicamento);

        lstMedicamento.setAdapter(medicamentoAdapter);
    }

    public void onClick(View v){

        switch (v.getId()){
            case (R.id.btnAdcionarMedicamento):
                Intent itCadastroMedicamento = new Intent(this, CadastroMedicamento.class);
                startActivity(itCadastroMedicamento);
        }

    }
    @Override
    public void onBackPressed()
    {
        finish();
        super.onBackPressed();

    }


}
