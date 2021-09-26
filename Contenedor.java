
package mover_imagen;


  

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import java.awt.Color;

public class Contenedor extends JComponent 
{
     static JPanel panel;
    
     static int columna = 3;
     
     static int fila = 0;
     
     static int numero = 1;
    
  Contenedor(JPanel panel)
  {
      this.panel = panel;
      
      setBounds(0,0,panel.getWidth() , panel.getHeight());
         
  }
    
  public void paint(Graphics g)
  {
    ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/"+numero+".png")).getImage());
       
     g.drawImage(imagen.getImage(), columna, fila, 240 ,356 , null); 
       
       }  //356
  
  static Thread hilo = new Thread()
    {
       @Override
        public void run()
        {
            try
            {
                while(true)
                {
                  if(columna<=800){
                  numero++;
                  
                  if(numero==8)
                  {
                    numero=1;
                  }
                  
                 panel.repaint();  
                 
                 columna+=10;
                 
                  hilo.sleep(100);
                  }
                  else{
                      columna=3;
                  }
                }
                
            } catch (java.lang.InterruptedException ex) {
                                                           System.out.println(ex.getMessage()); 
                                                         }
        }
    };
   
   public static void mover()
  {
     //if(!hilo.isAlive())
    //{
      hilo.start();
    //}
      //columna = 3;
    }
}










