package br.com.souza1981.bil.modelo;

import br.com.souza1981.bil.util.Estados;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date dataNascimento;

    private String cidade;

    private Estados estado;

    public Autor(Long id, String nome, Date dataNascimento, String cidade, Estados estado) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public Estados getEstado() {
        return estado;
    }
}
