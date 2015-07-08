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
public class MedicalSupplies extends Recurso{
    public MedicalSupplies(){super.nome ="M";}

    @Override
    public Recurso duplica() {
        return new MedicalSupplies();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
