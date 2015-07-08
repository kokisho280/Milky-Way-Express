/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy;

/**
 *
 * @author Utilizador
 */
public abstract class Recurso {
     protected String nome;
  
  public abstract Recurso duplica();
  public abstract String getNome();
  
   
     @Override
  public String toString(){
      
      return getNome();
  }
}
