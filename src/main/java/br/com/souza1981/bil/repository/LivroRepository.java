package br.com.souza1981.bil.repository;

import br.com.souza1981.bil.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByEditora_Nome(String nomeEditora); // Padrão é nome da classe e depois atributo da classe

    List<Livro> findByAutor_Nome(String nomeAutor);
}
