package httpsurlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

//import javax.net.ssl.HttpsURLConnection;
/**
 *
 * @author Poozer
 */
public class HttpsURLConnection {

    private static Scanner in;
    
    public static void main(String[] args) throws IOException{
        in = new Scanner(System.in);
        //I decided probably the simpliest thing was to get the HTTP from LDS.org
        String urlLink = "https://www.churchofjesuschrist.org/?lang=eng";
        //Constructs a URL connection to the specified URL. A connection to the 
        //object referenced by the URL is not created.
        URL url = new URL(urlLink);
        //Obtain a new HttpURLConnection by calling URL#openConnection() and 
        //casting the result to HttpURLConnection.
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        
        //Reads the response. Response headers generlly include metadata such as
        //the response body's content type and length, modified dates and 
        //session cookies. The response body may be read from the stream 
        //returned by URLConnection.getInputStream().
        BufferedReader in2;
        in2 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        
        while((line = in2.readLine()) !=null){
            sb.append(line);
        }
        //don't forget to close it!
        in.close();
        System.out.println(sb.toString());
    }

}
