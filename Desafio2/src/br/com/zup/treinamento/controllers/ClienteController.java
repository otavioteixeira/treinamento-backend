package br.com.zup.treinamento.controllers;

import br.com.zup.treinamento.models.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    List<Cliente> clientes = new ArrayList<>();

    public boolean salvaCliente(Cliente cliente){
        try {
            clientes.add(cliente);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente buscaClientePorCPF(String cpf){
        for(Cliente c: clientes){
            if (c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public List<Cliente> listaClientes(){
        return clientes;
    }

    public boolean excluiCliente(String cpf){
        for(Cliente c: clientes){
            if (c.getCpf().equals(cpf)){
                clientes.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean atualizaCliente(String cpf, Cliente novoCliente){
        for(int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getCpf().equals(cpf)){
                clientes.get(i).setNome(novoCliente.getNome());
                clientes.get(i).setEmail(novoCliente.getEmail());
                clientes.get(i).setEndereço(novoCliente.getEndereço());
                clientes.get(i).setIdade(novoCliente.getIdade());
                clientes.get(i).setTelefone(novoCliente.getTelefone());

                return true;
            }
        }
        return false;
    }
}
