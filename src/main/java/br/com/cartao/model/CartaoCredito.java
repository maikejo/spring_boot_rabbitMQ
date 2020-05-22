package br.com.cartao.model;

import java.io.Serializable;

/**
 * Model de um cartao de credito, será serializado
 * e desserializado pelo xstream. A mesagem em XML trafega pelos arquivos e filas.
 *
 * @author Maike Silva
 * @version 1.0
 * @since 04/05/2020
 *
 */
public class CartaoCredito implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long numero;
    private String bandeira;
    private Integer seguranca;
    private String nomeResponsavel;

    public CartaoCredito() {
    }

    public CartaoCredito(Long numero, String bandeira, Integer seguranca,
                         String nomeResponsavel) {
        super();
        this.numero = numero;
        this.bandeira = bandeira;
        this.seguranca = seguranca;
        this.nomeResponsavel = nomeResponsavel;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Integer getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Integer seguranca) {
        this.seguranca = seguranca;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
}

