/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.*;

/**
 *
 * @author lele
 */
public abstract class Item {
    private int peso;
    private String nome;
    private String description;
    private boolean destroy;//se o item precisa ser destruido depois do uso.
/**
 * 
 * @param nome Item's name
 * @param peso Item's weitgh
 */    
    public Item(String nome,int peso, String description){
        this.nome = nome;
        this.peso = peso;
        this.description = description;
    }
    
    //GETTERS
    public int getPeso(){
        return this.peso;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public boolean getDestroy(){
        return this.destroy;
    }
    //setter
    public void setDestroy(boolean d){
        this.destroy = d;
    }
    public abstract void use(Fighting_Character F);
    
    public String getDescription(){
        return this.getNome() +": "+this.description;
    }
}
