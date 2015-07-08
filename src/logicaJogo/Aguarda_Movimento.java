/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import galaxy.Carta;
import galaxy.CartaWormHole;


/**
 *
 * @author Ricardo
 */
public class Aguarda_Movimento extends Estado{

     Jogo j;
     boolean ja_moveu;
    
    public Aguarda_Movimento(Jogo j,boolean m){
        this.j = j;
        ja_moveu = m;
    }
    @Override
    public Estado movimento(Carta c) {
      
        if(j.move(c))
        {
            ja_moveu = true;
            
            if(j.getCartaActual() instanceof CartaWormHole)
                return new Aguarda_Movimento_WormHole(j);
        }
        
        
        return this;
    }

    @Override
    public Estado terminaMovimento() {
        if(ja_moveu){
         j.explore();
         j.getGestorMercado().reabasteceAllPlanets();
        return new Aguarda_Venda(j);
        }
        else
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
        return this;
    }
    
    
    
    
}
