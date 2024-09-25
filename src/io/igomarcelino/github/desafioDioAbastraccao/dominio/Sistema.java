package io.igomarcelino.github.desafioDioAbastraccao.dominio;

import java.util.*;

public class Sistema {
    private List<Pessoa> pessoaList;
    private List<Jogo> jogoList;
    private List<Aluguel> aluguelList;
    private Scanner scanner;

    public Sistema() {
        this.pessoaList = new LinkedList<>();
        this.jogoList = new LinkedList<>();
        this.aluguelList = new LinkedList<>();
        this.scanner = new Scanner(System.in);
    }


    /**
     * Tela principal do sistema , contem a tela de cadastros e alugueis
     */
    protected void telaPrincipal() {
        menu();
    }

    protected void menu() {
        int opcao = 0;
        do {
            System.out.println("==== Sistema Locadora ====");
            System.out.println(" ");
            System.out.println("=== MENU ===");
            System.out.println("[ 1 ] Cadastro Funcionario");
            System.out.println("[ 2 ] Cadastros");
            System.out.println("[ 3 ] Aluguel de Jogos");
            System.out.println("[ 4 ] Relatorios");
            System.out.println("[ 5 ] Sair");
            System.out.print("opcao: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    telaCadastroFuncionario();
                    break;
                case 2 :
                    telaCadadstro();
                case 5:
                    System.out.println("Saindo do sistema");
            }
        } while (opcao != 5);


    }

    private void telaCadastroFuncionario() {
        int opcao;
        do {
            System.out.println("==== Cadastro ====");
            System.out.print("[ 1 ] Cadastrar Funcionario\n[ 2 ] Sair\nopcao: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    Funcionario funcionario = new Funcionario();
                    System.out.println("==== Cadastro de Funcionario ====");
                    System.out.print("Nome: ");
                    funcionario.setNome(scanner.next());
                    System.out.print("CPF: ");
                    funcionario.setCpf(scanner.next());
                    adicionarPessoas(funcionario);
                    break;
                case 2:
                    System.out.println("Voltando ao menu...");
            }
        } while (opcao != 2);

    }

    private void telaCadadstro() {
        int opcao;
        // informar o funcionario que esta cadastrando o cliente
        System.out.print("Informe o CPF do funcionario de cadastro: ");
        String cpfFuncionario = scanner.next();
        //Verifica se o funcionario existe
        Funcionario funcionarioCadastro = (Funcionario) pessoaList.stream().
                filter(pessoa -> pessoa.getCpf().equalsIgnoreCase(cpfFuncionario)).
                findAny().
                get();
        // verifica se o funcionario foi encontrado e entra no menu

        if (funcionarioCadastro != null) {
            do {
                System.out.println("==== Cadastro ====");
                System.out.print("[ 1 ] Cadastrar cliente\n[ 2 ] Cadastrar Jogo\n[ 3 ] Sair\nopcao: ");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        Cliente cliente = new Cliente();
                        System.out.println("==== Cadastro de clientes ====");
                        System.out.print("CPF: ");
                        cliente.setCpf(scanner.next());
                        System.out.print("Nome: ");
                        cliente.setNome(scanner.next());
                        System.out.print("Telefone: ");
                        cliente.setTelefone(scanner.next());
                        System.out.print("email: ");
                        cliente.setEmail(scanner.next());
                        System.out.print("Endereco: ");
                        cliente.setEndereco(scanner.next());
                        cliente.setFuncionarioCadastro(funcionarioCadastro);
                        adicionarPessoas(cliente);
                        System.out.println("Cadastro realizado");
                        break;
                    case 2:
                        Jogo jogo = new Jogo();
                        System.out.println("=== Cadastro de Jogos === ");
                        System.out.print("Nome: ");
                        jogo.setNome(scanner.next());
                        System.out.print("Fabricante: ");
                        jogo.setFabricante(scanner.next());
                        System.out.print("Total de jogadores: ");
                        jogo.setTotalJogadores(scanner.nextInt());
                        System.out.print("Ano de publicacao: ");
                        jogo.setAnoPublicacao(scanner.nextInt());
                        System.out.print("Estoque: ");
                        jogo.setQuantidadeDisponivel(scanner.nextInt());
                        jogo.setFuncionario(funcionarioCadastro);
                        adicionarJogos(jogo);
                    case 3:
                        System.out.println("Voltando ao menu...");
                        break;
                    default:
                        System.out.println("Informe uma opcao");
                }
            } while (opcao != 3);
        }

    }


    /**
     * Metodo responsavel pelo cadastro de alugueis no lista de aluguel
     */
    public void cadastrarAluguel(Aluguel aluguel) {
        this.aluguelList.add(aluguel);
        System.out.println(aluguelList);
    }

    /**
     * Metodo responsavel por adicionar pessoas na lista de pessoas
     */
    private void adicionarPessoas(Pessoa pessoa) {
        this.pessoaList.add(pessoa);
    }

    /**
     * Metodo responsavel por cadastrar o jogo na lista de jogo,
     */

    private void adicionarJogos(Jogo jogo) {
        this.jogoList.add(jogo);
    }

    public void imprimirPessoas() {
        System.out.println(pessoaList);
    }

    public void imprimirJogos() {
        System.out.println(jogoList);
    }

    public void imprimirAlugueis() {
        System.out.println(aluguelList);
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
