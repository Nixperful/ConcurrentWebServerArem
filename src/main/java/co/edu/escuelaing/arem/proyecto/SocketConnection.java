
package co.edu.escuelaing.arem.proyecto;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Nicolás Osorio Arias 
 */
class SocketConnection {

    public SocketConnection() {
    }
    
    
    /**
    * @return sSocket Socket del servidor.
    */    
    public ServerSocket getServerConnection(){
        
        ServerSocket sSocket = null;
        try {
            sSocket = new ServerSocket(getPort());
        } catch (IOException e) {

            System.err.println("Could not listen on port");
            System.exit(1);
        }
        return sSocket;
    }
    
    /**
    *
    * @param serverSocket el cliente se conectará a este servidor. 
    * @return clientSocket Socket del cliente
    */
    public Socket getClientConnection(ServerSocket serverSocket) {

        Socket clientSocket = null;
        
        try {

            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();

        } catch (IOException e) {
            System.err.println("Accept failed.");

            System.exit(1);
        }
        
        
        return clientSocket;
        
    }
    
    static int getPort() {
            if (System.getenv("PORT") != null) {
                return new Integer(System.getenv("PORT"));
            }
            return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }       
}
