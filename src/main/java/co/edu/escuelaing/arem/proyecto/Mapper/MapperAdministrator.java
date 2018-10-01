/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.proyecto.Mapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2110432
 */
public class MapperAdministrator {
        Map<String, Object> map; 

    
    public MapperAdministrator() {
        map = new HashMap<String, Object>();
    }

    public void activeMappers(){
        try {
            Class c = Class.forName("co.edu.escuelaing.arem.proyecto.Mapper.Components.MyExampleApp");
            for (Method m : c.getMethods()) {
                Constructor cons = c.getConstructor();
                if (m.isAnnotationPresent(Mapeo.class)) {
                    try {
                        Mapeo anot = m.getAnnotation(Mapeo.class);
                        System.out.println(anot.value());
                        Object o = cons.newInstance();
                        Object a = m.invoke(o);
                        map.put(anot.value(),a);
                        String resp = a.toString();
                        System.out.println("La respuesta es: " + resp);

                    } catch (Throwable ex) {
                        System.out.printf("error on %s: %s %n", m, ex.getCause());
                        
                    }
                }
            }
            System.out.println("Finished");
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(MapperAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object getAction(String key){
        return map.get("/"+key);
        
    }
    
    
}
