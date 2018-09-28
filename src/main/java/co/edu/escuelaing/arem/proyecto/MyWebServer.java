
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
    static Socket myClientSocket;

    MyWebServer(Socket clientConnection) {
        this.myClientSocket=clientConnection;
    }
    

    @Override
    public void run() {
        
       
        RequestHandler rH = new RequestHandler(myClientSocket);
        DataManager dM = new DataManager();
        try {
            dM.sendResource(rH.getRequest(),myClientSocket);
        } catch (IOException ex) {
            try {
            myClientSocket.close();

            } catch (IOException ex1) {
                Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        
            

 
        
        
    }
       

}
