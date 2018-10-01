/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.proyecto;

import co.edu.escuelaing.arem.proyecto.Mapper.MapperAdministrator;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Nicolás Osorio 
 */
public class WebServerAdministrator {
    public static Integer threads= 3;
    
    public static void main(String[] args) throws IOException {
        MapperAdministrator mA = new MapperAdministrator();
        mA.activeMappers();
        
        SocketConnection sC = new SocketConnection();        
        ServerSocket serverSocket = sC.getServerConnection();
        
        boolean isCompleted=false;
        
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        while (!isCompleted){
            executor.execute(new MyWebServer(serverSocket,mA));
        }
        
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(WebServerAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
    
    static int getPort() {
            if (System.getenv("PORT") != null) {
                return new Integer(System.getenv("PORT"));
            }
            return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 
    
    
    
}

