package jogorpg.world_of_zuul;

import jogorpg.itens.Item;
import jogorpg.itens.Sword;
import jogorpg.monsters.Bat;
import jogorpg.monsters.BigScorpion;
import jogorpg.monsters.BigSnake;
import jogorpg.monsters.Monster;
import jogorpg.monsters.Rat;
import jogorpg.monsters.Scorpion;
import jogorpg.monsters.Snakes;
import jogorpg.monsters.Spider;
import jogorpg.personagens.Hero;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Hero h;
    private Monster s;
    private boolean finished;
    private Item i;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        finished = false;
        h = new Hero(7,8,8,30,5);
        s = new Rat("snake");
        i = new Sword("Espada",3,3,3);
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room corridor1, jail, library, corridor2, storage,alchemy_lab,nest, gate;
        // create the rooms
        corridor1 = new Room("in a long stone corridor. There are noises somewhere.");
        jail = new Room("in some kind of jail. There are some people caged. They seem to be sleeping.");
        library = new Room("in a dusty old library. There are old books everywhere. ");
        corridor2 = new Room("in a stone corridor. The walls are wet, there must be water nearby.");
        storage = new Room("in a weird storage room. There are all kinds of things around.");
        alchemy_lab = new Room("in an alchemy lab. There are some books on the shelves and lots of bottles with colouful liquids inside.");
        nest = new Room("in a monster nest. You better be careful here.");
        gate = new Room("in a big iron gate. There's none around.");
        
        // initialise room exits
        corridor1.setExit("east", jail);
        corridor1.setMonstro("snake",s);
        //corridor1.setItem("Espada", i);
        
        jail.setExit("west", corridor1);
        jail.setExit("east", library);
        
        library.setExit("west",jail);
        library.setExit("north",storage);
        library.setExit("south", alchemy_lab);
        library.setExit("east",corridor2);
        
        storage.setExit("south",library);
        
        alchemy_lab.setExit("north",library);
        
        corridor2.setExit("west",library);
        corridor2.setExit("south", gate);
        corridor2.setExit("east",nest);
        
        gate.setExit("north", corridor2);
        
        nest.setExit("west",corridor2);

        currentRoom = corridor1;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if(commandWord ==CommandWord.ATTACK){
            if(s.isAlive() && h.isAlive()){
                h.lutar(s);
            }
            if(!h.isAlive()){
                System.out.println("\n######################");
                System.out.println("######GAME OVER#######");
                System.out.println("######################");
                System.exit(0);
            }
            else if(!s.isAlive()){//como faço pra finalizar isso aqui
                currentRoom.mataMonstro(s.getNome());
                System.out.println(currentRoom.getLongDescription());
            }
            
        }
        else if(commandWord == CommandWord.DROP){
            
        }
        else if(commandWord == CommandWord.PICK){
            
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
