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
public class Jogador {
    String nome;
    private int coins;
    private Spaceship nave;
    
    
    public Jogador(){
        nave = new Spaceship();
        coins = 10;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Spaceship getNave() {
        return nave;
    }

    public void setNave(Spaceship nave) {
        this.nave = nave;
    }
    
    public int aumentaAtaqueNave(){
        int x = getNave().aumentaForca();
        coins = coins - x;
        return x;
    }
    public int aumentaCargaNave(){
        int x = getNave().aumentaCarga();
        coins = coins - x;
        return x;
    }
}
