/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Fighting_Character;

/**
 *
 * @author lele
 */
public class Attack_Weapon extends Weapon{
    
    public Attack_Weapon(String nome, int peso, String description, int damage, int defence, int durabilidade) {
        super(nome, peso, description, damage, defence, durabilidade);
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
          F.setDefesa(F.getDefesa() + this.getDefense()/3);
     }
     
     
    public void removeModificador(Fighting_Character F){
        F.setAtaque(F.getAtaque() - this.getDamage()/2);
        F.setDefesa(F.getDefesa()- this.getDefense()/3);
    }

    @Override
    public String getPrintLine() {
        return "attacked using "+this.getNome();
    }
}
