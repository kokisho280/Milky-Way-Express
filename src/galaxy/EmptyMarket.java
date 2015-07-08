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
public class EmptyMarket extends Recurso{
    public EmptyMarket(){super.nome="E";}

    @Override
    public Recurso duplica() {
        return new EmptyMarket();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        return nome;
    }
}
