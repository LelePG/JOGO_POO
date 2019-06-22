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
public class Seer extends Personagem{
private File seer_lines;
    Scanner scanner;
    
    public Seer(String nome) {
        this.setNome(nome);
        seer_lines = new File("Seer_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(seer_lines);
            
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
            //if(!scanner.hasNext()){
           // System.out.println("I cannot say anything else to you.");
            //}
        }    
        }catch (NoSuchElementException e){
             System.out.println("I've told you all I can. Good luck.");
         }   
                
    }
    
}
