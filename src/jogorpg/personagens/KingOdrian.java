/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lele
 */
public class KingOdrian extends Personagem {

    public KingOdrian(String nome) {
        this.setNome(nome);
    }

    public void delay(int n) {
        try {
            TimeUnit.SECONDS.sleep((long) n);//só pra garantir que vai printar o comando primeiro e depois a ação correspondente.
        } catch (InterruptedException ex) {
            //não altera nada se não conseguir
        }
    }

    @Override
    public void talk() {
        System.out.println("\n'Ilea, my dear. you want to leave me?\n What a pity. You have a talent, I can see it.\n"
                + "Oh, little one... You don't know how sad it makes me. But if you want to leave me, you may.'");

        delay(7);

        System.out.println("\n'But only if you win me in a game. Don't be so foolish kid.\n"
                + "Although you got here, you have no strengh to figth me. I could tear you both so pieces with a flick of my wrist.\n"
                + "But I rather not. I liked your little sister, and I'm really sad she prefers to leave with you then accept what I could give her.\n"
                + "A special girl like her, traines for a master like me could do wonders in just no time.\n"
                + "It will be hard to find another one suitible for being my apprentice, but guess I'll have to keep trying...\n'");

        delay(8);
        System.out.println("\n'Oh, of course. The game. It's a pretty simple one, actually. A dice roll.\n"
                + "I'll roll one dice, and as I'm a good man I'll give both of you a dice too.\n"
                + "All you have to do is guess which is the sum of all our dices.\n"
                + "I promise I'll not use my magic in anyway to interfear. Just the good old fair play.\n"
                + "I'll give you 5 guesses. If you get it rigth, you win and I let you go."
                + "If you don't, both of you have to stay. Ilea will be my apprentice and you..."
                + "\nI'm sure I'll find a job for you. What do you say? I could just kill you if you refuse, be aware while you think.'");
        delay(8);
    }

    public boolean diceGame(Hero h, Ilea i) {
        Scanner s = new Scanner(System.in);
        int dadoH = h.sorte(6);
        int dadoI = i.sorte(6);
        int dadoO = this.sorte(12);
        int sum = dadoH + dadoI + dadoO;
        int guess;
        System.out.println("You rolled  " + dadoH + " and Ilea rolled " + dadoI + ".");
        System.out.println(sum);
        for (int c = 0; c < 5; c++) {
            System.out.println("Guess a number: ");
            try {
                guess = Integer.parseInt(s.next());
            } catch (NumberFormatException e) {
                System.out.println("This is not a number.");
                return false;
            }

            if (sum == guess) {
                System.out.println("'The sum is " + Integer.toString(sum) + ". You won.'");
                return true;
            }
        }
        System.out.println("'The sum is " + Integer.toString(sum) + ". You lost.");
        if (sum > 18) {
            System.out.print("Guess I did not mention I'd use a twelve sided dice.'");
            return false;
        }
        return false;
    }

    public int sorte(int diceSides) {
        Random rand = new Random();
        return rand.nextInt(diceSides) + 1;
    }
            
}
