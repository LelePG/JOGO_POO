/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author lele
 */
public class Ilea extends Personagem {

    BufferedReader reader;

    public Ilea(String nome) {
        this.setNome(nome);
        reader = new BufferedReader(new InputStreamReader(Fairy.class.getResourceAsStream("/jogorpg/resources/Ilea_Lines.txt")));

    }

    @Override
    public void talk() {
        // String line = null;  
        try {
            String line = reader.readLine();
            while (!(line.equals("--XX--"))) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("'I just want to go home.'");
        } catch (NullPointerException n) {
            System.out.println("'We have to get out of here. Quickly!");
        }

    }

   public int sorte(int diceSides) {
        Random rand = new Random();
        return rand.nextInt(diceSides) + 1;
    }
}
