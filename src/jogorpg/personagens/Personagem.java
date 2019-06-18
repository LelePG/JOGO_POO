/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;


/**
 *
 * @author lele
 */
public abstract class Personagem {
    private String nome;
    private float l_peso;
    private boolean alive;
    private boolean poison;

    public Personagem(float carregar) {
        this.l_peso = carregar;
        this.alive = true; 
        this.poison = false;
    }

    
    //GETTERS
    public String getNome(){
        return this.nome;
    }
    

    public float getL_Peso(){
        return this.l_peso;
    }
    
    
    public boolean isPoisoned(){
        return this.poison;
    }
    
    public boolean isAlive(){
        return this.alive;
    }
    //SETTERS
    
    public void setNome(String n){
        this.nome = n;
    }

    
    public void setPoison(boolean p){
        poison = p;
    }
    
    public void died(){
        this.alive = false;
    }
      
   public abstract void talk();

      
}
