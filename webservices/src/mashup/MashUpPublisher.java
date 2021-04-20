package mashup;
import javax.xml.ws.Endpoint;

/**
 * publisher for the mashup service
 * @author lamlu
 *
 */
public class MashUpPublisher
{
    /**
     * Main.
     * @param args the server port number
     */
    public static void main(String args[]) 
    {
        MashUp mashup = new MashUpImpl();
        String url = String.format("http://localhost:%s/ts", args[0]);
        
        System.out.printf("Publishing service %s to %s ...\n", 
                          mashup.getClass().getName(), url);
        
        // 1st argument is the publication URL
        // 2nd argument is an SIB instance
        Endpoint.publish(url, mashup);
    }

}
