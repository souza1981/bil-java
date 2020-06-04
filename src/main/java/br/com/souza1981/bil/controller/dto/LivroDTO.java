package br.com.souza1981.bil.controller.dto;

import br.com.souza1981.bil.modelo.Livro;
import org.springframework.data.domain.Page;

public class LivroDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer quantidadePaginas;
    private EditoraDTO editora;

    public LivroDTO(Livro livro) {

        id = livro.getId();
        titulo = livro.getTitulo();
        descricao = livro.getDescricao();
        quantidadePaginas = livro.getQuantidadePaginas();
        editora = new EditoraDTO(livro.getEditora());

        metodoExtraido("teste 0");
    }

    public static Page<LivroDTO> converter(Page<Livro> livros) {
        return livros.map(LivroDTO::new);
    }

    public EditoraDTO getEditora() {
        return editora;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    private void metodoExtraido(String x) {
        System.out.println(x);
        System.out.println("teste 1");
    }


}
