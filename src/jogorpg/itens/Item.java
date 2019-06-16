/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

/**
 *
 * @author lele
 */
public abstract class Item {
    private int peso;
    private int damage;
    private int defesa;
    private String nome;

/**
 * 
 * @param nome Item's name
 * @param p Item's weitgh
 * @param da Item's damage
 * @param def Item's defence
 */    
    public Item(String nome,int p, int da, int def){
        this.nome = nome;
        this.peso = p;
        this.damage = da;
        this.defesa = def;
    }
    
    //GETTERS
    public int getPeso(){
        return this.peso;
    }
    
    public int getDamage(){
        return this.damage;
    }
    
    public int getDefesa(){
        return this.defesa;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    
    //SETTERS
    public void setDamage(int i){
        this.damage = i;
    }
    
    public void setDefesa(int i){
        this.defesa = i;
    }
}
