/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.ArrayList;
import jogorpg.itens.Item;

/**
 *
 * @author lele
 */
public abstract class Personagem {
    private String nome;
    private int força;
    private int ataque;
    private int defesa;
    private float energia;
    private float l_peso;
    private int max_energia;
    private boolean alive;

    public Personagem(int força, int ataque, int defesa, int energia, float carregar) {
        this.força = força;
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = energia;
        this.l_peso = carregar;
        this.alive = true;        
    }

    public String getNome(){
    return this.nome;
    }
    
    public void setNome(String n){
        this.nome = n;
    }

    public int getForça() {
        return força;
    }
    public void setMax_energia(int i){
        this.max_energia = i;
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

    public void setEnergia(float energia) {
        this.energia = energia;
    }
    
    public float getEnergia(){
        return this.energia;
    }

    public int getAtaque() {
        return ataque;
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
    public boolean isAlive(){
        return this.alive;
    }
    
    public int sorte(int m){
        int k;
        k= (int) (1+Math.random()*(m-1));
        return k;
    }
    
    
    public void incremento(){
        if(this.getEnergia()<this.getMax_energia() && this.getEnergia()>0){
            this.energia+=(1+Math.random()*(4-1));
        }
        if(this.energia>this.getMax_energia()){
            this.energia =20;
        }
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
        System.out.println("# Nome: "+ this.getNome());
        System.out.println("# Energia: "+ this.getEnergia());
        System.out.println("# Ataque: "+this.ataque);
        System.out.println("# Defesa: "+this.getDefesa());
        
    
     }
      

      
}
