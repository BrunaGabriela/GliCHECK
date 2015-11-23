package br.com.glicheck.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

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

    public Cursor listaMedicamento(){

        Cursor cursor;
        String[] campos = {"nome", "quantidade"};
        db = banco.getReadableDatabase();
        cursor = db.query("medicamento", campos, null, null, null, null, null, null);

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}

