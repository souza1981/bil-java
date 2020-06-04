package br.com.souza1981.bil.controller.dto;

import br.com.souza1981.bil.modelo.Editora;

import java.util.List;
import java.util.stream.Collectors;

public class EditoraDTO {

    private Long id;
    private String nome;
    private String email;

    public EditoraDTO(Editora editora) {
        this.id = editora.getId();
        this.nome = editora.getNome();
        this.email = editora.getEmail();
    }

    public static List<EditoraDTO> converter(List<Editora> editoras) {
        return editoras.stream().map(EditoraDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
