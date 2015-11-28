package br.com.glicheck.Class;

/**
 * Created by f.de.souza.filho on 11/21/2015.
 */
public class Medicamento {

    int id;
    String nome;
    String laboratorio;
    int quantidade;
    int composicao;


    public Medicamento(){

    }

    public Medicamento(int id, String nome, String laboratorio, int quantidade, int composicao, int quant_ingestao){

        this.id = id;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.composicao = composicao;
        this.quant_ingestao = quant_ingestao;

    }

    public Medicamento(String nome, int quantidade){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }


    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getComposicao() {
        return composicao;
    }

    public void setComposicao(int composicao) {
        this.composicao = composicao;
    }

    public int getQuant_ingestao() {
        return quant_ingestao;
    }

    public void setQuant_ingestao(int quant_ingestao) {
        this.quant_ingestao = quant_ingestao;
    }

    int quant_ingestao;



}
