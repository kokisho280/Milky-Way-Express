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
public class Water extends Recurso{
   public Water(){super.nome ="W";}

    @Override
    public Recurso duplica() {
        return new Water();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
