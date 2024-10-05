package io.igomarcelino.github.desafioDioAbastraccao.dominio;

import java.util.Scanner;

public class Funcionario extends Pessoa {


    private String funcao;

    public Funcionario(){
        this.funcao = "Atendente";
    }
    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
        this.funcao = "Atendente";
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }




    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + getCodigo() +" "+
                "nome='" + getNome() + '\'' +
                "cpf='" + getCpf() + '\'' +
                "funcao='" + funcao + '\'' +
                '}';
    }
}
