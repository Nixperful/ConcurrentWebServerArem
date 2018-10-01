
package co.edu.escuelaing.arem.proyecto;

import co.edu.escuelaing.arem.proyecto.Mapper.MapperAdministrator;
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
     MapperAdministrator mA;

    MyWebServer(ServerSocket serverSocket,MapperAdministrator mA) {
        
        this.serverSocket=serverSocket;
        this.mA=mA;
    }
    

    @Override
    public void run() {

            try {
                System.err.println("READY:");
                this.myClientSocket=serverSocket.accept();
            }catch (IOException e) {
                System.err.println("Accept failed.");
            }
            
            
            try {
                
                
                RequestHandler rH = new RequestHandler(myClientSocket);
                DataManager dM = new DataManager();   
                dM.sendResource(rH.getRequest(),myClientSocket,mA);
                
            } catch (IOException ex) {
                Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);

        }


        
        
            

 
        
        
    }
       

}
