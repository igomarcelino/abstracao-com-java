package io.github.igomarcelino.clientes.apresentacao;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {

        // atributes
        private JLabel labelNome;
        private TextField fieldNome;
        private JLabel labelCpf;
        private TextField fieldCpf;
        private JLabel labelSexo;
        private JComboBox boxSexo;
        private JButton btnSalvar;




    public TelaCadastro()  {
        construirTela();
    }

    public void construirTela(){
        setSize(600,400);
        setTitle("Cadastro de clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adicionarCampos();
        adicionarBotao();
    }

    // add labels and fields on screen
    private void adicionarCampos(){

        // label nome
        labelNome = new JLabel("Nome: ");
        labelNome.setBounds(20,20,60,20);
        getContentPane().add(labelNome);

        // field nome
        fieldNome = new TextField();
        fieldNome.setBounds(80,20,200,20);
        getContentPane().add(fieldNome);


        // label cpf
        labelCpf = new JLabel("CPF: ");
        labelCpf.setBounds(20,60,60,20);
        getContentPane().add(labelCpf);

        //field cpf
        fieldCpf = new TextField();
        fieldCpf.setBounds(80,60,200,20);
        getContentPane().add(fieldCpf);

        // label sexo
        labelSexo = new JLabel("Sexo: ");
        labelSexo.setBounds(20,100,80,20);
        getContentPane().add(labelSexo);

        // combobox sexo

        TipoSexo[] tipoSexo = {null, TipoSexo.M, TipoSexo.F, TipoSexo.O};
        boxSexo = new JComboBox(tipoSexo);
        boxSexo.setBounds(80,100,40,20);
        getContentPane().add(boxSexo);

        //
    }

    //add buttons on screen
    private void adicionarBotao(){
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20,160,100,20);

        ActionListener acaoBotaoSalvar = this.botaoSalvar();// instancia do listener
        btnSalvar.addActionListener(acaoBotaoSalvar); // adicionando a acao do listener

        getContentPane().add(btnSalvar);

    }

    public ActionListener botaoSalvar(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNome(fieldNome.getText());
                cliente.setCpf(fieldCpf.getText());
                cliente.setSexo((TipoSexo) boxSexo.getSelectedItem());


                JOptionPane.showMessageDialog(null,cliente.getNome()+" " + cliente.getCpf());

            }
        };
    }


}
