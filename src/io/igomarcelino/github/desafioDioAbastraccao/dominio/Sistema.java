package io.igomarcelino.github.desafioDioAbastraccao.dominio;

import java.time.LocalDate;
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
        cadastrarMaster();
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
            System.out.println("[ 4 ] Devolucao de Jogos");
            System.out.println("[ 5 ] Relatorios");
            System.out.println("[ 6 ] Sair");
            System.out.print("opcao: ");
            try
            {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        telaCadastroFuncionario();
                        break;
                    case 2 :
                        telaCadadstro();
                        break;
                    case 3 :
                        realizarAluguel();
                        break;
                    case 4:
                        relatorios();
                        break;
                    case 5:
                        System.out.println("Saindo do sistema");
                        break;
                }

            }catch (InputMismatchException e){
                System.out.println("Opcao invalida, informar apenas numeros!");
            }
        } while (opcao != 6);


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
                    String cpf = scanner.next();
                    boolean checaCpf = verificarCpfJaCadastrado(cpf);
                    if (!checaCpf){
                        // Verifica se o cpf contem apenas numeros e tem um tamnho de 11 caracteres
                        while (!cpf.matches("\\d+$") && cpf.length() == 11){
                            System.out.println("CPF invalido!");
                            System.out.print("CPF: ");
                        }
                        funcionario.setCpf(cpf);
                        adicionarPessoas(funcionario);
                    }else {
                        System.out.println("Pessoa ja cadastrada!");
                    }
                    break;
                case 2:
                    System.out.println("Voltando ao menu...");
            }
        } while (opcao != 2);

    }

    private void telaCadadstro() {
        int opcao;
        // informar o funcionario que esta cadastrando o cliente
        System.out.print("==== Identificacao do funcionario ====");
        System.out.print("\nCPF: ");
        try{
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
                            String cpf = scanner.next();
                            boolean checaCPF = verificarCpfJaCadastrado(cpf);
                            if (!checaCPF){
                                while (!cpf.matches("\\d+$") && cpf.length() == 11){
                                    System.out.println("CPF invalido!");
                                    System.out.print("CPF: ");
                                    cpf = scanner.next();
                                }
                                cliente.setCpf(cpf);
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
                            }else {
                                System.out.println("Pessoa ja cadastrada!");
                            }
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
                            System.out.println("Opcao invalida!");
                    }
                } while (opcao != 3);
            }
        }catch (NoSuchElementException e){
            System.out.println("Funcionario nao localizado, error: " + e.getMessage());
        }
    }


    /**
     * Metodo responsavel pelo cadastro de alugueis no lista de aluguel
     */
    public void realizarAluguel() {
        int opcao;
        // informar o funcionario que esta cadastrando o cliente
        System.out.print("==== Identificacao do funcionario ====");
        System.out.print("\nCPF: ");
        try {
            String cpfFuncionario = scanner.next();
            //Verifica se o funcionario existe
            Funcionario funcionarioCadastro = (Funcionario) pessoaList.stream().
                    filter(pessoa -> pessoa.getCpf().equalsIgnoreCase(cpfFuncionario)).
                    findAny().
                    get();
            if (funcionarioCadastro != null){
                System.out.println("==== Aluguel de jogos ====");
                Jogo jogoAluguel = new Jogo();
                Cliente clienteAluguel = new Cliente();
                System.out.print("Nome do jogoAluguel: ");
                String jogoNome = scanner.next();
                jogoAluguel = procucarJogo(jogoNome);
                if (jogoAluguel != null){
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.next();
                    clienteAluguel = (Cliente) procurarPessoa(cpfCliente);
                    if (clienteAluguel != null){
                        Aluguel aluguel = new Aluguel();
                        aluguel.alugarJogo(clienteAluguel,jogoAluguel,"Alugado", LocalDate.now(),funcionarioCadastro,10.00);
                        System.out.println("Aluguel de n "+ aluguel.getCodigo() + " realizado com sucesso!");
                        alterarEstoqueJogoAlguel(jogoAluguel);

                    }else {
                        System.out.println("Cliente nao localizado!");
                    }
                }else {
                    System.out.println("Jogo nao localizado");
                }
            }

        }catch (NoSuchElementException e){
            System.out.println("Funcionario nao localizado, error: " + e.getMessage());
        }

    }

    /**
     * Metodo que chama os relatorios
     * */

    public void relatorios(){
        int opcao;
        do {
            System.out.print("=== Relatorios ===");
            System.out.print("\n[ 1 ] imprimir pessoas");
            System.out.print("\n[ 2 ] imprimir jogos");
            System.out.print("\n[ 3 ] imprimir alugueis");
            System.out.print("\n[ 4 ] sair");
            System.out.print("\nOpcao: ");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    imprimirPessoas();
                    break;
                case 2:
                    imprimirJogos();
                    break;
                case 3:
                    imprimirAlugueis();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");

            }
        }while (opcao != 4);
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
        if (!pessoaList.isEmpty()){
            pessoaList.stream().forEach(pessoa -> System.out.println(pessoa+ "\n"));
        }else {
            System.out.println("Lista de pessoas esta vazia!");
        }
    }

    public void imprimirJogos() {
        if (!jogoList.isEmpty()){
            jogoList.stream().forEach(jogo -> System.out.println(jogo + "\n"));
        }else {
            System.out.println("Lista de Jogos esta vazia!");
        }
    }

    public void imprimirAlugueis() {
        if (!aluguelList.isEmpty()){
            aluguelList.stream().forEach(aluguel-> System.out.println(aluguel + "\n"));
        }else {
            System.out.println("\nLista de alugueis esta vazia!\n");
        }
    }

    /**
     * Verifica se a pessoa ja nao foi cadastrada no sistema.
     * */
    public boolean verificarCpfJaCadastrado(String cpf){
        return pessoaList.stream().anyMatch(cpfCadastrado -> cpfCadastrado.getCpf().equalsIgnoreCase(cpf));
    }
    public Pessoa procurarPessoa(String cpf){
        return pessoaList.stream().filter(cpfPessoa-> cpfPessoa.getCpf().equalsIgnoreCase(cpf)).findAny().get();
    }
    public Jogo procucarJogo(String titulo){
        return jogoList.stream().filter(nomeJogo -> nomeJogo.getNome().equalsIgnoreCase(titulo)).findAny().get();
    }

    /**
     * Aqui estamos recebendo um objeto do tipo jogo e alterando sua quantidade em estoque
     * */
    public void alterarEstoqueJogoAlguel(Jogo jogo){
        jogoList.stream().
                filter(jogoAlugado1 -> jogoAlugado1.equals(jogo)).
                limit(1).
                forEach(ajustaEstoque -> ajustaEstoque.setQuantidadeDisponivel(ajustaEstoque.getQuantidadeDisponivel() -1 ));
    }

    public void alterarEstoqueJogoDevolucao(Jogo jogo){
        jogoList.stream().
                filter(jogoAlugado1 -> jogoAlugado1.equals(jogo)).
                limit(1).
                forEach(ajustaEstoque -> ajustaEstoque.setQuantidadeDisponivel(ajustaEstoque.getQuantidadeDisponivel() + 1 ));
    }

    public  void cadastrarMaster(){
        Funcionario funcionario = new Funcionario("master","999999");
        adicionarPessoas(funcionario);
        Cliente cliente = new Cliente();
        cliente.setNome("teste");
        cliente.setCpf("123");
        cliente.setEndereco("Rua jua");
        cliente.setTelefone("13899882");
        cliente.setEmail("jjes@jjdasdsa.com");
        cliente.setFuncionarioCadastro(funcionario);
        adicionarPessoas(cliente);
        Jogo jogo = new Jogo();
        jogo.setNome("age");
        jogo.setFabricante("Micro");
        jogo.setAnoPublicacao(1995);
        jogo.setQuantidadeDisponivel(10);
        jogo.setTotalJogadores(10);
        jogo.setFuncionario(funcionario);
        jogoList.add(jogo);
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
