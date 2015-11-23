package br.com.glicheck.GUI;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;

import br.com.glicheck.DataBase.RepMedicaoGlicemia;
import br.com.glicheck.DataBase.CriaBanco;
import br.com.glicheck.R;

public class RelatorioGlicemiaActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lstGlicemia;
    private Button btnAdcionar;
    private Button btnDeletar;
    private Spinner spnGlicemia;
    private EditText edtValor;

    private ArrayAdapter<String> adpOpcoes;
    private ArrayAdapter<String> adpGlicemia;

    private RepMedicaoGlicemia repMedicaoGlicemia;
    private SQLiteDatabase conexao;
    private CriaBanco criaBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_glicemia);

        lstGlicemia = (ListView)findViewById(R.id.lstGlicemia);
        btnAdcionar = (Button)findViewById(R.id.btnAdcionar);
        btnDeletar =(Button)findViewById(R.id.btnDeletar);
        spnGlicemia = (Spinner)findViewById(R.id.spnGlicemia);
        edtValor = (EditText)findViewById(R.id.edtValor);

        btnAdcionar.setOnClickListener(this);
        btnDeletar.setOnClickListener(this);

        adpOpcoes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adpOpcoes.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        try
        {
            criaBanco = new CriaBanco(this);
            conexao = criaBanco.getWritableDatabase();
            RepMedicaoGlicemia repMedicaoGlicemia = new RepMedicaoGlicemia(conexao);
            adpGlicemia = repMedicaoGlicemia.getMedicaoGlicemia(this);
            lstGlicemia.setAdapter(adpGlicemia);
            Toast.makeText(getApplicationContext(), "Conexão com o BD OK", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e)
        {
            Toast.makeText(getApplicationContext(), "Falha ao Consultar Dados", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_relatorio_glicemia, menu);
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

    @Override
    public void onClick(View v) {

    }
}
