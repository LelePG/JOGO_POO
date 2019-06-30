/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.PersonagemQueLuta;

/**
 *
 * @author lele
 */
public class StrengthPotion extends Potion {

    public StrengthPotion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description, qualidade);
        this.setQualidade(qualidade);
    }

    @Override
    public void use(PersonagemQueLuta F) {
        F.setAtaque(F.getAtaque() * this.getQualidade() / 2);
    }

    @Override
    public String getPotionType() {
        return "Strength Potion";
    }

    @Override
    public String getPrintLine() {
        return "'s strength has Increased";
    }

}
