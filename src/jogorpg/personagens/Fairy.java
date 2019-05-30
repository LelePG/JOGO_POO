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
public class Fairy extends Personagem{
    
    public Fairy(int força, int ataque, int defesa, int energia,float carregar) {
        super(força, ataque, defesa, energia,carregar);
        this.setNome("Iadala");
    }
    
}
