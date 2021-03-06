package br.com.souza1981.bil.repository;

import br.com.souza1981.bil.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String autor);
}
