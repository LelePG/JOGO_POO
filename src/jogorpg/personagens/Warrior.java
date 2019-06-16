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
    
    public Warrior( int ataque, int defesa, int energia,float carregar) {
        super( ataque, defesa, energia,carregar);
        this.setNome("Winslow");
    }
    
}
