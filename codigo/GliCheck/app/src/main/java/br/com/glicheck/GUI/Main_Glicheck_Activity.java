package br.com.glicheck.GUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import  android.content.*;

import br.com.glicheck.R;

public class Main_Glicheck_Activity extends AppCompatActivity implements View.OnClickListener{

    private Button btnMedirGli;
    private Button btnRelatorio;
    private Button btnCadastrarMedicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glicheck_main);

        btnMedirGli = (Button) findViewById(R.id.btnMedirGli);
        btnMedirGli.setOnClickListener(this);
        btnRelatorio = (Button) findViewById(R.id.btnRelatorio);
        btnRelatorio.setOnClickListener(this);
        btnCadastrarMedicacao = (Button) findViewById(R.id.btnCadastrarMedicamento);
        btnCadastrarMedicacao.setOnClickListener(this);



    }
    public void onClick(View v)
    {

        switch (v.getId()) {

            case (R.id.btnMedirGli):
                Intent it_Cad_Medicao_Gli = new Intent(this, Cad_Medicao_Gli_Activity.class);
                startActivity(it_Cad_Medicao_Gli);
                break;

            case (R.id.btnRelatorio):
                Intent it_Rel_Glicemia = new Intent(this, RelatorioGlicemiaActivity.class );
                startActivity(it_Rel_Glicemia);
                break;

            case (R.id.btnCadastrarMedicamento):
                Intent itListaMedicamento = new Intent(this, CadastroMedicamento.class);
                startActivity(itListaMedicamento);
                break;
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gli_check_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
