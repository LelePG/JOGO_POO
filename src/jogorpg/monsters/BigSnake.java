/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.monsters;


import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class BigSnake extends Monster{
 
   
    public BigSnake(String nome){
        this.setNome(nome);
        this.setAtaque(8);
        this.setDefesa(6);
        this.setMax_energia(17);
        this.setEnergia(17);
    }
    
    @Override
    public void attack(Personagem P){
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
        return "BIG SNAKE";
    }
   
    
    
   
    
}


