/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import galaxy.Carta;



/**
 *
 * @author Ricardo
 */
public class Aguarda_Movimento_WormHole extends Estado{
     Jogo j;
    
    public Aguarda_Movimento_WormHole(Jogo j){
        this.j = j;
    }
    @Override
    public Estado movimento(Carta c) {
        return this;
    }

    @Override
    public Estado terminaMovimento() {
        return this;
    }

    @Override
    public Estado vende(String oque) {
        return this;
    }

    @Override
    public Estado terminaVenda() {
        return this;
    }

    @Override
    public Estado compra(String oque) {
        return this;
    }

    @Override
    public Estado terminaCompra() {
        return this;
    }

    @Override
    public Estado MovimentoW(String nome) {
        if(j.cartaWH(nome))
        return new Aguarda_Movimento(j,true);
        else
        return this;
    }

    
    
    
    
}
