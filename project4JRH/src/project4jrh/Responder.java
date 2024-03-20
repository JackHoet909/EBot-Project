/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project4jrh;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jack Hoeting
 */

public class Responder {
    
    /**
     *
     * @param input
     * @return
     */
   
        private HashMap<String,String> responseMap;
        private ArrayList<String> defaultResponses;
        private boolean nameAdded;



    public Responder() {
        responseMap = new HashMap<>();
        nameAdded = true;
        defaultResponses = new ArrayList<>();
        fillResponseMap();
        fillDefaultResponses();
    }
    private void fillResponseMap() {
        responseMap.put("worried", "Don't worry, be happy!");
        responseMap.put("stressed", "Take a deep breath and keep going!");
        responseMap.put("struggling", "You got this! Keep pushing forward.");
        responseMap.put("overwhelmed", "Break your tasks into smaller and manageable ones.");
        responseMap.put("doubt", "Believe in yourself, you can do it!");
        responseMap.put("failure", "Mistakes happen, it's how we learn and grow.");
        responseMap.put("discouraged", "Keep your head up, you'll get there!");
        responseMap.put("tired", "Rest if you need to, but don't give up!");
        responseMap.put("procrastinating", "Start with the smallest task, it will get you going.");
        responseMap.put("anxious", "Focus on your breath, in and out.");
    }
    private void fillDefaultResponses()
    {
        defaultResponses.add("Wow! Please let me know more about ");
        defaultResponses.add("That's interesting. Tell me more");
        defaultResponses.add("I'm listening, go on");
        defaultResponses.add("How do you feel about that?");
        defaultResponses.add("Hmm, I see. What else?");
    }
    private String chooseDefaultResponse() {
        int index = (int)(Math.random() * defaultResponses.size());
        return defaultResponses.get(index);
    }
    
    public static String removePunctuation(String input) {
    return input.replaceAll("[^a-zA-Z]", "");
    //[^a-zA-Z] covers any character that's not a letter
    // This method removes all characters from the input string that are not letters
    // Instead replaces the input string with an empty string
    }
    
    private String possiblyAddName(String response, String name){
            
    // Check if a random number is less than 0.3
    if (Math.random() < 0.3) {
        // If the response string is empty, set it to the name
        if (response.isEmpty()) {
            response = name;
        } else {
            // Toggle the nameAdded flag to alternate between prepending and appending the name
            nameAdded = !nameAdded;
            // If nameAdded is true, prepend the name to the response
            if (nameAdded) {
                response = name + ", " + response;
            } else {
                // If nameAdded is false, append the name to the response
                response += ", " + name;
            }
        }
    }
    // Return the modified or original response string
    return response;
}

    public String generateResponse(String input, String name) 
    {
       
      String response = null;
        //1st version
       if (input.contains("i like ")) {
           String[] words = input.split(" ");
           String likedThing = " ";
           for (int i = 0; i < words.length; i++)
           {
                if (words[i].equals("like") && i < words.length - 1) {
                likedThing = words[i+1];
            }
      }
      
     
        if (!likedThing.equals("")) {
        response = "Is " + likedThing + " your favorite?";
            }
        }
       //2nd version
        if (input.contains("my body needs ")) {
           String[] words = input.split(" ");
           String likedThing = " ";
           for (int i = 0; i < words.length; i++)
           {
                if (words[i].equals("needs") && i < words.length - 1) {
                likedThing = words[i+1];
            }
      }
      
      
      if (!likedThing.equals("")) {
        response = "Why do you need " + likedThing + " so badly?";
           }
      }
      //3rd version
        if (input.contains("i'll like to order ")) {
           String[] words = input.split(" ");
           String likedThing = " ";
           for (int i = 0; i < words.length; i++)
           {
                if (words[i].equals("order") && i < words.length - 1) {
                likedThing += words[i+1];
            }
      }
      
      
      if (!likedThing.equals("")) {
        response = "I'm sorry, but we're not serving" + likedThing + ", especially in this program.";
           }
      }
      //4th version
        if (input.contains("my favorite drink is ")) {
           String[] words = input.split(" ");
           String likedThing = " ";
           for (int i = 0; i < words.length; i++)
           {
                if (words[i].equals("is") && i < words.length - 1) {
                likedThing += words[i+1];
            }
      }
      
      
      if (!likedThing.equals("")) {
        response = "If I was a human, I would definitely drink" + likedThing + "!";
           }
      }
      //5th version
      if (input.contains("i love listening to ")) {
           String[] words = input.split(" ");
           String likedThing = " ";
           for (int i = 0; i < words.length; i++)
           {
                if (words[i].equals("to") && i < words.length - 1) {
                likedThing = words[i+1];
            }
      }
      
      
      if (!likedThing.equals("")) {
        response = "Ohhh you got taste! What's your favorite song by " + likedThing + "?";
           }
      }
      else
       {
        
        
        input = removePunctuation(input);
        String [] words = input.split(" ");
        ArrayList <String> matchedResponses = new ArrayList<>();
        for (String word: words) 
        {
           String value = responseMap.get(word.toLowerCase());
           if (value != null) 
           {
                matchedResponses.add(value);
           }
        }
           if (!matchedResponses.isEmpty()) 
           {
                int i = (int) (Math.random() * matchedResponses.size());
                response = matchedResponses.get(i);
           }
        if (response == null) {
            response = chooseDefaultResponse();
        }
       }
        return possiblyAddName(response, name);
    }
    
    
}
    
    

