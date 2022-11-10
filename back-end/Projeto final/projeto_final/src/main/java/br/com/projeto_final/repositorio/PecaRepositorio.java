package br.com.projeto_final.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto_final.modelo.PecaModelo;

@Repository
public interface PecaRepositorio extends CrudRepository<PecaModelo, Long> {
    
}
