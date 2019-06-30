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
public class Trader extends PersonagemComInventario {

    public PersonagemComInventario cliente;

    public Trader(float l_peso, PersonagemComInventario TradingWith) {
        super(l_peso);
        this.cliente = TradingWith;
        if (this.cliente == null) {
            System.out.println("não pegou o cliente");
        }
        this.pickItem(new Food("a", 2, 10, "a apple pie."));
        this.pickItem(new PoisonPotion("Special_Antidote", 1, "a bottle with 'drink if you are poisoned, idiot' witten with big letters", 5));
        this.pickItem(new HealPotion("Healer's_tea", 2, "a bottle with a colorful liquid inside", 5));
        this.pickItem(new StrengthPotion("Scorpion's_Juice", 2, "a bottle with a dark liquid. It's impossible to know what will happen if you drink it", 5));
        this.pickItem(new DefenseWeapon("Metal_Shield", 10, " a metal Shield.", 4, 23, 35));
        this.setNome("Trader");
    }

    @Override
    public void talk() {
        Scanner s = new Scanner(System.in);
        String aux;
        Item iaux;
        if (this.inventarioVazio()) {
            System.out.println("'Oh, I sold everything I had. What a good day.'");
            return;
        }
        System.out.println("'Hello! I'm a trader, would you like to buy something? y/n '");
        aux = s.nextLine();
        switch (aux) {
            case "y":
            case "Y":
                //se eu quiser trade
                System.out.println("'Good!' Here's all I have.\n");
                this.displayInventory();
                System.out.println("'What would you like?'");
                aux = s.nextLine();//pega o nome do item que eu quero
                iaux = this.removerItem(aux);//tira do inventario do trader
                if (iaux == null) {//se ele não tiver
                    System.out.println("'I don't have what you want'");
                } else if (cliente.pickItem(iaux)) {//se eu conseguir pegar
                    System.out.println("'Here it goes!'");
                } else {//se eu não conseguir pegar, o item volta pro inventario dele
                    System.out.println("'You are not strong enough to carry this.'");
                    this.pickItem(iaux);
                }   
                break;
            case "n":
            case "N":
                System.out.println("'Okay then.'");
                break;
            default:
                System.out.println("'I don't know what you mean.");
                break;
        }

    }

}
