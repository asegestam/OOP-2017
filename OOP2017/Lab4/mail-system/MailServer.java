import java.util.*;
/**
 * A simple model of a mail server. The server is able to receive
 * mail items for storage, and deliver them to clients on demand.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailServer
{
    // Storage for the arbitrary number of mail items to be stored
    // on the server.
    private HashMap<String,LinkedList<MailItem>> mailBox;
    /**
     * Construct a mail server.
     */
    public MailServer()
    {
        mailBox = new HashMap<String,LinkedList<MailItem>>();
        createMailbox("Postmaster");
    }

    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems(String who)
    {
        LinkedList<MailItem> mailbox = getMailbox(who);
        if(mailbox !=null){      
        return mailbox.size();
    }
    else{
        return 0;
    }
    }
    /*
     * Går igenom alla listor i hashmappen
     * för varje lista inkrementera mailCount med hur många medelanden som finns i listan
     */
    public int howManyMessages(){
        int mailCount = 0;
        for(LinkedList<MailItem> mailbox : mailBox.values()){
            mailCount += mailbox.size();
        }
        return mailCount;
    }
    
    /**
     * Return the next mail item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public MailItem getNextMailItem(String who)
    {
        LinkedList<MailItem> mailbox = getMailbox(who);
        if(!mailbox.isEmpty() && mailbox !=null){
            MailItem mail = mailbox.getLast();
            mailbox.removeFirst();
            return mail;    
        }
       
        return null;
    }
    
    /*
     * Kollar om mailet har en en avsändare och mottagare
     * Kollar om ämnnet innehåller någon version av ordet Spam
     * Kollar om meddelandet innehåller någon version av Viagra
     * Regex uttrycket är case insensetive, kan vara flera av varje karaktär
     */
    private boolean mailChecker(MailItem Item)
    {
        String[] toWho = Item.getTo();
        if(Item.getFrom().isEmpty()){
            return false;
        }
        for(String to : toWho){
            if(to.isEmpty()){
                return false;
            }
        }
        //Ta bort whitespace i stringsen så regex uttrycket kan identifiera spam orden lättare
        if(Item.getSubject().replaceAll("\\s+","").matches("(?i).*s+p+a+m.*") ||Item.getMessage().replaceAll("\\s+","").matches("(?i).*v+i+a+g+r+a.*")){
            return false;
        }				
        return true;
    }

    /**
     * Add the given mail item to the message list.
     * @param item The mail item to be stored on the server.
     */
    public void post(MailItem item)
    {
        if(mailChecker(item) == true){
            String[] toWho = item.getTo();
            for(String to : toWho){
                //Hämtar brevlåda för mottagarna
                 LinkedList<MailItem> mailbox = getMailbox(to);
                 //Om brevlåda finns, lägg till meddelandet
                  if(mailbox !=null){
                      mailbox.add(item);
                    }
                     else{
                         //Skickar meddelandet samt mottagaren som inte har en brevlåda till returnSender
                         returnToSender(item, to);
                        }
                }
            }
    }
    
    /**
    * Return a message with unknown receiver to the sender
    *
    * @param the message to be returned
    */
    private void returnToSender(MailItem message, String receiver){
     /*
      * Skapar ett nytt meddelande från postmaster till den som skickade till den ökända mottagaren
      * Kollar om mottagaren inte är postmaster
      */
     if(receiver !="Postmaster"){
         MailItem returnMail = new MailItem("Postmaster", message.getFrom(),"Unknown receiver: " + receiver, "Transcript of original message follows: \n" +
         "---------------------------------------\n" + message.toString().replace("\n","\n>"));
         post(returnMail);
        }
     
    }
    
    /**
     * Create a mailbox for a single user
     * @param the name of the new user
     * @return 1 if the creation succeeded
     * 0 if a mailbox with that name already existed
     */
    public int createMailbox(String user){
        if(mailBox.containsKey(user)){
            return 0;
        }
        else{
            mailBox.put(user, new LinkedList<MailItem>());
            return 1;
        }
    }
    
      /**
     * Create mailboxes for users
     * @param an array containing the names of the new users
     * @return the number of successfully created mailboxes,
     * this number will be less than the number of
     * specified users if some mailboxes already existed
     */
    public int createMailbox(String[] users)
    {
        int createdMailboxes = 0;
        for(String user: users){
            if(!mailBox.containsKey(user)){
                createMailbox(user);
                createdMailboxes++;
            }  
        }
        return createdMailboxes;
    
   }
    /**
     * Retrieves the mailbox for a user
     *
     * @param who the owner of the requested mailbox
     * @return the mailbox belonging to who,
     * null if it does not exist
     */
     private LinkedList<MailItem> getMailbox(String who){
         if(mailBox.get(who) == null){
             return null;
            }
         return mailBox.get(who);
     
   }
}
     
     
     
     
     
     
  