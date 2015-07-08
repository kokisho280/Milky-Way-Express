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
public class Illegal extends Recurso {
    public Illegal(){super.nome ="I";}

    @Override
    public Recurso duplica() {
        return new Illegal();
    }

    @Override
    public String getNome() {
       return nome;
    }

    
    
}
