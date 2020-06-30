package br.com.souza1981.bil.modelo;

import javax.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer quantidadePaginas;
    @ManyToOne
    private Editora editora;

    @OneToOne
    private Autor autor;

    @OneToOne
    private Categoria categoria;

    public Livro(String titulo, String descricao, Integer quantidadePaginas, Editora editora, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.quantidadePaginas = quantidadePaginas;
        this.editora = editora;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public Livro() {

    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro(String titulo, String descricao, int quantidadePaginas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.quantidadePaginas = quantidadePaginas;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}
