/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy;


/**
 *
 * @author Ricardo
 */
public class Carta {
    Cordenada cord;
  protected boolean virada;

    
    String nome;
    
    public Carta(boolean virada, int linha, int col, String n) {
        this.virada = virada;
        this.cord = new Cordenada(linha,col);
        
        nome = n;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public String getNome() {
        return nome;
    }
    public boolean isVirada() {
        return virada;
    }

    public void setVirada(boolean virada) {
        this.virada = virada;
    }

   public void setCord(Cordenada c){
       this.cord = c;
   }

    public Cordenada getCord() {
        return cord;
    }
   
}
