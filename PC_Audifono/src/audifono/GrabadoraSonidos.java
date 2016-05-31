/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audifono;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author REGO
 */
public class GrabadoraSonidos extends Thread {

//línea usada para leer los datos de audio
    private TargetDataLine linea;

//tipo de formato de audio que usaremos para codificar
    private AudioFileFormat.Type tipoFormatoAudio = AudioFileFormat.Type.WAVE;

//flujo del cual leeremos los datos:
    private AudioInputStream flujoEntrada;

    public GrabadoraSonidos() {

//indicamos el formato de audio que usaremos    
        AudioFormat formatoAudio = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, //técnica de codificado
                44100.0F, //frecuencia de muestreo
                16, //nº de bits por canal
                2, //nº de canales
                4, //nº de bytes en cada parte(frame)
                44100.0F, // nº de partes por segundo
                false); //orden en q se guardan los datos de audio(big-ending-true)
//creamos una instancia de TargetDataLine para indicar que línea aceptamos.
        DataLine.Info infoLineaAcepta = new DataLine.Info(
                TargetDataLine.class, formatoAudio);

        try {
//Pedimos a AudioSystem que nos devuelva una linea que coincida con la línea que aceptamos.
            linea = (TargetDataLine) AudioSystem.getLine(infoLineaAcepta);
//Abrimos la línea con el formato de Audio, recordamos que es un thread.
            linea.open(formatoAudio);          
        } catch (LineUnavailableException oExcep) {
            Logger.getLogger(GrabadoraSonidos.class.getName()).log(Level.SEVERE, null, oExcep);
            Logger.getLogger(GrabadoraSonidos.class.getName()).log(Level.SEVERE, null, oExcep);
        }
//creamos el flujo
        flujoEntrada= new AudioInputStream(linea);
            
    }
    
    /**
     * empezar a leer sobre la línea e invoca run
     * 
     */
    public void empezarGrabacion(){
        linea.start();
        start();
    }
    /**
     * pararmos de grabar sobre la línea
     */
    public void pararGrabacion(){
        linea.stop();
        linea.close();
    }
    
    
    /**
     * Provisional: Pedimos que escriba un flujo de audio desde el flujo de entrada de audio 
     */
    public void run(){
        try{
            OutputStream out;
            out = new ByteOutputStream();
            AudioSystem.write(flujoEntrada, tipoFormatoAudio, out);
        }catch(Exception e){
            
        }
    }
}
