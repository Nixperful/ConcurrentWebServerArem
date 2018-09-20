
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
        try {
            RequestHandler rH = new RequestHandler(myClientSocket);
            DataManager dM = new DataManager();
            dM.sendResource(rH.getRequest(),myClientSocket);
            myClientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);
        }
            

 
        
        
    }
       

}
