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
public class Food extends Recurso{
   public Food(){super.nome = "F";}

    @Override
    public Recurso duplica() {
        return new Food();
    }

    @Override
    public String getNome() {
        return nome;
    }
    
}
