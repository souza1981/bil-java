package br.com.souza1981.bil.repository;

import br.com.souza1981.bil.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String categoria);
}
