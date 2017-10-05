import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    private Membership membership;
    // Define any necessary fields here ...
    private LinkedList<Membership> membersList;
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        membersList = new LinkedList<Membership>();
      
        
    }


    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     * @return true if member was added, false ow.
     */
    public boolean join(Membership member) {
        if( member == null ){
            return false;
        }
        Iterator<Membership> iterator = membersList.iterator();
        //While det finns ett nästa element
        while(iterator.hasNext()){
        //Om en email adress som finns i listan är lika med den som ska läggas till
            if(iterator.next().getEmail().equals(member.getEmail())){
                return false; 
            }   
        }
        //Lägg till member
        membersList.add(member);
        return true;
    }
     /**
     * Return the number of members in this club.
     * @return The number of stored Membership objects.
     */
    public int numberOfMembers()
    {
        return membersList.size();
    }
    
    public void printAllMembers(){
        for(Membership member : membersList){
            System.out.println(member);
        }
    }
    /**
    * Return how many members joined in the given month.
    * @param month The month we are interested in.
    * @param year The year of the Membership.
    * @return How many members joined in the given month.
    */
    public int joinedInMonth(int month,int year)
    {
        int nrOfMembers = 0;
        if(month < 1 || month > 12) {
            System.out.println("Error: Month must be between 1 and 12");
             return 0;
            }
     
     for( Membership member : membersList ){
         //Om månad och år för parameterna är lika med för en member, inc nrOfMembers
         if(month == member.getMonth() && year == member.getYear()){
             nrOfMembers++;
            }
        }
        return nrOfMembers;
    }
    /**
    * Search for a member with a given email address.
    * @param email the email address of the searched member.
    * @return A matching membership object if found,
    * null otherwise.
    */
    public Membership findMember(String email) {
        //För varje member om parameter email är lika med en member som redan finns, returnera member
        for( Membership member : membersList ){
         if(email.equals(member.getEmail())){
             return member;
            
            }   
    }
    return null;
    }
   /**
   * Return the email addresses of all the club members.
   * @return A comma separated string of email addresses.
   */
   public String getEmailAdresses() {
       StringBuilder sb = new StringBuilder(256); // startkapacitet 256
       Iterator<Membership> iterator = membersList.iterator();
       while(iterator.hasNext()){
           //Iterera i listan och lägg till varje email i Sb
           sb.append(iterator.next().getEmail());
           //Om det finns ett nästa element lägg till ","
           if(iterator.hasNext()){
               sb.append( ", "); 
            }
    }
    String s = sb.toString();
    return s;
   }
    /**
    * Delete a member from the club.
    * @param email The email address of the member to be deleted.
    * @return true if the specified membership was deleted, false ow.
    */
    public boolean delete(String email){
        if( email == null ){
            return false;
        }
        Iterator<Membership> iterator = membersList.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getEmail().equals(email)){
                iterator.remove();
                return true;
            }
        }
        return false;
}
/**
 * Remove from the club's collection all members who joined
 * in the given month, and return them stored in a separate
 * collection object.
 * @param month The month of the Membership.
 * @param year The year of the Membership.
 */
 public ArrayList<Membership> purge(int month,int year){
     ArrayList<Membership> deletedMembers = new ArrayList();
     Iterator<Membership> iterator = membersList.iterator();
     if(month < 1 || month > 12) {
            System.out.println("Error: Month must be between 1 and 12");
             return null;
            }

      while(iterator.hasNext()){
          Membership member = iterator.next();
          //Om det finns members med samma month och year, spara dom i en array och ta bort från listan
          if(member.getMonth() == month && member.getYear() == year){
              deletedMembers.add(member);
              iterator.remove();
              
        }
       }
    return deletedMembers;
}
 /**
 * Print membership info about all members in this club
 * who also joined the other club.
 * @param other The other club.
 */
 public void intersect(Club other) {
     if(other != null){
         for( Membership member : membersList) {
            if(other.findMember(member.getEmail()) != null){
                System.out.println(member);
            }
        }
     }
     }
 /**
 * Move members of the other club to this club.
 * Only members who are not already in this club will be moved.
 * On return, the other club will be empty.
 * @param other The club whose members will be added.
 * @return the number of members added.
 */
 public int transferAll(Club other){
     if(other != null && other == this){
          System.out.println("Error");
          return 0;
        }  
     int membersMoved = 0; 
     /*
      * För varje member i den valda klubben
      * om join lyckas dvs om den inte finns i den andra klubben
      * låt den membern gå med i den klubben
      * cleara klubben du flyttade från
      */
     for( Membership member : other.membersList ){
            if(this.join(member)){
                membersMoved++;
            }
        }
        
        other.membersList.clear();
        return membersMoved;
    }
 
}
