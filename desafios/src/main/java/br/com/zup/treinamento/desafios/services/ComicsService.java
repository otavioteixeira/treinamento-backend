package br.com.zup.treinamento.desafios.services;

import br.com.zup.treinamento.desafios.Connectors.ComicsClient;
import br.com.zup.treinamento.desafios.models.Comics;
import org.springframework.stereotype.Service;

@Service
public class ComicsService {

    public Comics listComicsService(){
        ComicsClient comicsClient = new ComicsClient();
        return comicsClient.listApiConnect();
    }
}
