package io.igomarcelino.github.desafioDioAbastraccao.dominio;

public class Cliente extends Pessoa{

    private String telefone;
    private String email;
    private String endereco;
    private Funcionario funcionarioCadastro;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
        this.funcionarioCadastro = funcionarioCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + getCodigo() + " " +
                "Nome='" + getNome() + '\'' +
                "Cpf='" + getCpf() + '\'' +
                "telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", funcionarioCadastro=" + funcionarioCadastro +
                '}';
    }
}
