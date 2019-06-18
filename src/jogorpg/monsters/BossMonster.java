/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.itens.Item;
import jogorpg.personagens.Fighting_Character;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class BossMonster extends Monster {
    private Item i;
    public BossMonster(){
        this.setMoedas(800);
    }
    @Override
    public String classe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attack(Fighting_Character P) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
