package Main;

import java.util.ArrayList;

/*
 * Messages  class, responsible for creating messages and giving them their properties (id and description).
 */
public class Messages {

    public static ArrayList<String> descriptions = new ArrayList<String>();
    public static ArrayList<String> ids = new ArrayList<String>();
    private String id;
    private String description;
    private String fullMsg;

    /*
     * Initializes the variables of that make up a  message, description and id, with the given parameters.
     */
    public Messages(String id, String description) {
        this.id = id;
        if(search(id, ids)) {
            ids.add(id);
        }
        this.description = description;
        if(search(description, descriptions)) {
            descriptions.add(description);
        }
        fullMsg = id + ": " + description;
    }

    /*
     * Searches all the words in the given  lsit to make sure that the new word is not repeated.
     */
    private boolean search(String word, ArrayList<String> list) {
        for(String s: list) {
            if(s.equals(word)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Returns current description of the message.
     */
    public String getDes() {
        return description;
    }

    /*
     * Returns current id of the message.
     */
    public String getId() {
        return id;
    }

    /*
     * Returns the full message in the correct format.
     */
    public String getMessage() {
        return fullMsg;
    }

    /*
     * Sets the id of the message to the specified  id of the parameter.
     */
    public void setId(String id) {
        this.id = id;
    }

    /*
     * Sets the description of the message to the description of the parameter.
     */
    public void setDes(String description) {
        this.description = description;
    }

    /*
     * Sets the description and id of the message to the description and id given in the parameter.
     */
    public void setMsg(String id, String description) {
        this.id = id;
        this.description = description;
        fullMsg = id + ": " + description;
    }


}