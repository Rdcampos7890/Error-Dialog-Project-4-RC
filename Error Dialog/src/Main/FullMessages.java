package Main;

import javax.swing.*;
import java.util.ArrayList;

/*
 * FullMessages class, responsible for storing all messages in their complete states (id + description)
 * and of storing all possible default descriptions and IDs. 
 */
public class FullMessages {

    public static ArrayList<Messages> FullMessages = new ArrayList<Messages>();

    /*
     * Automatically generates some predetermined messages.
     */
    public static void generateFullMessages() {
        FullMessages.add(new Messages("Client 1", "System Down"));
        FullMessages.add(new Messages("Server", "Code Error"));
        FullMessages.add(new Messages("Hard Drive", "No Signal"));
        FullMessages.add(new Messages("Memory", "Ful Capacity"));
        FullMessages.add(new Messages("Disk 1", "Incorrect Input"));
        FullMessages.add(new Messages("Disk 2", "Server Occupied"));
        FullMessages.add(new Messages("Client 2", "Input Not Received"));
        FullMessages.add(new Messages("Interface", "Corrupted Information"));
        FullMessages.add(new Messages("Mother Board", "Reboot Failure"));
        FullMessages.add(new Messages("Processor", "Overheating"));
    }

    /*
     * Adds a message by taking from the default parts of a message.
     */
    public static void addMessage() {
        String id = JOptionPane.showInputDialog("Input Id: ");
        String description = JOptionPane.showInputDialog("Input Description: ");
        if(id == null || description == null || description.length() == 0 || id.length() == 0) {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }
        else {
            FullMessages.add(new Messages(id, description));
        }
    }

    /*
     * Adds a random description for one of the parts from which the error messages are coming.
     */
    public static void addRandomDes() {
        String choice = JOptionPane.showInputDialog("Want to generate random description for random id (type random404) or for chosen id (type id)");
        if(choice == null || choice.length() == 0) {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }
        else if(choice.equalsIgnoreCase("random404")){
            addRandomDes2();
        }
        else if(choice.equalsIgnoreCase("id")) {
            addRandomDes3();
        }
        else {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }

    }

    /*
     * Adds a description for a random part from the list of parts.
     */
    private static void addRandomDes2() {
        FullMessages.add(new Messages(Messages.ids.get((int)(Math.random() * Messages.ids.size())), Messages.descriptions.get((int)(Math.random() * Messages.descriptions.size()))));
    }

    /*
     * Adds a random description to a specified part/id.
     */
    private static void addRandomDes3() {
        String id = JOptionPane.showInputDialog("Enter ID: ");
        FullMessages.add(new Messages(id, Messages.descriptions.get((int)(Math.random() * Messages.descriptions.size()))));
    }

    /*
     * Removes a message depending on the input from the  user in the form of a keyword or a specified id.
     */
    public static void remove() {
        String choice = JOptionPane.showInputDialog("Want to remove by keyword (type keyword) or by id (type id)");
        if(choice == null || choice.length() == 0) {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }
        else if(choice.equalsIgnoreCase("id")){
            String id = JOptionPane.showInputDialog(null, "What Id do you want to erase (all messages of this id will be erased)");
            if(id == null || id.length() == 0) {
                JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
            }
            else {
                remove1(id);
            }
        }
        else if(choice.equalsIgnoreCase("keyword")){
            String keyword = JOptionPane.showInputDialog(null, "What keyword do you want to erase (all messages containing this keyword (in ID or DESCRIPTION) will be erased)");
            if(keyword == null || keyword.length() == 0) {
                JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
            }
            else {
                remove2(keyword);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }
    }

    /*
     * Removes all information related to a given id.
     */
    private static void remove1(String id) {
        for(int i = 0; i < FullMessages.size(); i++) {
            if(FullMessages.get(i).getId().equalsIgnoreCase(id)) {
                FullMessages.remove(FullMessages.get(i));
                i--;
            }
        }
    }

    /*
     * Removes all information related to a keyword, may it be on the id or on the description.
     */
    private static void remove2(String keyword) {
        for(int i = 0; i < FullMessages.size(); i++) {
            if((" " + FullMessages.get(i).getMessage() + " ").contains(" " + keyword + " ")) {
                FullMessages.remove(FullMessages.get(i));
                i--;
            }
        }
    }

    /*
     * Searches all messages for that may contain a keyword or that are related to an specified id.
     */
    public static void search() {
        String choice = JOptionPane.showInputDialog("Want to search by keyword (type keyword) or by id (type id)");
        if(choice == null || choice.length() == 0) {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }
        else if(choice.equalsIgnoreCase("id")){
            String id = JOptionPane.showInputDialog(null, "What Id do you want to search");
            if(id == null || id.length() == 0) {
                JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
            }
            else {
                search1(id);
            }
        }
        else if(choice.equalsIgnoreCase("keyword")){
            String keyword = JOptionPane.showInputDialog(null, "What keyword do you want to search");
            if(keyword == null || keyword.length() == 0) {
                JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
            }
            else {
                search2(keyword);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Information Inputted Was Incorrect, Please Try Again");
        }
    }

    /*
     * Searches and prints all messages related to the specified id.
     */
    private static void search1(String id) {
        String messages = "";
        for(Messages msg: FullMessages) {
            if(msg.getId().equalsIgnoreCase(id)) {
                messages += msg.getMessage() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, ("All Messages Found With ID " + id + "\n" + messages));

    }

    /*
     * Searches and prints all messages containing the keyword.
     */
    private static void search2(String keyword) {
        String messages = "";
        for(Messages msg: FullMessages) {
            if((" " + msg.getMessage() + " ").contains(keyword)) {
                messages += msg.getMessage() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, ("All Messages Found With keyword " + keyword + "\n" + messages));
    }

    /*
     * Shows how many error messages does each id have.
     */
    public static void showCount() {
        String s = "";
        int cnt = 0;
        for(String word: Messages.ids) {
            for(Messages msg: FullMessages) {
                if(msg.getId().equalsIgnoreCase(word)) {
                    cnt++;
                }
            }
            s += word + ": " + cnt + "\n";
            cnt = 0;
        }
        JOptionPane.showMessageDialog(null, s);
    }

    /*
     * Shows all messages stored up to now.
     */
    public static void showMessages() {
        String s = "";
        for(Messages msg: FullMessages) {
            s += msg.getMessage() + "\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }

}

