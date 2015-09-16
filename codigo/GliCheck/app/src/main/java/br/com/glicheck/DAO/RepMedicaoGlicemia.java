package br.com.glicheck.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

/**
 * Created by f.de.souza.filho on 9/15/2015.
 */
public class RepMedicaoGlicemia
{
    private SQLiteDatabase conexao;

    public RepMedicaoGlicemia(SQLiteDatabase conexao)
    {
        this.conexao = conexao;
    }

    public ArrayAdapter<String> getMedicaoGlicemia(Context context)
    {
        ArrayAdapter<String> adpMedicaoGlicemia = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conexao.query("MEDICAO_GLICEMIA", null, null, null, null, null, null);

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do
            {
                String medicao_glicemia =  cursor.getString(1);
                adpMedicaoGlicemia.add(medicao_glicemia);

            }
            while (cursor.moveToNext());

        }

    return adpMedicaoGlicemia;
        //Cursor cursor


    }

    public void addMedicaoGlicemiaTest()
    {
        int glicemia = 120;
        for (int i = 0; i < 10; i++)
        {
            ContentValues values = new ContentValues();
            values.put("medicao", glicemia);
            conexao.insertOrThrow("MEDICAO_GLICEMIA", null, values);
            glicemia++;
        }

    }
}
