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
public class Strength_Potion extends Potion {
    public Strength_Potion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description, qualidade);
        this.setQualidade(qualidade);
    }

    @Override
    public void use(Fighting_Character F) {
         F.setAtaque(F.getAtaque()*this.getQualidade()/2);
    }

    @Override
    public String getPotionType() {
        return "Strength Potion";
    }

    @Override
    public String getPrintLine() {
        return"'s strength has Increased";
    }
    
    
    
}
