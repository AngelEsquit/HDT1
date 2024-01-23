package src;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * La clase Radio implementa la interfaz IRadio y proporciona diversas funciones
 * básicas para operar una radio, tales como: encender/apagar, cambiar la frecuencia,
 * guardar emisoras favoritas, entre otros.
 */

/**
 * Represents a radio object that implements the IRadio interface.
 * The radio has the ability to toggle power on/off, switch between AM and FM frequencies,
 * change to the next or previous frequency, save and retrieve favorite frequencies.
 */
public class Radio implements IRadio{
    Scanner scanner = new Scanner(System.in);
    /**
     * Mapa que almacena las frecuencias favoritas.
     */

    public Map<Integer, Float> favFrequency = new HashMap<>();
    /**
     * Estado de la radio (encendida o apagada).
     */
    public boolean state = false;
    /**
     * Tipo de frecuencia actual (AM o FM).
     */
    public boolean amfm = false;
    /**
     * Frecuencia actual de la radio.
     */
    public float frequency = 88.0f;
    
    /**
     * Obtiene el estado actual de la radio.
     *
     * @return Verdadero si la radio está encendida, falso si está apagada.
     */
    public boolean getState(){
        if (state == true) {
            return true;
        } else {
            return false;
        }
    } 

    /**
     * Enciende o apaga la radio.
     */
    public void tooglePowerOffOn(){
        System.out.println("Encender/apagar la radio");
        System.out.println("1. Encender");
        System.out.println("2. Apagar");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                if (state == true) {
                    System.out.println("La radio ya estaba encendida");
                }
                state = true;
                break;
            case 2:
                if (state == false) {
                    System.out.println("La radio ya estaba apagada");
                }
                state = false;
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        
    } 

    /**
     * Cambia entre las frecuencias AM y FM.
     */
    public void toogleAMFM(){
        System.out.println("AM/FM");
        System.out.println("1. AM");
        System.out.println("2. FM");
        int option = scanner.nextInt();
        if (getState() == false) {
            System.out.println("ERROR Radio apagada, enciéndela");
        }
        if (getState() == true) {
            switch (option) {
                case 1:
                    System.out.println("AM");
                    if (amfm == true) {
                        System.out.println("La frecuencia ya era AM");
                    }
                    amfm = true;
                    break;
                case 2:
                    if (amfm == false) {
                        System.out.println("La frecuencia ya era FM");
                    }
                    System.out.println("FM");
                    amfm = false;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
        }
    }
    } 

    /**
     * Obtiene el tipo de frecuencia actual (AM o FM).
     *
     * @return Verdadero si está en FM, falso si está en AM.
     */
    public boolean getStateAMFM(){
        if (amfm == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Cambia a la siguiente frecuencia.
     */
    public void nextFrequency() {
        if (state) {
            BigDecimal frequencyBigDecimal = BigDecimal.valueOf(frequency);
            BigDecimal increment = amfm ? BigDecimal.valueOf(0.2) : BigDecimal.valueOf(0.2);
            frequencyBigDecimal = frequencyBigDecimal.add(increment);
    
            if (frequencyBigDecimal.floatValue() > 108.0f) {
                frequencyBigDecimal = BigDecimal.valueOf(88.0f);
            }
    
            frequency = frequencyBigDecimal.setScale(1, RoundingMode.HALF_UP).floatValue();
    
            System.out.println("Frecuencia siguiente: " + frequency);
        } else {
            System.out.println("ERROR Radio apagada, enciéndela");
        }
    }
    
    /**
     * Cambia a la frecuencia anterior.
     */
    public void previousFrequency() {
        if (state) {
            BigDecimal frequencyBigDecimal = BigDecimal.valueOf(frequency);
            BigDecimal decrement = amfm ? BigDecimal.valueOf(0.2) : BigDecimal.valueOf(0.2);
            frequencyBigDecimal = frequencyBigDecimal.subtract(decrement);
    
            if (frequencyBigDecimal.floatValue() < 88.0f) {
                frequencyBigDecimal = BigDecimal.valueOf(108.0f);
            }
    
            frequency = frequencyBigDecimal.setScale(1, RoundingMode.HALF_UP).floatValue();
    
            System.out.println("Frecuencia anterior: " + frequency);
        } else {
            System.out.println("ERROR Radio apagada, enciéndela");
        }
    }

    /**
     * Obtiene la frecuencia actual de la radio.
     *
     * @return La frecuencia actual.
     */
    public float getCurrentFrequency() {
        return frequency;
    }


    /**
     * Guarda la frecuencia actual en el botón especificado.
     *
     * @param button Número del botón en el cual se guardará la emisora.
     */
    public void setFavFrequency(int button) {
        if (state) {
            float currentFrequency = getCurrentFrequency();
            favFrequency.put(button, currentFrequency);
            System.out.println("Frecuencia guardada en el botón " + button);
        } else {
            System.out.println("ERROR Radio apagada, enciéndela");
        }
    } 


    /**
     * Obtiene la frecuencia guardada en el botón especificado.
     *
     * @param button Número del botón del cual se obtendrá la emisora guardada.
     * @return La frecuencia guardada en el botón especificado.
     */

    public float getFavFrequency(int button) {
        return favFrequency.getOrDefault(button, 0.0f);
    } 

}