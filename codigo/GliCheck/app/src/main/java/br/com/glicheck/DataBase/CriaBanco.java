package br.com.glicheck.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.glicheck.Class.Glicemia;

/**
 * Created by f.de.souza.filho on 9/14/2015.
 */
public class CriaBanco extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "GliCheck_DB";

    public CriaBanco(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(scriptSql.criaTabelaMedicamento());
        db.execSQL(scriptSql.criaControleIngestaoMedicamento());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS medicamento");
        db.execSQL("DROP TABLE IF EXISTS controle_ingestao_medicamento");
        //db.execSQL("ALTER TABLE medicamento RENAME COLUMN quantidade_ingestao TO quant_ingestao ");
        onCreate(db);

    }

}
