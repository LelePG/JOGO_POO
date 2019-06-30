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
public class PoisonPotion extends Potion {

    public PoisonPotion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description, qualidade);
    }

    @Override
    public String getPotionType() {
        return "Antidote";
    }

    @Override
    public void use(PersonagemQueLuta F) {
        if (F.isPoisoned() && this.getQualidade() >= 0) {
            F.setPoison(false);
        }
    }

    @Override
    public String getPrintLine() {
        return "was cured from poison.";
    }

}
