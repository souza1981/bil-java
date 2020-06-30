package br.com.souza1981.bil.controller.form;

import br.com.souza1981.bil.modelo.Autor;
import br.com.souza1981.bil.modelo.Categoria;
import br.com.souza1981.bil.modelo.Editora;
import br.com.souza1981.bil.modelo.Livro;
import br.com.souza1981.bil.repository.AutorRepository;
import br.com.souza1981.bil.repository.CategoriaRepository;
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

    @NotNull
    @NotEmpty
    private String autor;

    @NotNull
    @NotEmpty
    private String categoria;

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

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public Livro converter(EditoraRepository editoraRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Editora editora = editoraRepository.findByNome(getEditora());
        Autor autor = autorRepository.findByNome(getAutor());
        Categoria categoria = categoriaRepository.findByNome(getCategoria());
        return new Livro(titulo, descricao, quantidadePaginas, editora, autor, categoria);
    }

}
