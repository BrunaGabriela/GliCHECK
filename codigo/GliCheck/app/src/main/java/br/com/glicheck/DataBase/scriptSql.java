package br.com.glicheck.DataBase;

import android.text.method.HideReturnsTransformationMethod;

/**
 * Created by f.de.souza.filho on 9/15/2015.
 */
public class scriptSql {


       public static String criaTabelaMedicamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE medicamento ");
        sql.append(" ( _id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sql.append(" nome TEXT NOT NULL,");
        sql.append(" laboratorio TEXT,");
        sql.append(" quantidade INTEGER,");
        sql.append(" composicao INTEGER,");
        sql.append(" quant_ingestao INTEGER,");
        sql.append(" quant_estoque INTEGER,");
        sql.append(" controle INTEGER)");


        return sql.toString();
    }

}
