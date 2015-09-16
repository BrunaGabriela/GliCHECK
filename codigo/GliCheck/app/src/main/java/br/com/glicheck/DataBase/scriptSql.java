package br.com.glicheck.DataBase;

/**
 * Created by f.de.souza.filho on 9/15/2015.
 */
public class scriptSql {

    public static String getCriarMedicaoGlicemia()
    {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS MEDICAO_GLICEMIA  ");
        sqlBuilder.append(" (_id     INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL, ");
        sqlBuilder.append("MEDICAO VARCHAR (50) NOT NULL, ");
        sqlBuilder.append("DATA    DATE); ");

        return sqlBuilder.toString();

    }

}
