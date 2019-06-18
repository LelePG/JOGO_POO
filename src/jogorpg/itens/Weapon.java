/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Fighting_Character;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Weapon extends Item{
    private int damage;
    private int defence;
    private int durabilidade;
    
    public Weapon(String nome, int peso,String description,int damage, int defence, int durabilidade){
        super(nome, peso,description);
        this.damage = damage;
        this.defence = defence;
        this.durabilidade = durabilidade;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getDefense(){
        return this.defence;
    }
    public int getDurabilidade(){
        return this.durabilidade;
    }
    public void setDurabilidade(int d){
        int max_durab = 30;
        if(d>max_durab){
            this.durabilidade = max_durab;
            return;
        }
        this.durabilidade = d;
    }

    @Override
     public void use(Fighting_Character F){
        this.setDurabilidade(this.getDurabilidade()-1);
        if(this.getDurabilidade()<=0){
            this.setDestroy(true);
        }
    }

     public void addModificador(Fighting_Character F){
          F.setAtaque(F.getAtaque() + this.getDamage()/2);
          F.setDefesa(F.getDefesa() + this.getDefense()/2);
          System.out.println(this.getNome()+" increased "+F.getNome()+" attack and defense.");
     }
}
