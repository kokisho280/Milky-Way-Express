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
public class Aguarda_Compra extends Estado{

    Jogo j;
    
    public Aguarda_Compra(Jogo j){
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
        if(oque.equals("food"))
            j.comprarFood();
        else if(oque.equals("water"))
            j.comprarWater();
        else if(oque.equals("medical"))
            j.comprarMedicalSupplies();
        else if(oque.equals("illegal"))
            j.compraIllegal();
        else if(oque.equals("arma"))
            j.compraArmas();
        else if(oque.equals("carga"))
            j.compraCarga();
            return this;
    }

    @Override
    public Estado terminaCompra() {
        
        return new Aguarda_Movimento(j,false);
    }

    @Override
    public Estado MovimentoW(String nome) {
        return this;
    }

   
    
}
