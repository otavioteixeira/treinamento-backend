package br.com.zup.treinamento.views;

import br.com.zup.treinamento.controllers.ClienteController;
import br.com.zup.treinamento.models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuCliente extends JFrame {

    private JPanel pnlTelaCliente;
    private JTextField tfCpf;
    private JTextField tfNome;
    private JTextField tfIdade;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JTextField tfEndereco;
    private JButton buscarButton;
    private JButton cadastrarButton;
    private JButton atualizarButton;
    private JButton deletarPorCPFButton;
    private JButton fecharButton;
    private JPanel contentPanel;
    private JButton listarTodosClientesButton;
    private JScrollPane jspConsole;
    private JTextArea taConsole;
    private JButton limparCamposButton;

    public MenuCliente() {
        //Container tela = getContentPane();
        add(pnlTelaCliente);
        ClienteController clienteCtrl = new ClienteController();
        taConsole.setEditable(false);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!validaCampoBranco()) {
                    limparCampos();
                } else {
                    Cliente c = new Cliente();

                    c.setCpf(tfCpf.getText());
                    c.setNome(tfNome.getText());
                    c.setIdade(Integer.parseInt(tfIdade.getText()));
                    c.setEmail(tfEmail.getText());
                    c.setTelefone(tfTelefone.getText());
                    c.setEndereço(tfEndereco.getText());

                    if (clienteCtrl.salvaCliente(c)) {
                        ImageIcon iconConfirm = new ImageIcon("src/br/com/zup/treinamento/views/icons/icons-ok.png");
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Confirmação de Cadastro", JOptionPane.INFORMATION_MESSAGE, iconConfirm);
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao cadastrar Cliente!", "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
                        limparCampos();
                    }
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfCpf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo CPF em branco", "Erro na busca", JOptionPane.ERROR_MESSAGE);
                    limparCampos();
                } else {
                    Cliente c = clienteCtrl.buscaClientePorCPF(tfCpf.getText());
                    if (c == null) {
                        taConsole.setText("Cliente não encontrado!");
                    }
                    taConsole.setText(("Cpf: " + c.getCpf() + "\n" + "Nome: " + c.getNome() + "\n" + "Idade: " + c.getIdade() + "\n" + "Email: " + c.getEmail() + "\n" + "Telefone: " + c.getTelefone() + "\n" + "Endereço: " + c.getEndereço()));
                }
            }
        });
        listarTodosClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Cliente> clientes = clienteCtrl.listaClientes();
                if (clientes.isEmpty()) {
                    taConsole.setText("Não há clientes cadastrados ainda!");
                } else {
                    String lista = "";
                    for (Cliente c : clientes) {
                        lista = lista + ("Cpf: " + c.getCpf() + "\n" + "Nome: " + c.getNome() + "\n" + "Idade: " + c.getIdade() + "\n" + "Email: " + c.getEmail() + "\n" + "Telefone: " + c.getTelefone() + "\n" + "Endereço: " + c.getEndereço() + "\n\n");
                    }
                    taConsole.setText(lista);
                }
            }
        });
        limparCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        deletarPorCPFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfCpf.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo CPF em branco", "Erro na exclusão", JOptionPane.ERROR_MESSAGE);
                    limparCampos();
                } else {
                    if (clienteCtrl.excluiCliente(tfCpf.getText())) {
                        limparCampos();
                        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Exclusão de Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro na exclusão", JOptionPane.ERROR_MESSAGE);
                        limparCampos();
                    }
                }
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!validaCampoBranco()) {
                    limparCampos();
                } else {
                    Cliente c = new Cliente();

                    c.setCpf(tfCpf.getText());
                    c.setNome(tfNome.getText());
                    c.setIdade(Integer.parseInt(tfIdade.getText()));
                    c.setEmail(tfEmail.getText());
                    c.setEndereço(tfEndereco.getText());
                    c.setTelefone(tfTelefone.getText());

                    if (clienteCtrl.atualizaCliente(c.getCpf(), c)) {
                        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!", "Atualização de Cadastro", JOptionPane.INFORMATION_MESSAGE);
                        limparCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro na atualização", JOptionPane.ERROR_MESSAGE);
                        limparCampos();
                    }
                }
            }
        });
        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void limparCampos() {
        tfCpf.setText("");
        tfNome.setText("");
        tfEmail.setText("");
        tfIdade.setText("");
        tfEndereco.setText("");
        tfTelefone.setText("");
        taConsole.setText("");
    }

    public boolean validaCampoBranco() {
        if (tfCpf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo CPF em branco", "Erro no cadatro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tfNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo NOME em branco", "Erro no cadatro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tfIdade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo IDADE em branco", "Erro no cadatro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tfEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo EMAIL em branco", "Erro no cadatro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tfEndereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo ENDEREÇO em branco", "Erro no cadatro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (tfTelefone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo TELEFONE em branco", "Erro no cadatro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

}
