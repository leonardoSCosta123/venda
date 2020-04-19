/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.controller;

import br.com.mercadoservicos.util.Mensagens;
import br.com.venda.domain.Produto;
import br.com.venda.domain.Venda;
import br.com.venda.service.ProdutoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author leona
 */
@ManagedBean(name="produtoMB")
@SessionScoped
public class ProdutoController implements Serializable{
    private List<Produto> lista = new ArrayList<>();;
    private Produto produto = new Produto();;
    private Boolean admin;
    private ProdutoService produtoService =  new ProdutoService();
    
    public ProdutoController(){
    }
    
    public String novo(){
        this.produto = new Produto();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String salva(){
        if(produtoService.inserir(lista,produto)){
            Mensagens.mensagemSucesso("Sucesso", "Registro salvo com sucesso");
            return "list.xhtml?faces-redirect=true";
        }
        Mensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o registro.");
        return null ;
        
    }
     
    public String editar(Produto produto){
        this.produto = produto;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String excluir(Produto produto, Venda vendaController){
//        remove o produto e o item do carrinho pois o produto não existe mais.
        if(produtoService.remove(lista, produto, vendaController)){
            Mensagens.mensagemSucesso("Sucesso", "Registro salvo com sucesso");
            
            return voltar();
        }
        Mensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o registro.");
        return null ;
    }
    
    public String alterar(){
        produtoService.editar(lista, produto);
        return voltar();
    }
    
    public String voltar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    
    
    
    
    
//    === get e set

    public List<Produto> getLista() {
        return lista;
    }

    public void setLista(List<Produto> lista) {
        this.lista = lista;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    
}
