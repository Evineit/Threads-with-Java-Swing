package core;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author kevin
 */
public class HiloEsperaNotifica {
    JTextArea jTextArea1 = new JTextArea();
    public void setOut(JTextArea x){
        PrintStream outStream = new PrintStream(new TextAreaOutputStream(x));
        jTextArea1.setFont(new Font("Segoe UI",Font.PLAIN,18));

        System.setOut( outStream );
        System.setErr( outStream );

        Aviso avisar = new Aviso();
        HiloRun HiloEspera1 = new HiloRun("Alumno1",false,avisar);
        HiloRun HiloEspera2 = new HiloRun("Alumno2",false,avisar);
        HiloRun HiloEspera3 = new HiloRun("Alumno3",false,avisar);
        HiloRun HiloEspera4 = new HiloRun("Alumno4",false,avisar);
        HiloRun HiloEspera5 = new HiloRun("Alumno5",false,avisar);
        HiloRun HiloNotifica = new HiloRun("Maestro",true,avisar);
        HiloEspera1.start();
        HiloEspera2.start();
        HiloEspera3.start();
        HiloEspera4.start();
        HiloEspera5.start();
        HiloNotifica.start();
    }


    private static class TextAreaOutputStream extends OutputStream {
        private final javax.swing.JTextArea jTextArea1;

        /**
         * Creates a new instance of TextAreaOutputStream which writes
         * to the specified instance of javax.swing.JTextArea control.
         *
         * @param textArea   A reference to the javax.swing.JTextArea
         *                  control to which the output must be redirected to.
         */
        public TextAreaOutputStream( JTextArea textArea ) {
            this.jTextArea1 = textArea;
        }

        public void write( int b ) {
            jTextArea1.append( String.valueOf( ( char )b ) );
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }

    }
}
