package src;

/**
 * The IRadio interface represents a radio device.
 * It provides methods to control the power state, frequency, and favorite frequencies of the radio.
 */
public interface IRadio {
    
    /**
     * Returns the current power state of the radio.
     * @return true if the radio is turned on, false otherwise.
     */
    public boolean getState();

    /**
     * Toggles the power state of the radio.
     * If the radio is turned on, it will be turned off. If it is turned off, it will be turned on.
     */
    public void tooglePowerOffOn();

    /**
     * Toggles between FM and AM modes of the radio.
     * If the radio is currently in FM mode, it will switch to AM mode. If it is in AM mode, it will switch to FM mode.
     */
    public void toogleAMFM();

    /**
     * Returns the current mode (FM or AM) of the radio.
     * @return true if the radio is in FM mode, false if it is in AM mode.
     */
    public boolean getStateAMFM();

    /**
     * Switches to the next frequency available in the current mode.
     */
    public void nextFrequency();

    /**
     * Switches to the previous frequency available in the current mode.
     */
    public void previousFrequency();

    /**
     * Returns the current frequency of the radio.
     * @return the current frequency as a float value.
     */
    public float getCurrentFrequency();

    /**
     * Sets the specified button as a favorite frequency.
     * @param button the button number to set as a favorite frequency.
     */
    public void setFavFrequency(int button);

    /**
     * Returns the favorite frequency associated with the specified button.
     * @param button the button number to retrieve the favorite frequency from.
     * @return the favorite frequency as a float value.
     */
    public float getFavFrequency(int button);
}
