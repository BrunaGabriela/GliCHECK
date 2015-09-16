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
public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "GliCheckDB";

    public DBHandler (Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(scriptSql.getCriarMedicaoGlicemia());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void adcionarMedicaoGlicemia(Glicemia glicemia){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("medicao_glicemia", glicemia.getGlicemia());
        valores.put ("dia", glicemia.getDia());
        valores.put ("mes", glicemia.getMes());
        valores.put ("ano", glicemia.getAno());

        db.insert(DB_NAME, null, valores);
        db.close();
    }
    public int getMedicaoCount()
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ DB_NAME, null);
        cursor.close();

        return cursor.getCount();
    }

    public List<Glicemia> getTodasMedicoes(){

        List<Glicemia> glicemiaList = new ArrayList<Glicemia>();
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from "+ DB_NAME, null);

        if(cursor.moveToFirst())
            do
            {
                Glicemia glicemia = new Glicemia(Integer.parseInt(cursor.getString(0)),
                                                 Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                                                 Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
                glicemiaList.add(glicemia);
            }while (cursor.moveToNext());

        return glicemiaList;
    }

}
