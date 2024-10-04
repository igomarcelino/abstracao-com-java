package io.igomarcelino.github.desafioDioAbastraccao.dominio;

import java.time.LocalDate;

public class Aluguel {
    private static int codigoSequencial =1 ;
    private int codigo;
    private Cliente cliente;
    private Jogo jogo;
    private String status;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private Funcionario funcionario;
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public Aluguel() {
        this.codigo = codigoSequencial++;
        this.dataDevolucao = LocalDate.now().plusDays(7);
    }

    public void alugarJogo(Cliente cliente, Jogo jogo, String status, LocalDate dataAluguel,Funcionario funcionario, double valor){
        this.cliente = cliente;
        this.jogo = jogo;
        this.status = status;
        this.dataAluguel = dataAluguel;
        this.funcionario = funcionario;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public String getStatus() {
        return status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "codigo=" + codigo +
                ", cliente=" + cliente.getNome() +
                ", jogo=" + jogo.getNome() +
                ", status='" + status + '\'' +
                ", dataAluguel=" + dataAluguel +
                ", dataDevolucao=" + dataDevolucao +
                ", funcionario=" + funcionario.getNome() +
                ", valor=" + valor +
                '}';
    }
}
