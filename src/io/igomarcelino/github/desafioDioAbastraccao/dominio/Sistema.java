package io.igomarcelino.github.desafioDioAbastraccao.dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Sistema {
    private  List<Pessoa> pessoaList;
    private List<Jogo> jogoList;

    public Sistema() {
        this.pessoaList = new LinkedList<>();
        this.jogoList = new LinkedList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        this.pessoaList.add(funcionario);
    }

    protected void cadastrarClientes(Funcionario funcionario, Cliente cliente){
        if (funcionario != null){
            cliente.setFuncionarioCadastro(funcionario);
            adicionarPessoas(cliente);
            System.out.println("Cadastro realizado com sucesso");
        }else {
            System.out.println("Funcionario nao localizado");
        }
    }

    public void cadastrarJogo(Funcionario funcionario, Jogo jogo){
        if (funcionario != null){
            jogo.setFuncionario(funcionario);
            adicionarJogos(jogo);
        }
    }
    private void adicionarPessoas(Pessoa pessoa){
        this.pessoaList.add(pessoa);
    }
    private void adicionarJogos(Jogo jogo){
        this.jogoList.add(jogo);
    }

    public void imprimirPessoas(){
        System.out.println(pessoaList);
    }
    public void imprimirJogos(){
        System.out.println(jogoList);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sistema sistema)) return false;

        if (!Objects.equals(pessoaList, sistema.pessoaList)) return false;
        return Objects.equals(jogoList, sistema.jogoList);
    }

    @Override
    public int hashCode() {
        int result = pessoaList != null ? pessoaList.hashCode() : 0;
        result = 31 * result + (jogoList != null ? jogoList.hashCode() : 0);
        return result;
    }
}
