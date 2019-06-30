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
public class HealPotion extends Potion {

    public HealPotion(String nome, int peso, String description, int qualidade) {
        super(nome, peso, description, qualidade);
        this.setQualidade(qualidade);
    }

    @Override
    public String getPotionType() {
        return "Healing Potion";
    }

    @Override
    public void use(PersonagemQueLuta F) {
        F.setEnergia(F.getEnergia() + 3 * this.getQualidade());
    }

    @Override
    public String getPrintLine() {
        return this.getNome() + " restored some energy.";
    }

}
