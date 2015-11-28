package br.com.glicheck.DataBase;

import android.text.method.HideReturnsTransformationMethod;

/**
 * Created by f.de.souza.filho on 9/15/2015.
 */
public class scriptSql {

    public static String getCriarMedicaoGlicemia() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS MEDICAO_GLICEMIA  ");
        sqlBuilder.append(" (_id     INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sqlBuilder.append("MEDICAO VARCHAR (50) NOT NULL, ");
        sqlBuilder.append("DATA    DATE); ");

        return sqlBuilder.toString();

    }

    public static String criaTabelaMedicamento() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE medicamento ");
        sql.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append(" nome TEXT NOT NULL,");
        sql.append(" laboratorio TEXT,");
        sql.append(" quantidade INTEGER,");
        sql.append(" composicao INTEGER,");
        sql.append(" quantidade_ingestao)");

        return sql.toString();
    }

    public static String criaControleIngestaoMedicamento() {

        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE controle_ingestao_medicamento ");
        sql.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," );
        sql.append(" id_medicamento INTEGER NOT NULL," );
        sql.append(" quantidade INTEGER,");
        sql.append(" controle_ativo INTEGER)");

        return sql.toString();
    }

}
