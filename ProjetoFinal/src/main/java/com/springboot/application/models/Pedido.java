package com.springboot.application.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50)
    private String vendedor;
    @Column(length = 50)
    private String produtov;
    @Column(length = 10)
    private int quantidadev;
    @Column()
    private int valor;
    @Column(length = 50)
    private String clientev;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getClientev() {
        return clientev;
    }

    public void setClientev(String clientev) {
        this.clientev = clientev;
    }

    public String getProdutov() { return produtov;  }

    public void setProdutov(String produtov) {
        this.produtov = produtov;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidadev() {
        return quantidadev;
    }

    public void setQuantidadev(int quantidadev) {
        this.quantidadev = quantidadev;
    }

    public Pedido(String vendedor, String produtov, int valor, int quantidadev, String clientev) {
        super();
        this.vendedor = vendedor;
        this.produtov = produtov;
        this.valor = valor;
        this.quantidadev = quantidadev;
        this.clientev = clientev;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", vendedor=" + vendedor + ", produto=" + produtov + ", quantidade=" + quantidadev + ", valor=" + valor + ", cliente=" +clientev + "]";
    }

    public Pedido() {
        super();
    }

}
