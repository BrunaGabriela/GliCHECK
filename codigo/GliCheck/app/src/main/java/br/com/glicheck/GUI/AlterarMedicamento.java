package br.com.glicheck.GUI;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.glicheck.Controller.MedicamentoController;
import br.com.glicheck.R;

/**
 * Created by f.de.souza.filho on 12/8/2015.
 */
public class AlterarMedicamento extends Activity implements View.OnClickListener {

    EditText edtNomeMedicamento;
    EditText edtLaboratorio;
    EditText edtQuantidade;
    EditText edtComposicao;
    EditText edtQuant_Ingestao;
    Button btnAlterar;
    Button btnCancelar;
    Cursor cursor;
    MedicamentoController db;
    String codigo;

    String nome;
    String laboratorio;
    String quantidade ;
    String composicao ;
    String quant_ingestao ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_medicamento);
        btnAlterar = (Button) findViewById(R.id.btnAlterar);
        btnAlterar.setOnClickListener(this);

        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(this);

        codigo = this.getIntent().getStringExtra("codigo");

        db = new MedicamentoController(getBaseContext());

        edtNomeMedicamento = (EditText)findViewById(R.id.edtNomeMedicamento);
        edtLaboratorio = (EditText)findViewById(R.id.edtLaboratorio);
        edtQuantidade = (EditText)findViewById(R.id.edtQuantidade);
        edtComposicao = (EditText)findViewById(R.id.edtComposicao);
        edtQuant_Ingestao = (EditText)findViewById(R.id.edtQuant_Ingestao);

        cursor = db.carregaMedicamentobyID(Integer.parseInt(codigo));
        edtNomeMedicamento.setText(cursor.getColumnIndexOrThrow("nome"));
        edtLaboratorio.setText(cursor.getColumnIndexOrThrow("laboratorio"));
        edtQuantidade.setText(cursor.getColumnIndexOrThrow("quantidade"));
        edtComposicao.setText(cursor.getColumnIndexOrThrow("composicao"));
        edtQuant_Ingestao.setText(cursor.getColumnIndexOrThrow("quant_ingestao"));

         nome = edtNomeMedicamento.getText().toString();
         laboratorio = edtLaboratorio.getText().toString();
         quantidade = edtQuantidade.getText().toString();
         composicao = edtComposicao.getText().toString();
         quant_ingestao = edtQuant_Ingestao.getText().toString();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btnAlterar):
                db.alteraMedicacao(Integer.parseInt(codigo), nome, laboratorio, Integer.parseInt(quantidade), Integer.parseInt(composicao),
                                   Integer.parseInt(quant_ingestao));

                Intent intent = new Intent(AlterarMedicamento.this, ListagemMedicamento.class);
                startActivity(intent);
                finish();
                break;
       }

    }
}
