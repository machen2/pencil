import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PencilTest {
    Pencil pencil;

    @Before
    public void setUp() {
        pencil = new Pencil();
    }

    @Test
    public void whenPencilIsCreatedDurabilityIs100(){
        assertEquals(100, pencil.getDurability());
    }
    @Test
    public void whenPencilWritesLowercaseLettersDurabilityDecreasesBy1(){
        pencil.write("blah");
        assertEquals(96, pencil.getDurability());
    }
    @Test
    public void whenPencilWritesUppercaseLettersDurabilityDecreasesBy2(){
        pencil.write("BLAH");
        assertEquals(92, pencil.getDurability());
    }

}
