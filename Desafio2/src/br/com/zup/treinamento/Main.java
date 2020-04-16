package br.com.zup.treinamento;

import br.com.zup.treinamento.views.MenuCliente;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        MenuCliente mnCliente = new MenuCliente();
        mnCliente.setTitle("Tela Inicial");
        mnCliente.pack();
        mnCliente.setLocationRelativeTo(null);
        mnCliente.setSize(500, 800);
        mnCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mnCliente.setVisible(true);

    }
}
