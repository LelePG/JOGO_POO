/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.personagens.PersonagemQueLuta;

/**
 *
 * @author lele
 */
public abstract class BossMonster extends Monster {

    public BossMonster() {
        this.setMoedas(800);
    }

    @Override
    public String classe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack(PersonagemQueLuta P) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
