package br.com.zup.treinamento.desafios.repository;

import br.com.zup.treinamento.desafios.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicsRepository extends JpaRepository<Result, Long> {
}
