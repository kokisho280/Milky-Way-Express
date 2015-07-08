
package galaxy;

import java.util.ArrayList;


public class CartaPlanetaNonPirate extends Carta{
    
    
    private ArrayList <Integer> precoRecurso;
    public Recurso m1,m2;
    
    
    public CartaPlanetaNonPirate(boolean virada, int linha, int coluna,String nome, ArrayList<Integer> preco) {
        super(virada,linha,coluna,nome);
        this.m1= null;this.m2=null;
        this.precoRecurso= preco;
        
    }

    public Recurso getM1() {
        return m1;
    }

    public Recurso getM2() {
        return m2;
    }

    public void setM1(Recurso m1) {
        this.m1 = m1;
    }

    public void setM2(Recurso m2) {
        this.m2 = m2;
    }

    
    
    
    
    
    public int ListaPrecoPlaneta(Recurso r){
        if(r instanceof Water)
            return precoRecurso.get(0);
        else if(r instanceof Food)
            return precoRecurso.get(1);
        else if (r instanceof MedicalSupplies)
            return precoRecurso.get(2);
        else if(r instanceof Illegal)
            return precoRecurso.get(3);
        else
            return 0;
    }
    public Integer Listar(int i){
        return precoRecurso.get(i);
    }
    public Recurso vaiBuscarfood(){
        Recurso temp = null;
        
            if(m1 instanceof Food)
            {
                temp = m1;
                m1=null;
                return temp;
            }
            if(m2 instanceof Food)
            {
                temp = m2;
                m2=null;
                return temp;
            }
        
        return temp;
    }
    public Recurso vaiBuscarWater(){
        Recurso temp = null;
       
        
            if(m1 instanceof Water)
            {
                temp = m1;
                m1=null;
                return temp;
            }
            if(m2 instanceof Water)
            {
                temp = m2;
                m2=null;
                return temp;
            }
        
        return temp;
    }
    public Recurso vaiBuscarMedical(){
        Recurso temp = null;
        
            if(m1 instanceof MedicalSupplies)
            {
                temp = m1;
                m1=null;
                return temp;
            }
            if(m2 instanceof MedicalSupplies)
                {
                temp = m2;
                m2=null;
                return temp;
            }
        return temp;
    }
    

    public int vendePlaneta(Recurso r){
        int p;
        p= ListaPrecoPlaneta(r);
        if(m1!= null){
            if(!r.nome.equals(m1.nome))
                p++;
        }
        if(m2 !=null){
            if(!r.nome.equals(m2.nome))
                p++;
        }
          return p;  
    }
}
