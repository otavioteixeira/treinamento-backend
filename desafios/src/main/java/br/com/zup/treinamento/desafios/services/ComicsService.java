package br.com.zup.treinamento.desafios.services;

import br.com.zup.treinamento.desafios.config.ComicsClient;
import br.com.zup.treinamento.desafios.models.Comics;
import br.com.zup.treinamento.desafios.models.Result;
import br.com.zup.treinamento.desafios.repository.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComicsService {

    @Autowired
    ComicsRepository comicsRepository;

    ComicsClient comicsClient = new ComicsClient();

    public List<Result> listComicsService() {
        return comicsRepository.findAll();
    }

    public void registerComicsService() {
        Comics comics = comicsClient.listApiConnect();
        comicsRepository.saveAll(comics.getData().getResults());
    }

    public void saveComicsService(Result comics) {
        comicsRepository.save(comics);
    }

    public Optional<Result> findByIdService(Long id) {
        return comicsRepository.findById(id);
    }

    public boolean deleteComicsService(Long id) {
        try {
            comicsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
