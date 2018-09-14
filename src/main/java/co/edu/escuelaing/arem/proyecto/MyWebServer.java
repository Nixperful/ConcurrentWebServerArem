
package co.edu.escuelaing.arem.proyecto;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nicolás Osorio Arias
 * @version 1.0
 */
public class MyWebServer implements Runnable{

    static SocketConnection sC;        
    static ServerSocket serverSocket;
    
    
    public static void main(String[] args) throws IOException {
        
        sC= new SocketConnection();        
        serverSocket = sC.getServerConnection();
        
        
    }

    @Override
    public void run() {
        boolean isCompleted=false;
        
        try{           
        
            while(!isCompleted){ 

                Socket clientSocket = sC.getClientConnection(serverSocket);
                RequestHandler rH = new RequestHandler(clientSocket);
                
                DataManager dM = new DataManager();
                dM.sendResource(rH.getRequest(),clientSocket);
                clientSocket.close();
            }

 
        } catch (IOException ex) {
            Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    static int getPort() {
            if (System.getenv("PORT") != null) {
                return new Integer(System.getenv("PORT"));
            }
            return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 
    

}
