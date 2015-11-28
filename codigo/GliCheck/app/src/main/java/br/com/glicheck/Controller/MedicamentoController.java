package br.com.glicheck.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.view.Menu;
import android.widget.SimpleAdapter;
import android.widget.SimpleExpandableListAdapter;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.glicheck.Class.Medicamento;
import br.com.glicheck.DataBase.CriaBanco;

/**
 * Created by f.de.souza.filho on 11/21/2015.
 */
public class MedicamentoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public MedicamentoController (Context context){

        banco = new CriaBanco(context);

    }

    public String registrarMedicamento(Medicamento medicamento) {

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("nome", medicamento.getNome());
        valores.put("laboratorio", medicamento.getLaboratorio());
        valores.put("quantidade", medicamento.getQuantidade());
        valores.put("composicao", medicamento.getComposicao());
        valores.put("quantidade_ingestao", medicamento.getQuant_ingestao());

        resultado = db.insert("medicamento", null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao Inserir Dados";
        }
        else {
            return "Registro Inserido com Sucesso";
        }
    }

    public void controleMedicamento(){

    }

    public List<Medicamento> listaMedicamento(List<Medicamento> medicamento) {

        medicamento = new ArrayList<Medicamento>();
        try {
            db = banco.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT nome, quantidade FROM medicamento ORDER BY nome", null);
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                Medicamento med = preencheMedicamento(cursor);
                medicamento.add(med);
            }
            cursor.close();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.close();
        }
        return medicamento;
    }


    private Medicamento preencheMedicamento(Cursor cursor)
    {
        //int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String nome = cursor.getString(cursor.getColumnIndex("nome"));
        //String laboratorio = cursor.getString(cursor.getColumnIndex("laboratorio"));
        int quantidade = cursor.getInt(cursor.getColumnIndex("quantidade"));
        //int composicao = cursor.getInt(cursor.getColumnIndex("composicao"));
        //int quantIngestao = cursor.getInt(cursor.getColumnIndex("quantidade_ingestao"));

        Medicamento medicamento;
        medicamento = new Medicamento(nome, quantidade);

        return medicamento;
    }

}

