package bitsSearch;
import static org.junit.Assert.*;
import org.junit.Test;

/*  Much like a Hobbsian Leviathan, this test may appear to have power
    where there is in fact none. I think a programmer should appreciate
    examples of symbols and references.
 */

public class GUITest {

    @Test
    public void testRun() {
        assertTrue( true );
    }
    @Test
    public void guiTest() {
        GUI testGui = new GUI();
    }
    @Test
    public void adminTest() {
        AdminGUI testAdmin = new AdminGUI();
    }
}