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
public abstract class Estado{
   
    public abstract Estado movimento(Carta c);
    
    public abstract Estado terminaMovimento();
    
    public abstract Estado MovimentoW(String nome);
    
    public abstract Estado vende(String oque);
    
    public abstract Estado terminaVenda();
    
    public abstract Estado compra(String oque);
    
    public abstract Estado terminaCompra();
    
    
    
    
    
}
