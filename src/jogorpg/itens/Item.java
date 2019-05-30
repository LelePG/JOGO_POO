/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public abstract class Item {
    private int peso;
    private int damage;
    private int defesa;
    private String nome;

    
    public Item(String nome,int p, int da, int def){
        this.nome = nome;
        this.peso = p;
        this.damage = da;
        this.defesa = def;
    }
    
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
    
    public abstract void UseItem();
    public abstract void FixItem(Personagem p);
    
}
