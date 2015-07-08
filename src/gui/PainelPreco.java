/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Utilizador
 */
 public class PainelPreco extends JPanel{
    JPanel mainPanel;
    PainelPreco(String n){
        
        mainPanel = new JPanel(new GridLayout(4,2));
     
        if(n.equals("Gethen")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 2"));
            mainPanel.add(new Desenho(1,1,15,15,Color.black));
            mainPanel.add(new JLabel(" = 3"));
        }
        else if(n.equals("Kiber")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 2"));
            mainPanel.add(new Desenho(1,1,15,15,Color.black));
            mainPanel.add(new JLabel(" = 3"));
        }
        else if(n.equals("Reverie")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 2"));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new Desenho(1,1,15,15,Color.black));
            mainPanel.add(new JLabel(" = 3"));
        }
        else if(n.equals("Tiamat")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 2"));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new Desenho(1,1,15,15,Color.black));
            mainPanel.add(new JLabel(" = 3"));
        }
        else if(n.equals("Lamarckia")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 2"));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new Desenho(1,1,15,15,Color.black));
            mainPanel.add(new JLabel(" = 3"));
        }
        else if(n.equals("Arrakis")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 2"));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new Desenho(1,1,15,15,Color.black));
            mainPanel.add(new JLabel(" = 3"));
        }
        else if(n.equals("Whirl")){
            mainPanel.add(new JLabel("   "));
            mainPanel.add(new JLabel("   "));
            mainPanel.add(new Desenho(1,1,15,15,Color.yellow));
            mainPanel.add(new JLabel(" = 1"));
            mainPanel.add(new JLabel("   "));
            mainPanel.add(new JLabel("   "));
            mainPanel.add(new JLabel("   "));
            mainPanel.add(new JLabel("   "));
        }
        else if(n.equals("Striterax")){
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new Desenho(1,1,15,15,Color.red));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
        }
        else if(n.equals("Asperta")){
            mainPanel.add(new Desenho(1,1,15,15,Color.blue));
            mainPanel.add(new JLabel(" = 3"));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
            mainPanel.add(new JLabel("    "));
        }
        this.add(mainPanel);
    }
   
 }