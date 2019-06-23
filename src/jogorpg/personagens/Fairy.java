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
public class Fairy extends Personagem{
    private File Fairy_Lines;
    Scanner scanner;
    public Fairy(String nome) {
        this.setNome(nome);
        Fairy_Lines = new File("src/jogorpg/resources/Fairy_Lines.txt");
        scanner =null;
        try{
            scanner = new Scanner(Fairy_Lines);
            
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
           // if(!scanner.hasNext()){
           // System.out.println("I've told you all I know. Go away now.");
           // }
        }    
        }catch (NoSuchElementException e){
             System.out.println("'I've told you all I know. Go away now.'");
         }   
                
    }
}

