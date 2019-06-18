/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;

import jogorpg.itens.*;
import jogorpg.personagens.*;

/**
 *
 * @author lele
 */
public class BossSpider extends BossMonster{
    private String nome;
    private boolean poison;
    private Item i;
    public BossSpider(String nome){
        this.setNome(nome);
        this.setAtaque(12);
        this.setDefesa(12);
        this.setMax_energia(20);
        this.setEnergia(20);
        this.poison = true;
        i = new Key("Iron Key",3,"The key used to open the Iron Gate");
    }
    
    @Override
    public void attack(Fighting_Character P) {
        if(P.getDefesa()>this.getAtaque()){
            P.decremento(this.getAtaque()/2);
            this.decremento(P.getDefesa()- this.getAtaque());
        }
        else if(P.getDefesa()<=this.getAtaque()){
            P.decremento(3);
            this.decremento(2);
        }
    }
    @Override
    public String classe(){
        return "BOSS SPIDER";
    }
    
    
    
    
}
