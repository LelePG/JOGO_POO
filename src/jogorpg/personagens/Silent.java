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
    
    public Silent( int ataque, int defesa, int energia,float carregar) {
        super( ataque, defesa, energia,carregar);
        this.setNome("Odrian");
    }
    
    public void killMonster(Monster M){
        M.setEnergia(-30);
        this.setEnergia(this.getEnergia()-13);
        if(this.getEnergia()<=0){
            System.out.println("Odrian's dead");
        }
    }
}
