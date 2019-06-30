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
public class Fairy extends Personagem {

    BufferedReader reader;

    public Fairy(String nome) {
        this.setNome(nome);
        reader = new BufferedReader(new InputStreamReader(Fairy.class.getResourceAsStream("/jogorpg/resources/Fairy_Lines.txt")));

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
            System.out.println("'I refuse to talk to you.'");
        } catch (NullPointerException n) {
            System.out.println("'I've told you all I know. Go away now.'");
        }

    }
}
