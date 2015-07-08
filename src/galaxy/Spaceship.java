/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galaxy;

import java.util.ArrayList;

/**
 *
 * @author Utilizador
 */
public class Spaceship {
    private int forca;
     int capacidade;
     ArrayList <Recurso> carga = new ArrayList<>();
     
     public Spaceship(){
        forca = 3;
        capacidade = 2;
     }
     
    @Override
    public String toString(){
    String aux="";
        for (Recurso carga1 : carga) {
            aux += carga1.getNome() + " ";
        }
    return aux;
}
    public int getCapacidade() {
        return capacidade;
    }

    public ArrayList<Recurso> getCarga() {
        return carga;
    }
     
     public int getForca(){return forca;}
     public int totalIllegal(){
         int i = 0,j=0;
         for (i = 0;i< carga.size();i++)
             if(carga.get(i) instanceof Illegal)
                 j++;
         return j;
     }
     public boolean temFoodparaVender(){
         for(int i = 0;i < carga.size();i++)
             if(carga.get(i) instanceof Food)
                 return true;
         return false;
     }
      public boolean temMedicalparaVender(){
         for(int i = 0;i < carga.size();i++)
             if(carga.get(i) instanceof MedicalSupplies)
                 return true;
         return false;
     }
     public boolean temWaterparaVender(){
         for(int i = 0;i < carga.size();i++)
             if(carga.get(i) instanceof Water)
                 return true;
         return false;
     }
     public Recurso retiraCubodaNave(String r){
         Recurso temp = null;
         for(int i = 0;i < carga.size();i++)
             if(carga.get(i).nome.equals(r)){
                 temp = carga.get(i);
                 carga.remove(i);
                 break;
             }
         return temp;
         
     }
     public void removeIllegal(){
         for(int i = 0;i < carga.size();i++)
             if(carga.get(i) instanceof Illegal)
                 carga.remove(i);
     }
     public int aumentaForca(){
         if(forca == 3 ){
              forca = 4;
              return 4;
         }  
         else if(forca == 4){
             forca = 5;
             return 5;
         }
         else
             return 0;
     }
     
     public int aumentaCarga(){
         if(capacidade < 3){
             capacidade = 3;
             return 3;
         }
         else
             return 0;
     }
     public boolean temEspaco(){
         if(carga.size() < capacidade)
             return true;
         return false;
     }
     public void colocaRecursoNave(Recurso r){
         if(carga.size() < capacidade)
             carga.add(r);
     }
     public void retiraRecursoNave(int idx){
                 carga.remove(idx);
     }
     
}
