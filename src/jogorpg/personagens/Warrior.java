/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Warrior extends Personagem{
    
    public Warrior( float carregar) {
        super( carregar);
        this.setNome("Winslow");
    }

    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
