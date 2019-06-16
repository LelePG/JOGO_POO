/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.HashMap;
import jogorpg.itens.Item;
import jogorpg.monsters.Monster;


/**
 *
 * @author lele
 */
public class Hero extends Personagem{
    private HashMap<String,Item> inventario;
    
    public Hero( int ataque, int defesa, int energia,float carregar) {
        super( ataque, defesa, energia,carregar);
        this.setMax_energia(35);
        inventario = new HashMap<String,Item>();
    }
    
    
    public void pickItem(Item i){
        if(i.getPeso()+this.pesoInventario()>this.getL_Peso()){
            System.out.println("You can't carry this. It's too heavy for you.");
            return;
        }
        else{
            inventario.put(i.getNome(),i);
           // modificadores de ataque e defesa
            this.setAtaque(this.getAtaque() + i.getDamage()/3);
            this.setDefesa(this.getDefesa() + i.getDefesa()/3);
            System.out.println(i.getNome()+" increased "+this.getNome()+" attack and defense.");
        }
    }
    
    public Item removerItem(String nome){
        Item aux;
        if(inventario.containsKey(nome)){
            aux = inventario.get(nome);
            inventario.remove(nome);
            this.setAtaque(this.getAtaque() - aux.getDamage()/3);//o que ele ganha quando pega o item, tem que diminuir quando deixa o item
            this.setDefesa(this.getDefesa() - aux.getDefesa()/3);
            System.out.println("Dropping "+aux.getNome()+" decreased "+this.getNome()+" attack and defense.");
            return aux;
        }
        else{
           // System.out.println("You do not have this item.");
            return null;
        }
        
    }
    
    public String getInventarioString(){
        String ret = "Inventory: ";
        if(inventario.isEmpty()){
            return "Your iventory is empty. ";
        }
        for(String key: inventario.keySet()){
            ret+=" "+key;
        }
        return ret;
    }
    
    public int pesoInventario(){//for each que retorna o peso total do inventario
        int peso = 0;
        for(String keys: inventario.keySet()){
            peso += inventario.get(keys).getPeso();
        }
        return peso;
    }

    public void lutar(Monster M){
        M.attack(this);//A MECÂNICA DE ATAQUE PROPRIAMENTE TÁ RELACIONADA AO MONSTRO, E NÃO AO PERSONAGEM
        System.out.println("#################");
        System.out.println(this.getNome()+ " VS " + M.getNome());
        System.out.println("HERO STATUS:");
        this.imprimirStatus();
        if(!this.isAlive()){//Os decrementos de Monstro e de Personagem já matam eles quando for preciso
           System.out.println(this.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       if(!M.isAlive()){//caso o monstro tenha morrido, não imprime os status dele
           System.out.println(M.getNome()+" WAS KILLED");
           System.out.println("#################");
           return;
       }
       System.out.println("MONSTER STATUS:");
       M.imprimirStatus();
       System.out.println("#################");
      }  
    
}
