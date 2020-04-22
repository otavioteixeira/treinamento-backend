package br.com.zup.treinamento.desafios.controllers;

import br.com.zup.treinamento.desafios.models.Comics;
import br.com.zup.treinamento.desafios.services.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/marvel")
public class ComicsController {

    @Autowired
    ComicsService comicsService;

    @GetMapping("/list")
    public Comics listComics(){
       return comicsService.listComicsService();
       // return comicsService.listComicsService();
    }
}
