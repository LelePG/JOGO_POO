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
public class Sword extends Item{

    public Sword(String nome, int p, int da, int def) {
        super(nome, p, da, def);
    }
    
    //METHOD FOR SHAPENING THE SWORD
    public void amolar(){
        this.setDamage(this.getDamage()+1);
    }
    
}
