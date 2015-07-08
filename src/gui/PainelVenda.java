
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class PainelVenda extends JPanel{

    char desenho ='x';
   
    PainelVenda(){
        setBackground(Color.white);
        MouseListener ml = new MouseAdapter(){   
            @Override
            public void mousePressed(MouseEvent e)
            {
                desenho='m';
                repaint();  
            }
        };
        this.addMouseListener(ml);
    }
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(desenho=='m')
            setBackground(Color.BLACK);
    }
 }

