
package gui;

import galaxy.Carta;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import logicaJogo.Jogo;

/**
 *
 * @author Utilizador
 */
public class PainelTabuleiro extends JPanel{
    
    JPanel [][] tab;
    Jogo jogo;
    JPanel ptab ;
    ArrayList<Carta> tabu = new ArrayList();
    
    PainelTabuleiro(Jogo jogo){
        this.jogo = jogo;
        tab  = new JPanel [7][9];
        ptab = new JPanel(new GridLayout(7,9));
        tabu = jogo.getTabuleiro();
        inicializaPainelTabuleiro();

    }
     
    void inicializaPainelTabuleiro(){
        String m1, m2;

        for(int i=0; i<tab.length;i++){
            for(int y=0; y<tab[i].length; y++){
                JPanel pbranco = new JPanel();
                pbranco.setBackground(Color.white);
                tab[i][y] = pbranco;
            }
        }
        
        for(int i=0; i<tab.length;i++){
            for(int y=0; y<tab[i].length; y++){
                for(int k=0; k<tabu.size(); k++){
                    if(tabu.get(k).getCord().getX() == i && tabu.get(k).getCord().getY() == y){
                        if(tabu.get(k).isVirada()){
                            tab[i][y] = new PainelCarta(tabu.get(k).getNome(),true,new ModeloCarta(tabu.get(k)),jogo);  
                        }else{
                            JPanel pazul = new JPanel();
                            pazul.setBackground(Color.blue);
                            tab[i][y] = pazul;
                        }
                    }
                }
            }
        }
        for(int i=0; i<tab.length;i++){
            for(int y=0; y<tab[i].length; y++){
                ptab.add(tab[i][y]);
            }
        }
        
        this.add(ptab);
    }    
}