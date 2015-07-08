/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Utilizador
 */
public class Desenho extends JPanel {
    int cx, cy, comp, larg;
    Color cor;
    
    //Construtor, inicializa as variáveis de instância
    public Desenho(int cx, int cy, int comp, int larg, Color cor)
    {
        this.cx = cx; this.cy = cy; this.comp = comp;
        this.larg = larg; this.cor = cor;
    }
    
    //Cria o desenho. É chamado sempre que a janela fica visível
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(cor);
        g.fillRect(cx,cy,comp,larg);
        //this.revalidate();this.repaint();
    }
}