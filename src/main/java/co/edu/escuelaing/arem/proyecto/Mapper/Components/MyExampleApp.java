/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arem.proyecto.Mapper.Components;

import co.edu.escuelaing.arem.proyecto.Mapper.Component;
import co.edu.escuelaing.arem.proyecto.Mapper.Mapeo;

@Component
public class MyExampleApp {
    
    @Mapeo("/index")
    public Double resultado(){
        return Math.PI;
    }
    
    @Mapeo("/holamundo")
    public String hola(){
        return "Hola";
    }
    
}
