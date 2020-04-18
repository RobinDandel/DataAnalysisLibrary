import org.junit.Test;

import static org.junit.Assert.*;


public class AdditionTest {
    @Test
    public void calcOK(){
        Addition ad = new Addition();
        assertEquals(10,ad.calculer(5,5));
    }

}