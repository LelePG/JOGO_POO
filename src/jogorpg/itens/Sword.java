/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.itens;

import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Sword extends Item{

    public Sword(String nome, int p, int da, int def) {
        super(nome, p, da, def);
    }
    
    
    
    

    @Override
    public void UseItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void FixItem(Personagem p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
