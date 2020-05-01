/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author kevin
 */
public class Aviso {
    boolean bandera=false;
    
    public synchronized void saludoNotifica(String nombre_hilo) {
        bandera=true;
        System.out.println("A trabajar: "+nombre_hilo);
        notifyAll();
    }

    public synchronized void saludoEspera(String nombre_hilo) {
        try{
            if (!bandera)
                wait();
            System.out.println("Trabajando: "+nombre_hilo);
        }catch(InterruptedException ex){
            System.out.println("Algo anda mal");
        }
    }
    
}
