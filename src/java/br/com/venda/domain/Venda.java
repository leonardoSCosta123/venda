/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.domain;

import java.util.List;

/**
 *
 * @author leona
 */
public class Venda {
    private String formaPagamento;
    private double totalVenda;
    private Boolean finalizada;
    private List<VendaItem> listaVendaItem;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public List<VendaItem> getListaVendaItem() {
        return listaVendaItem;
    }

    public void setListaVendaItem(List<VendaItem> listaVendaItem) {
        this.listaVendaItem = listaVendaItem;
    }
    
    
}
