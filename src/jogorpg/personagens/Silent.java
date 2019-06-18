/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;
import jogorpg.monsters.Monster;

/**
 *
 * @author lele
 */
public class Silent extends Personagem{
    
    public Silent( float carregar) {
        super(carregar);
        this.setNome("Odrian");
    }

    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
