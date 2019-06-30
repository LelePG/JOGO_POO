/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lele
 */
public class Musician extends Personagem {

    BufferedReader reader;

    public Musician(String nome) {
        this.setNome(nome);
        reader = new BufferedReader(new InputStreamReader(Fairy.class.getResourceAsStream("/jogorpg/resources/Musician_Lines.txt")));

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
            System.out.println("'You should not stay here kid. Your sister may not have much time left.'");
        } catch (NullPointerException n) {
            System.out.println("'I wish you good luck. I'll write a song about you if I ever get out of here'");
        }

    }
}
