package io.igomarcelino.github.desafioDioAbastraccao.dominio;

public class Jogo {
    private static int codigoSequencial = 1 ;
    private int codigo;
    private String nome;
    private String fabricante;
    private int totalJogadores;
    private int anoPublicacao;
    private int quantidadeDisponivel;
    private Funcionario funcionario;

    public Jogo() {
        // gerador de codigo sequencial
        // apenas para logica no banco em memoria
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getTotalJogadores() {
        return totalJogadores;
    }

    public void setTotalJogadores(int totalJogadores) {
        this.totalJogadores = totalJogadores;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", totalJogadores=" + totalJogadores +
                ", anoPublicacao=" + anoPublicacao +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", funcionario=" + funcionario +
                '}';
    }
}
