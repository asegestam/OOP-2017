
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MailServerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MailServerTest
{
    
    private MailServer mailServer;
    private MailItem messEmptyFrom;
    private MailItem messEmptyTo;
    private MailItem mess1User1to2;
    private MailItem mess2User1to2;
    private MailItem messTwoReceivers;
    private MailItem messUnknownReceiver;
    private MailItem messSpamSubj;
    private MailItem messSpamBody;

    
    /**
     * Default constructor for test class MailServerTest
     */
    public MailServerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        mailServer = new MailServer();
        mailServer.createMailbox("user1");
        mailServer.createMailbox("user2");
        mailServer.createMailbox("user3");
        
        messEmptyFrom = new MailItem("", "foo", "", "");
        messEmptyTo = new MailItem("foo", "", "", "");
        
        mess1User1to2 = new MailItem("user1", "user2", "1", "");
        mess2User1to2 = new MailItem("user1", "user2", "2", "");
        
        messTwoReceivers = new MailItem("user1", "user2,user3", "", "");
        messUnknownReceiver = new MailItem("user1", "unknown", "foo", "bar");
        messSpamSubj = new MailItem("user1", "user2", "xxxSpAmyyy", "");
        messSpamBody = new MailItem("user1", "user2", "", "xxxvI a Gr AA yyy");   
    }
    @Test
    public void testEmptyFrom(){
        mailServer.post(messEmptyFrom);
        assertEquals(0, mailServer.howManyMessages());
    }
     @Test
    public void testEmptyTo(){
        mailServer.post(messEmptyTo);
        assertEquals(0, mailServer.howManyMessages());     
    }
    @Test
    /*
     * Skickar message 1 till user2
     * kalllar på getNextMailItem för user2s mailbox
     * och tar bort det mailet dvs returnerar metoden null vilket vi testar för
     */
    public void testMessageRemoval(){

        mailServer.post(mess1User1to2);
        mailServer.getNextMailItem("user2");
        assertNull(mailServer.getNextMailItem("user2"));

    }
    @Test
    /*
     * Skapar en array med 100 test användare
     * testar om det finns 100 användare efter createMailbox kallas
     */
    public void testCreateMailboxes(){
        String users[] = new String[100];
        for(int i = 0; i < 100; i++){
            users[i] = "testUser" + i;
        }
        assertEquals(100, mailServer.createMailbox(users));
        
    }
    @Test
    public void testReceiveOrder()
    {
        mailServer.post(mess1User1to2);
        mailServer.post(mess2User1to2);
        assertEquals("2", mailServer.getNextMailItem("user2").getSubject());
    }
    @Test 
    /*
     * Postar ett mail från user1 till user2 och user3
     * testar om dett finns ett mail i deras brevlådor
     */
    public void testTwoReceivers(){
        mailServer.post(messTwoReceivers);
        assertEquals(1, mailServer.howManyMailItems("user2"));
        assertEquals(1, mailServer.howManyMailItems("user3"));
        
    }
    @Test
    /*
     * Postar ett mail från user1 till en okänd mottagare
     * Testar om det finns ett mail i user1 brevlåda och att detta mail är från postmaster
     */
    public void testReturnToSender(){
        mailServer.post(messUnknownReceiver);
        assertEquals(1, mailServer.howManyMailItems("user1"));
        assertEquals("Postmaster", mailServer.getNextMailItem("user1").getFrom());
    }
    @Test
    public void testSpamInSubject(){
        mailServer.post(mess1User1to2);
        mailServer.post(messSpamSubj);
        assertEquals(1, mailServer.howManyMessages());
    }
    @Test
    public void testSpamInBody(){
        mailServer.post(mess1User1to2);
        mailServer.post(messSpamBody);
        assertEquals(1, mailServer.howManyMessages());
        
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
