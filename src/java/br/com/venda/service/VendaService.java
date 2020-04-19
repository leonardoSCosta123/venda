/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.service;

import br.com.venda.domain.Venda;
import br.com.venda.domain.VendaItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leona
 */
public class VendaService {
    
    public void inserirItemNaVenda(Venda venda,VendaItem vendaItem){
        if(venda.getListaVendaItem() != null){
            Boolean possuiProduto = false;
            for (VendaItem vendaI : venda.getListaVendaItem()) {
                if(vendaI.getProduto().equals(vendaItem.getProduto())){
                    possuiProduto = true;
                    vendaI.setQuantidade(vendaI.getQuantidade()+1);
                    break;
                }
            }
            if(possuiProduto.equals(Boolean.FALSE)){
                venda.getListaVendaItem().add(vendaItem);
            }
        }else{
            List<VendaItem> lista = new ArrayList<>();
            lista.add(vendaItem);
            venda.setListaVendaItem(lista);
        }
    }
    
}
