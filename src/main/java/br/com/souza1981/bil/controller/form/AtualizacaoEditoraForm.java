package br.com.souza1981.bil.controller.form;

import br.com.souza1981.bil.modelo.Editora;
import br.com.souza1981.bil.repository.EditoraRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoEditoraForm {

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String nome;


    @NotNull
    @NotEmpty
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Editora atualizar(Long id, EditoraRepository editoraRepository) {
        Editora editora = editoraRepository.getOne(id);
        editora.setNome(getNome());
        editora.setEmail(getEmail());
        editoraRepository.save(editora);
        return editora;
    }
}
