package gui.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopwatchPanel extends JPanel implements Runnable, ActionListener {
    JLabel tiempo;
    Thread hilo;
    boolean cronometroActivo;
    boolean pausar;

    boolean iniciado = true;
    public StopwatchPanel() {
        setSize( 500, 200 );
        setLayout( new BorderLayout() );

        tiempo = new JLabel( "00:00:000" );
        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
        tiempo.setHorizontalAlignment( JLabel.CENTER );
        tiempo.setForeground( Color.WHITE );
        tiempo.setBackground( Color.BLACK );
        tiempo.setOpaque( true );

        add( tiempo, BorderLayout.CENTER );

        JButton btn = new JButton( "Iniciar" );
        btn.addActionListener( this );
        add( btn, BorderLayout.NORTH );

        JButton btnP = new JButton( "Reiniciar" );
        btnP.addActionListener( this );
        add( btnP, BorderLayout.EAST );

        JButton btnD = new JButton( "Detener" );
        // btnD.setVisible(false);
        btnD.addActionListener( this );
        add( btnD, BorderLayout.SOUTH );
        setVisible( true );
    }
    public void actionPerformed( ActionEvent evt ) {
        Object o = evt.getSource();
        if( o instanceof JButton ) {
            JButton btn = (JButton)o;
            if( btn.getText().equals("Iniciar") ){
                iniciarCronometro();
            }
            if( btn.getText().equals("Reiniciar") ) {
                reiniciarCronometro();
            }
            if( btn.getText().equals("Detener") ) {
                pararCronometro();
            }
        }
    }
    public void run(){
        Integer minutos = 0 , segundos = 0, milesimas = 0;
        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min="", seg="", mil="";
        try {

            while( cronometroActivo ) {
                if (!pausar) {
                    Thread.sleep( 4 );
                    milesimas += 4;
                    if( milesimas == 1000 ) {
                        milesimas = 0;
                        segundos += 1;
                        if( segundos == 60 )
                        {
                            segundos = 0;
                            minutos++;
                        }
                    }

                    if( minutos < 10 ) min = "0" + minutos;
                    else min = minutos.toString();
                    if( segundos < 10 ) seg = "0" + segundos;
                    else seg = segundos.toString();

                    if( milesimas < 10 ) mil = "00" + milesimas;
                    else if( milesimas < 100 ) mil = "0" + milesimas;
                    else mil = milesimas.toString();

                    tiempo.setText( min + ":" + seg + ":" + mil );
                }
            }
            tiempo.setText( min + ":" + seg + ":" + mil );

        }catch(Exception e){System.out.println("Error al correr metodo run");}
        tiempo.setText( "00:00:000" );
    }
    public void iniciarCronometro() {
        if (iniciado) {
            hilo = new Thread( this );
            cronometroActivo = true;
            pausar = false;
            hilo.start();
            iniciado = false;
        }
    }

    public void pararCronometro(){
        pausar = true ;
        iniciado = true;
    }

    public void reiniciarCronometro(){
        cronometroActivo = false;
        iniciado = true;
        tiempo.setText( "00:00:000" );
    }
}
