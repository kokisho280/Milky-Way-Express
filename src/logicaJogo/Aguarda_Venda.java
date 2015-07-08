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
public class Aguarda_Venda extends Estado{
     Jogo j;
    
    public Aguarda_Venda(Jogo j){
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
        if(oque.equals("food"))
            j.vendeFood();
        else if(oque.equals("water"))
            j.vendeWater();
        else if(oque.equals("medical"))
            j.vendeMedicalSupplies();
        else if(oque.equals("illegal"))
            j.vendeIllegal();
            return this;
    }

    @Override
    public Estado terminaVenda() {
        return new Aguarda_Compra(j);
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
        return this;
    }

   
}
