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
        valores.put("quant_ingestao", medicamento.getQuant_ingestao());
        valores.put("quant_estoque", medicamento.getQuantidade());
        valores.put("controle", 0);

        resultado = db.insert("medicamento", null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao Inserir Dados";
        }
        else
        {
            return "Registro Inserido com Sucesso";
        }
    }

    public void controleMedicamento()
    {

    }


    public Cursor carregaMedicamento()
    {
        Cursor cursor;
        String[] campos = {"_id", "nome"};
        db = banco.getReadableDatabase();
        cursor = db.query("medicamento", campos, null, null, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaMedicamentobyID(int id){

        Cursor cursor;
        String[] campos = {"_id","nome","laboratorio","quantidade","composicao",
                           "quant_ingestao","quant_estoque","controle"};
        String where = "_id = "+id;
        db = banco.getReadableDatabase();
        cursor = db.query("medicamento", campos, where, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;

    }

    public void alteraMedicacao(int id, String nome, String laboratorio, int quantidade,
                                int composicao, int quant_ingestao)
    {
        ContentValues valores;
        db = banco.getWritableDatabase();

        String where = "_id = "+id;

        valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("laboratorio", laboratorio);
        valores.put("quantidade", quantidade);
        valores.put("composicao", composicao);
        valores.put("quant_ingestao", quant_ingestao);

        db.update("medicamento", valores, where, null);
        db.close();




    }

}

