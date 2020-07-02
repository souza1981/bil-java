package br.com.souza1981.bil.controller.form;

import br.com.souza1981.bil.modelo.Editora;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EditoraForm {

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String nome;

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

    public Editora converter() {
        return new Editora(getNome(), getEmail());
    }
}
