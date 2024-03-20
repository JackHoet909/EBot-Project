/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project4jrh;
import java.util.Scanner;

/**
 *
 * @author Jack Hoeting
 */
public class EBot {
    private Responder resp;
    private Scanner scan;
    
   
    
    public EBot()
    {
        resp = new Responder();
        scan = new Scanner(System.in);
    }
    
    private void printWelcome()
    {
        System.out.println("Welcome user to EncourageBot!");
        System.out.println("Type your comment at the > prompt.");
        System.out.println("Type the word 'quit' to end the session."); 
    }
    
    private void printGoodbye()
    {
        System.out.println("Great job today! Keep up the good work!");
        System.out.println("Goodbye, chief! Remember to stay positive and keep moving forward!");
    }
    
    private String getEndingString()
    {
        return "quit";
    }
    public void start()
    {
        printWelcome();
        System.out.println("Tell me your name: ");
        String name = scan.nextLine();
        boolean keepGoing = true;
        while (keepGoing)
        {
            
            System.out.print("> ");
            String input = scan.nextLine();
            if (input.equals(getEndingString()))
            {
                keepGoing = false;
            }
            else
            {
                String response = resp.generateResponse(input, name);
                System.out.println(response);
            }
        }
        printGoodbye();
    }
}
