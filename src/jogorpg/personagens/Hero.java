/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.HashMap;
import jogorpg.itens.Item;
import jogorpg.monsters.Monster;
import jogorpg.personagens.Personagem;

/**
 *
 * @author lele
 */
public class Hero extends Personagem{
    private HashMap<String,Item> inventario;
    
    public Hero(int força, int ataque, int defesa, int energia,float carregar) {
        super(força, ataque, defesa, energia,carregar);
        this.setNome("Ethan");
        this.setMax_energia(30);
        inventario = new HashMap<String,Item>();
    }
    
    public void pickItem(Item i){
        if(i.getPeso()+this.pesoInventario()>this.getL_Peso()){
            System.out.println("You can't carry this. It's too heavy for you");
            return;
        }
        else{
            inventario.put(i.getNome(),i);
           // modificadores de ataque e defesa
            this.setAtaque(this.getAtaque() + i.getDamage());
            this.setDefesa(this.getDefesa() + i.getDefesa());
        }
    }
    
    public Item removerItem(String nome){
        Item aux;
        if(inventario.containsKey(nome)){
            aux = inventario.get(nome);
            inventario.remove(nome);
            return aux;
        }
        else{
            System.out.println("You do not have this item");
            return null;
        }
        
        
    }
    
    public int pesoInventario(){//for each que retorna o peso total
        int peso = 0;
        for(String keys: inventario.keySet()){
            peso += inventario.get(keys).getPeso();
        }
        return peso;
    }

    public void lutar(Monster P2){
       P2.attack(this);
        System.out.println("#################");
        System.out.println(this.getNome()+ " VS " + P2.getNome());
        System.out.println("HERO STATUS:");
       this.imprimirStatus();
       if(this.getEnergia()<=0){//primeiro testar o her'oi
           this.died();
           System.out.println(this.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       
       if(P2.getEnergia()<=0){
           P2.died();
           System.out.println(P2.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
        System.out.println("MONSTER STATUS:");
       P2.imprimirStatus();
       System.out.println("#################");
      }
    
      
    
}
