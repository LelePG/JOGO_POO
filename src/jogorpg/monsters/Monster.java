/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.itens.*;
import jogorpg.personagens.*;

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
    private Coins moedas;
    
    public Monster(){//Basically, a monster is just alive
        this.alive = true;
        moedas = new Coins("Coins",1,"golden coins",0);
    }

    //GETTERS
    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getMax_energia() {
        return max_energia;
    }
    
     public boolean isAlive(){
        return this.alive;
    }
   
    public int getDefesa() {
        return defesa;
    }
   
    public float getEnergia(){
        return this.energia;
    }
    
    public int getMoedas(){
        return moedas.getCoinNumber();
    }
    
    
    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setMax_energia(int max_energia) {
        this.max_energia = max_energia;
    }
   
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setEnergia(int energia) {//ENERGY CANNOT BE BIGGER THEN MAX_EXERGY
        this.energia = energia;
        if(this.energia>max_energia){
            this.energia =max_energia;
        }
    }
    public void died(){//TO BE USED WHEN A MONSTER IS KILLED
          this.alive = false;
    }
    
    public void setMoedas(int i){
        moedas.setCoinNumber(i);
    }

    public Item dropCoins(){
        return this.moedas;
    }
    
    public void decremento(float n){
        if(this.getEnergia()>0 && this.getEnergia()<=max_energia ){
            this.energia= this.energia - n;
        }
        if(this.getEnergia()<=0){
                this.died();
            }
    }
        
      public void imprimirStatus(){
        System.out.println("# Name: "+this.getNome()+" ("+this.classe()+")");
        System.out.println("# Energy: "+ this.getEnergia());
        System.out.println("# Attack: "+this.ataque);
        System.out.println("# Defence: "+this.getDefesa());
    
     }

      public abstract void attack(Fighting_Character P);//MECÂNICA DE ATAQUE DO MONSTRO
      public abstract String classe();//RETURN ITS CLASS

}
