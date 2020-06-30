package br.com.souza1981.bil.controller.dto;

import br.com.souza1981.bil.modelo.Autor;

import java.util.Date;

public class AutorDTO {

    private Long id;

    private String nome;

    private Date dataNascimento;

    private String cidade;

    private String estado;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataNascimento = autor.getDataNascimento();
        this.cidade = autor.getCidade();
        this.estado = autor.getEstado().getNome();
    }
}
