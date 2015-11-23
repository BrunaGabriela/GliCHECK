package br.com.glicheck.GUI;

import android.app.DatePickerDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import br.com.glicheck.DataBase.RepMedicaoGlicemia;
import br.com.glicheck.DataBase.CriaBanco;
import br.com.glicheck.R;


public class Cad_Medicao_Gli_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView lblDate;
    private Button btnDatePicker;
    private CriaBanco criaBanco;
    private EditText edtGlicemia;
    private Button btnSalvar;
    private SQLiteDatabase conexao;

    int dia, mes, ano;
    private Date Data;

    static final int DATE_DIALOG_ID = 999;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_med_gli);
        edtGlicemia = (EditText)findViewById(R.id.edtGlicemia);

        try
        {

            criaBanco = new CriaBanco(this);
            conexao = criaBanco.getWritableDatabase();
            Toast.makeText(getApplicationContext(), "Conexão com o BD OK", Toast.LENGTH_SHORT).show();
            RepMedicaoGlicemia repMedicaoGlicemia = new RepMedicaoGlicemia(conexao);
            repMedicaoGlicemia.addMedicaoGlicemiaTest();
            Toast.makeText(getApplicationContext(), "Dados de Testes Inseridos", Toast.LENGTH_SHORT).show();
        }
        catch (SQLException e)
        {
            Toast.makeText(getApplicationContext(), "Conexao Falhou", Toast.LENGTH_SHORT).show();
        }


        Calendar calendar = Calendar.getInstance();
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        ano = calendar.get(Calendar.YEAR);

        btnDatePicker = (Button)findViewById(R.id.btnDataPicker);
        btnDatePicker.setText(dia + "/" + (mes + 1) + "/" + ano);
        btnDatePicker.setOnClickListener(this);
        btnSalvar = (Button)findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);



    }

    public void onClick (View v) {
        String med_Glicemia = edtGlicemia.getText().toString();
        switch (v.getId()) {
            case (R.id.btnSalvar):
            if (med_Glicemia.matches("")) {
                Toast.makeText(getApplicationContext(), "Favor preencher todos os Campos", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public void selectDate(View v)
    {
        showDialog(v.getId());
    }



    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker v, int year, int monthOfYear, int dayOfMonth)
        {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            btnDatePicker.setText(dia + "/" + (mes + 1) + "/" + ano);
            criarData(dia, mes, ano);
        }

    };


    private Date criarData(int anoSelecionado, int mesSelecionado, int diaSelecionado) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoSelecionado, mesSelecionado, diaSelecionado);
        return calendar.getTime();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cad_med_gli, menu);
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
