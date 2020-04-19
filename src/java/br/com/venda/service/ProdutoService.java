/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.service;

import br.com.venda.domain.Produto;
import br.com.venda.domain.Venda;
import br.com.venda.domain.VendaItem;
import java.util.List;

/**
 *
 * @author leona
 */
public class ProdutoService {
    
    
    public Boolean inserir(List<Produto> lista,Produto produto){
        if(lista != null){
            lista.add(produto);
            return true;
        }else
            return false;
    }
    
    public Boolean remove(List<Produto> lista,Produto produto,Venda venda){
        if(lista != null){
            lista.remove(produto);
            for (VendaItem item : venda.getListaVendaItem()) {
                if(item.getProduto().equals(produto)){
                    venda.getListaVendaItem().remove(item);
                    break;
                }
            }
            return true;
        }else
            return false;
    }
    
    public Boolean editar(List<Produto> lista,Produto produto){
        if(lista != null){
            lista.remove(produto);
            lista.add(produto);
            return true;
        }else
            return false;
    }
    
    
    
    
}
