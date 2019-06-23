/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import jogorpg.itens.*;
import jogorpg.monsters.Monster;

/**
 *
 * @author lele
 */
public abstract class Fighting_Character extends PersonagemComInventario{
    private int ataque;
    private int defesa;
    private float energia;
    private int max_energia;
    private int valor_maximo_atributos;
     private Attack_Weapon Attack_Weapon;
    private Defense_Weapon Shield;
    
    public Fighting_Character(int ataque, int defesa, int energia, float carregar) {
        super(carregar);
        this.ataque = ataque;
        this.defesa = defesa;
        this.energia = energia;
        this.valor_maximo_atributos = 30;
        this.Attack_Weapon = null;
        this.Shield = null;
    }
    
    public void equipmentModifiers(Monster m){
        if(this.Attack_Weapon!=null){
            m.decremento(2);
            this.energia++;
        }
        if(this.Shield!=null){
            this.energia++;
        }
    }
    
     public Weapon getAttackWeapon(){
        return this.Attack_Weapon;
    }
    
    public Weapon getDefenseWeapon(){
        return this.Shield;
    }
    
    public int getMax_energia(){
        return this.max_energia;
    } 

    public void equipAttackWeapon(Attack_Weapon w){
        this.Attack_Weapon = w;
        w.addModificador(this);
    }
   
    public Weapon unequipAttackWeapon(){
        this.Attack_Weapon.removeModificador(this);
        Weapon aux = this.Attack_Weapon;
        this.Attack_Weapon = null;
        return aux;
    }
    
    public void equipShield(Defense_Weapon w){
        this.Shield = w;
        w.addModificador(this);
    }
    
    public Weapon unequipShield(){
        Weapon aux = this.Shield;
       this.Shield.removeModificador(this);
        this.Shield = null;
        return aux;
    }
    
    
    public int getDefesa() {
        return defesa;
    }
    public float getEnergia(){
        return this.energia;
    }

    public int getAtaque() {
        return ataque;
    }
    
     public void setMax_energia(int i){
        this.max_energia = i;
    }
    
    public void setEnergia(float energia) {
        if(energia>this.max_energia){
            this.energia = max_energia;
        }
        this.energia = energia;
    }
    
     public void setAtaque(int ataque) {
        this.ataque = ataque;
        if(this.ataque>this.valor_maximo_atributos){
            this.ataque=this.valor_maximo_atributos;
        }
    }
    
    public void setDefesa(int def){
        this.defesa =def;
        if(this.defesa>this.valor_maximo_atributos){
            this.defesa = this.valor_maximo_atributos;
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
        System.out.println("# Name: "+ this.getNome());
        System.out.println("# Energy: "+ this.getEnergia());
        System.out.println("# Attack: "+this.ataque);
        System.out.println("# Defence: "+this.getDefesa());
        
     }
     public abstract void talk();
}
