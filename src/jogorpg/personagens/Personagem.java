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
    private int ataque;
    private int defesa;
    private float energia;
    private float l_peso;
    private int max_energia;
    private boolean alive;
    private boolean poison;

    public Personagem(int ataque, int defesa, int energia, float carregar) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = energia;
        this.l_peso = carregar;
        this.alive = true; 
        this.poison = false;
    }

    
    //GETTERS
    public String getNome(){
        return this.nome;
    }
    public int getMax_energia(){
        return this.max_energia;
    } 

    public int getDefesa() {
        return defesa;
    }

    public float getL_Peso(){
        return this.l_peso;
    }
    
    public float getEnergia(){
        return this.energia;
    }

    public int getAtaque() {
        return ataque;
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

    public void setMax_energia(int i){
        this.max_energia = i;
    }
    
    public void setEnergia(float energia) {
        this.energia = energia;
    }
    
    public void setPoison(boolean p){
        poison = p;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
        if(this.ataque>10){
            this.ataque=10;
        }
    }
    
    public void setDefesa(int def){
        this.defesa =def;
        if(this.defesa>10){
            this.defesa = 10;
        }
    }
    
    public void died(){
        this.alive = false;
    }
   
    public void decremento(float n){
        if(this.getEnergia()>0 && this.getEnergia()<=this.getMax_energia()){
            this.energia-=n;
        if(this.getEnergia()<=0){
             this.died();
            }
        }
    }
        
      public void imprimirStatus(){
        System.out.println("# Name: "+ this.getNome());
        System.out.println("# Energy: "+ this.getEnergia());
        System.out.println("# Attack: "+this.ataque);
        System.out.println("# Defence: "+this.getDefesa());
        
    
     }
      

      
}
