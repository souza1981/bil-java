package br.com.souza1981.bil.repository;

import br.com.souza1981.bil.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
