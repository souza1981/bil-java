package br.com.souza1981.bil.repository;

import br.com.souza1981.bil.modelo.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    Editora findByNome(String editora);
}
