package io.igomarcelino.github.desafioDioAbastraccao.dominio;

public abstract class Pessoa {
    private static  int codigoSequencial = 1;

    private int codigo;
    private String nome;
    private String cpf;

    public Pessoa() {
        this.codigo = codigoSequencial++;
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = codigoSequencial++;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}
