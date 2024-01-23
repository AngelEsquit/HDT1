package src;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Radio implements IRadio{
    Scanner scanner = new Scanner(System.in);
    public Map<Integer, Float> favFrequency = new HashMap<>();
    public boolean state = false;
    public boolean amfm = false;
    public float frequency = 88.0f;
    
    public boolean getState(){
        if (state == true) {
            return true;
        } else {
            return false;
        }
    } //Retornamos el valor de si esta encendido o no

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
        
    } //Apagar y encender

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
    } //FM o AM

    public boolean getStateAMFM(){
        if (amfm == true) {
            return true;
        } else {
            return false;
        }

    } //Obtener si esta en FM o AM

    public void nextFrequency() {
        if (state) {
            BigDecimal frequencyBigDecimal = BigDecimal.valueOf(frequency);
            BigDecimal increment = amfm ? BigDecimal.valueOf(0.1) : BigDecimal.valueOf(0.1);
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
    
    public void previousFrequency() {
        if (state) {
            BigDecimal frequencyBigDecimal = BigDecimal.valueOf(frequency);
            BigDecimal decrement = amfm ? BigDecimal.valueOf(0.1) : BigDecimal.valueOf(0.1);
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

    public float getCurrentFrequency() {
        return frequency;
    }//Obtener la frecuencia actual

    public void setFavFrequency(int button) {
        if (state) {
            float currentFrequency = getCurrentFrequency();
            favFrequency.put(button, currentFrequency);
            System.out.println("Frecuencia guardada en el botón " + button);
        } else {
            System.out.println("ERROR Radio apagada, enciéndela");
        }
    } //Guarda frecuencia

    public float getFavFrequency(int button) {
        return favFrequency.getOrDefault(button, 0.0f);
    } //Llama frecuencia    

}