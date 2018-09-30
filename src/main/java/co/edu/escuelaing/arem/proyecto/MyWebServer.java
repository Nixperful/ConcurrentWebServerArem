
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

  
     Socket myClientSocket;
     ServerSocket serverSocket;
   

    MyWebServer(ServerSocket serverSocket) {
    
        this.serverSocket=serverSocket;
    }
    

    @Override
    public void run() {

            try {
                System.err.println("Accept.");
                this.myClientSocket=serverSocket.accept();
            }catch (IOException e) {
                System.err.println("Accept failed.");
            }
            
            
            try {
                
                
                RequestHandler rH = new RequestHandler(myClientSocket);
                DataManager dM = new DataManager();
                
                dM.sendResource(rH.getRequest(),myClientSocket);
                
            } catch (IOException ex) {
                Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);

        }


        
        
            

 
        
        
    }
       

}
