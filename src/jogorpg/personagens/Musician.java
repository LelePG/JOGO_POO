/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

/**
 *
 * @author lele
 */
public class Musician extends Personagem{
    
    public Musician(float carregar) {
        super(carregar);
        this.setNome("Mark");
    }

    @Override
    public void talk() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
