package br.com.souza1981.bil.controller.form;

import br.com.souza1981.bil.modelo.Editora;
import br.com.souza1981.bil.modelo.Livro;
import br.com.souza1981.bil.repository.EditoraRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LivroForm {

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String titulo;

    @NotNull
    @NotEmpty
    private String descricao;

    @NotNull
    private Integer quantidadePaginas;

    @NotNull
    @NotEmpty
    private String editora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Livro converter(EditoraRepository editoraRepository) {
        Editora editora = editoraRepository.findByNome(getEditora());
        return new Livro(titulo, descricao, quantidadePaginas, editora);
    }

}
