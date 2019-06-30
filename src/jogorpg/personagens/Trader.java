/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.util.Scanner;
import jogorpg.itens.*;
/**
 *
 * @author lele
 */
public class Trader extends PersonagemComInventario{
    private PersonagemComInventario cliente;
    public Trader(float l_peso, PersonagemComInventario TradingWith) {
        super(l_peso);
        this.pickItem(new Food("Apple_Pie",2,10,"a apple pie."));
        this.pickItem(new Poison_Potion("Special_Antidote",1,"a bottle with 'drink if you are poisoned, idiot' witten with big letters",5));
        this.pickItem(new Heal_Potion("Healer's_tea",2,"a bottle with a colorful liquid inside",5));
        this.pickItem(new Strength_Potion("Scorpion's_Juice",2,"a bottle with a dark liquid. It's impossible to know what will happen if you drink it",5));
       this.pickItem(new Defense_Weapon("Metal_Shield",10," a metal Shield.",4,23,35));
       this.cliente = TradingWith;
       this.setNome("Trader");
    }
  
    @Override
    public void talk() {
        Scanner s = new Scanner(System.in);
        String aux;
        Item iaux;
        if(this.inventarioVazio()){
            System.out.println("'Oh, I sold everything I had. What a good day.'");
            return;
        }
        System.out.println("'Hello! I'm a trader, would you like to buy something? y/n '");
        aux = s.nextLine();
        if(aux.equals("y")  || aux.equals("Y")) {
            System.out.println("'Good!' Here's all I have.");
            this.displayInventory();
            System.out.println("'What would you like?'");
            aux = s.nextLine();
            try{
                cliente.pickItem(this.removerItem(aux));//lidar com isso
            }
            catch (NullPointerException n){
                System.out.println("'I don't have what you want'");
            }
        }
        else if(aux.equals("n")  || aux.equals("N")){
            System.out.println("'Okay then.'");
        }
        else{
            System.out.println("'I don't know what you mean.");
        }
        
    }
    
}
