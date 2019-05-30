/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public abstract class Monster {
    private String nome;
    private int ataque;
    private int defesa;
    private float energia;
    private int max_energia;
    private boolean alive;
    
    public Monster(){
        this.alive = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getMax_energia() {
        return max_energia;
    }

    public void setMax_energia(int max_energia) {
        this.max_energia = max_energia;
    }
    public boolean isAlive(){
        return this.alive;
    }
   
    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
        if(this.energia>max_energia){
            this.energia =max_energia;
        }
    }

    public int sorte(int m){
        int k;
        k= (int) (1+Math.random()*(m-1));
        return k;
    }
    public float getEnergia(){
        return this.energia;
    }
    
    public void incremento(){
        if(this.getEnergia()<max_energia && this.getEnergia()>0){
            this.energia+=(1+Math.random()*(4-1));
        }
        if(this.energia>max_energia){
            this.energia =max_energia;
        }
    }
    
    public void decremento(float n){
        if(this.getEnergia()>0 && this.getEnergia()<=max_energia ){
            this.energia= this.energia - n;
        }
    }
        
      public void imprimirStatus(){
        System.out.println("# Nome: "+this.getNome()+" ("+this.classe()+")");
        System.out.println("# Energia: "+ this.getEnergia());
        System.out.println("# Ataque: "+this.ataque);
        System.out.println("# Defesa: "+this.getDefesa());
    
     }
      public void died(){
          this.alive = false;
      }
      
      public abstract void attack(Personagem P);
      public abstract String classe();
      public abstract void follow(Personagem P);
}
