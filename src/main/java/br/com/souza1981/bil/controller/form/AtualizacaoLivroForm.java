package br.com.souza1981.bil.controller.form;

import br.com.souza1981.bil.modelo.Livro;
import br.com.souza1981.bil.repository.EditoraRepository;
import br.com.souza1981.bil.repository.LivroRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoLivroForm {

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

    public Livro atualizar(Long id, LivroRepository livroRepository, EditoraRepository editoraRepository) {
        Livro livro = livroRepository.getOne(id);
        livro.setTitulo(titulo);
        livro.setDescricao(descricao);
        livro.setEditora(editoraRepository.findByNome(editora));
        livro.setQuantidadePaginas(quantidadePaginas);
        return livro;
    }
}
