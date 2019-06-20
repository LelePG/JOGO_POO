/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogorpg.personagens;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author lele
 */
public class Robber extends Personagem{
private File robber_lines;
    Scanner scanner;
    
    public Robber(String nome) {
        this.setNome(nome);
        robber_lines = new File("Robber_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(robber_lines);
            
        }catch(FileNotFoundException e){
             System.out.println("Cannot talk to "+this.getNome());

        }
    }

     @Override
    public void talk(){
        try{
        String line = scanner.nextLine();
        
        while(scanner.hasNext() && !line.equals("--XX--")){
            System.out.println(line);
            line = scanner.nextLine();
            if(!scanner.hasNext()){
            System.out.println("You are lucky I'm caged. Otherwise...");
            }
        }    
        }catch (NoSuchElementException e){
             System.out.println("GO AWAY, KID!");
         }   
                
    }
}
