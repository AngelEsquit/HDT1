package test;
import org.junit.*;
import Src.Radio;
public class Testing {
    @Test
    public void testgetState() {
        Radio radio = new Radio();
        radio.state = true;
        Assert.assertEquals(true, radio.getState());
        radio.state = false;
        Assert.assertEquals(false, radio.getState());
    }
    @Test
    public void testgetStateAMFM() {
        Radio radio = new Radio();
        radio.amfm = true;
        Assert.assertEquals(true, radio.getStateAMFM());
        radio.amfm = false;
        Assert.assertEquals(false, radio.getStateAMFM());
    }
    @Test
    public void testnextFrequency() {
        Radio radio = new Radio();
        radio.frequency = 87.9f;
        radio.state = true;
        radio.amfm = false;
        radio.nextFrequency();
        Assert.assertEquals(88.9f, radio.frequency, 0.1f);
    
    }
}