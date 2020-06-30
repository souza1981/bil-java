package br.com.souza1981.bil.controller.dto;

public class TokenDTO {

    private String token;

    private String tipo;

    public TokenDTO(String token, String tipo) {
        this.tipo = tipo;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
