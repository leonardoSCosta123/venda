/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.controller;

import br.com.mercadoservicos.util.Mensagens;
import br.com.venda.domain.Produto;
import br.com.venda.domain.Venda;
import br.com.venda.domain.VendaItem;
import br.com.venda.service.VendaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author leona
 */
@ManagedBean(name="vendaMB")
@SessionScoped
public class VendaController implements Serializable{
    private Venda venda = new Venda();
    private VendaService vendaService = new VendaService();
    private List<VendaItem> listaItens = new ArrayList<>();
    private String[] formasPagamento = {"Dinheiro","cartão de crédito","cartão de débito"};

    
    public VendaController(){
    }
    
    public String add(Produto produto){
        VendaItem vendaItem = new VendaItem();
        vendaItem.setProduto(produto);
        vendaItem.setQuantidade(1);
        vendaItem.setValor(produto.getValor());
        vendaService.inserirItemNaVenda(venda, vendaItem);
        this.listaItens = venda.getListaVendaItem();
        return "list.xhtml?faces-redirect=true";
    }
    
    public String finalizar(){
        if(venda.getFormaPagamento() == null){
            Mensagens.mensagemErro("Erro", "Forma de pagamento é obrigatória.");
            return voltar();
        }
        venda.setFinalizada(true);
        return voltar();
    }
    
     public String voltarCompras(){
        this.venda = new Venda();
        getListaItens();
        venda.setFinalizada(false);
        return voltar();
    }
    
    public String voltar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String getValorTotal(){
        double total = 0.0;
        for (VendaItem vendaItem : venda.getListaVendaItem()) {
            total+= vendaItem.getValor() * vendaItem.getQuantidade();
        }
        return "R$"+Double.toString(total)+"0";
    }
    
//    === get e set

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public VendaService getVendaService() {
        return vendaService;
    }

    public void setVendaService(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public String[] getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(String[] formasPagamento) {
        this.formasPagamento = formasPagamento;
    }
    

    public List<VendaItem> getListaItens() {
        if(venda.getListaVendaItem() == null){
            List<VendaItem> listaVendaItens = new ArrayList<>();
            venda.setListaVendaItem(listaVendaItens);
        }
        listaItens = venda.getListaVendaItem();
        return listaItens;
    }

    public void setListaItens(List<VendaItem> listaItens) {
        this.listaItens = listaItens;
    }

    
    
}
