package io.igomarcelino.github.desafioDioAbastraccao.dominio;

import java.util.Scanner;

public class Funcionario extends Pessoa {


    private String funcao;

    public Funcionario(){
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
                "cpf='" + getCpf() + '\'' +
                "nome='" + getNome() + '\'' +
                "funcao='" + funcao + '\'' +
                '}';
    }
}
