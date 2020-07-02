package br.com.souza1981.bil.controller.dto;

import br.com.souza1981.bil.modelo.Autor;

import java.time.LocalDateTime;

public class AutorDTO {

    private Long id;

    private String nome;

    private LocalDateTime dataNascimento;

    private String cidade;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    private String estado;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataNascimento = autor.getDataNascimento();
        this.cidade = autor.getCidade();
        this.estado = autor.getEstado().getNome();
    }
}
