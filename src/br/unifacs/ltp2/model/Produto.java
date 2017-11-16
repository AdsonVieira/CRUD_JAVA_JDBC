/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifacs.ltp2.model;

/**
 *
 * @author adson
 */
public class Produto {
    
    private int produto_id;
    private String descricao;
    private int quantidade;
    private String preco;
    
    
    public Produto(int produto_id, String descricao, int quantidade, String preco) {
        this.produto_id = produto_id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(int produto_id, String descricao, int quantidade) {
        this.produto_id = produto_id;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Produto() {
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
    
}
