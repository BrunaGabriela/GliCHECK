package br.com.glicheck.GUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.glicheck.Class.Medicamento;
import br.com.glicheck.Controller.MedicamentoController;
import br.com.glicheck.R;

public class CadastroMedicamento extends AppCompatActivity implements View.OnClickListener {


    private EditText edtNome;
    private EditText edtLaboratorio;
    private EditText edtQuantidade;
    private EditText edtComposicao;
    private EditText edtQuantIngestao;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medicamento);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v) {

         switch (v.getId()) {
                case (R.id.btnSalvar):
                    Medicamento medicamento = new Medicamento();
                    MedicamentoController inserir = new MedicamentoController(getBaseContext());
                    edtNome = (EditText)findViewById(R.id.edtNomeMedicamento);
                    edtLaboratorio = (EditText)findViewById(R.id.edtLaboratorio);
                    edtQuantidade = (EditText)findViewById(R.id.edtQuant);
                    edtComposicao = (EditText)findViewById(R.id.edtComposicao);
                    edtQuantIngestao = (EditText)findViewById(R.id.edtQuantIngestao);

                    if (checarCampos())
                    {
                        medicamento.setNome(edtNome.getText().toString());
                        medicamento.setLaboratorio(edtLaboratorio.getText().toString());
                        medicamento.setQuantidade(Integer.parseInt(edtQuantidade.getText().toString()));
                        medicamento.setComposicao(Integer.parseInt(edtComposicao.getText().toString()));
                        medicamento.setQuant_ingestao(Integer.parseInt(edtQuantIngestao.getText().toString()));
                        String resultado;

                        resultado = inserir.registrarMedicamento(medicamento);

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                        finish();
                        {

                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Favor Preecher todos os Campos", Toast.LENGTH_LONG).show();

        }



    }

    public boolean checarCampos(){

         if ((!edtNome.getText().toString().matches("") || !edtLaboratorio.getText().toString().matches("") ||
                !edtQuantidade.getText().toString().matches("") || !edtComposicao.getText().toString().matches("") || !edtQuantIngestao.getText().toString().matches("")))
         {
            return true;
         }
        else
        {
            return false;
        }
    }

}
