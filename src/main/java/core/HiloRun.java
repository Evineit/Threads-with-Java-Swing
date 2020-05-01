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
public class HiloRun extends Thread {
    String nombre_hilo;
    Aviso avisar;
    boolean bandera;
    public HiloRun(String nombre_hilo, boolean bandera, Aviso avisar){
        this.nombre_hilo=nombre_hilo;
        this.avisar=avisar;
        this.bandera=bandera;
    }
    public void run(){
        System.out.println("Llego "+nombre_hilo);
        try{
            Thread.sleep(500);
            if(bandera)
                avisar.saludoNotifica(nombre_hilo);
            else
                avisar.saludoEspera(nombre_hilo);
        }catch(InterruptedException ex){
            System.out.println("Algo anda mal");
        }
    }
    
}
