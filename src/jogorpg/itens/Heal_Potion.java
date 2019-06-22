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
public class Heal_Potion extends Potion {
    public Heal_Potion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description, qualidade);
        this.setQualidade(qualidade);
    }

     @Override
    public String getPotionType() {
        return "Healing Potion";
    }

    @Override
    public void use(Fighting_Character F) {
       F.setEnergia(F.getEnergia()+4*this.getQualidade());
    }

    @Override
    public String getPrintLine() {
       return this.getNome()+" restored some energy.";
    }
    

    
    
    
}
