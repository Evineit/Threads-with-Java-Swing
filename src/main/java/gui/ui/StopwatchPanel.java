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
    JPanel bot;
    Button btnIniciar;
    Button btnReiniciar;
    boolean iniciado = true;
    public StopwatchPanel() {
        setSize( 500, 200 );
        setLayout( new BorderLayout());
        bot = new JPanel();
        bot.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        bot.setBackground(Color.black);
        bot.setLayout(new BoxLayout(bot,BoxLayout.X_AXIS));
        tiempo = new JLabel( "00:00:000" );
        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
        tiempo.setHorizontalAlignment( JLabel.CENTER );
        tiempo.setForeground( Color.WHITE );
        tiempo.setBackground( Color.BLACK );
        tiempo.setOpaque( true );

        add( tiempo, BorderLayout.CENTER );

        btnIniciar = new Button( "Iniciar" );
//        btn.setBorderPainted(false);
        btnIniciar.addActionListener( this );

        btnReiniciar = new Button("Reiniciar");
        btnReiniciar.addActionListener(this);

        // btnD.setVisible(false);
        add(bot, BorderLayout.SOUTH);

        bot.add(btnIniciar);
        bot.add(Box.createHorizontalStrut(10));
        bot.add(btnReiniciar);
        btnReiniciar.setVisible(false);
//        bot.add(btnP);
////        bot.add(Box.createHorizontalStrut(10));
////        bot.add(btnD);
//        bot.add(Box.createHorizontalStrut(10));

        setVisible( true );
    }
    public void run(){
        Integer minutos = 0 , segundos = 0, milesimas = 0;
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
                else {
                    Thread.sleep(400);
                }
            }
            tiempo.setText( min + ":" + seg + ":" + mil );

        }catch(Exception e){System.out.println("Error al correr metodo run");}
//        tiempo.setText( "00:00:000" );
    }
    public void actionPerformed( ActionEvent evt ) {
        Object o = evt.getSource();
        if( o instanceof Button ) {
            Button btn = (Button)o;
            if( btn.getText().equals("Iniciar") ){
                iniciarCronometro();
                btn.setText("Pausar");
                btnReiniciar.setVisible(true);
                return;
            }
            if( btn.getText().equals("Reiniciar") ) {
                reiniciarCronometro();
                btnIniciar.setText("Iniciar");
                btnReiniciar.setVisible(false);

            }
            if (btn.getText().equals("Pausar")) {
                pausarCronometro();
                btn.setText("Reanudar");
                return;
            }
            if (btn.getText().equals("Reanudar")){
                iniciarCronometro();
                btn.setText("Pausar");
            }
        }
    }
    public void iniciarCronometro() {
        if (iniciado) {
            hilo = new Thread(this);
            cronometroActivo = true;
            pausar = false;
            hilo.start();
            iniciado = false;
        } else {
            pausar=false;
        }
    }
    private void pausarCronometro() {
        pausar=true;

    }

    public void reiniciarCronometro() {
        cronometroActivo = false;
        iniciado = true;
        SwingUtilities.invokeLater(() -> {
            try {
                hilo.join();
//                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tiempo.setText("00:00:000");
        });
    }
}
