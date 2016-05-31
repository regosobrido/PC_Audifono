/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audifono;

/**
 *
 * @author REGO
 */
public class PC_Audifono {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* 1. Crear ventanas: 
            analizador señal-tiempo y analizador espectral.
           2. Inicializamos el micrófono:
        package javax.sound.sampled
        Para ellos desde la clase GrabadoraSonidos obtendremos el flujoEntrada
        La clase principal es AudioSystem:
            AuidoSystem- punto de entrada para los recursos de sistema de
        audio muestreado. Permite leer datos desde el dispositivo de entrada,
        y escribir los datos de audio en un formato específico hacia un fichero 
        de salida
        
            DataLine, un line define la alimentación de sonido mono 
        o multicanal, DataLine extiende Line para añadir funciones como empezar,
        parar, drenar, y vaciar los datos de audio que pasan por Line
            DataLine.Info proporciona información sobre los datos que pasan a
        a través de DataLine, como el formato de audio que soporta DataLine,
        o los tamáños mínimos y máximos que soporta del su buffer interno.
            
            Crearemos una instancia de DataLine.Info para especificar que tipo de 
        Line queremos y para preguntar después al AudioSystem que encuentre una 
        línea para nosotros
            interfaz AudioInputStream con un fomato de audio específico y 
        longitud, que indica las operaciones qque usaremos dentro de AudioSystem
           
            3. Creamos un objeto AudioSystem(Dispositivo de entrada) 
               y le pasamos el DataLine
            Creamos un AudioInputStream para poder leer el audio
            package javax.sound.sampled
           
           4. Creamos un reproductor de sonidos
        
           5. Creamos opcionalmente un analizador espectral
        
           6. Creamos el bucle de procesamiento del flujo de sonido
            6.1 A cada paso: 
                Leemos el sonido
                Mostrar el resultado en las ventanas espectral y de tiempo_señal
                
           7. Liberamos recursos
        */

        
    }
    
}
