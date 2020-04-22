package br.com.zup.treinamento.desafios.controllers;

import br.com.zup.treinamento.desafios.models.Result;
import br.com.zup.treinamento.desafios.services.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marvel")
public class ComicsController {

    @Autowired
    ComicsService comicsService;

    //metodo para integrar com a API da marvel e persistir os registros iniciais no banco de dados
    @GetMapping("/register")
    public void registerComics() {
        try {
            comicsService.registerComicsService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo para listar todos os Comics do database
    @GetMapping("/list")
    public ResponseEntity<List<Result>> listComics() {
        return ResponseEntity.ok(comicsService.listComicsService());
    }

    //metodo para listar todos os Comics do database
    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<Result> comics = comicsService.findByIdService(id);
        if (comics.isPresent()) {
            return ResponseEntity.ok(comics);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //metodo para salvar um registro de Comics no banco de dados
    @PostMapping("/save")
    public ResponseEntity saveComics(@RequestBody Result comics) {
        try {
            comicsService.saveComicsService(comics);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //metodo para excluir um registro do banco de dados
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteComics(@PathVariable("id") Long id) {
        if (comicsService.deleteComicsService(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
