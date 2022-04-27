import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    /**
     * Test in-range index
     */
    @Test
    void setIndex1() {
        Data data = new Data();
        data.setIndex(5);
        assertEquals(5, data.getIndex());
    }

    /**
     * Test out-of-range index
     */
    @Test
    void setIndex2() {
        Data data = new Data();
        data.setIndex(30000);
        assertEquals(0, data.getIndex());
    }

    /**
     * Test negative index
     */
    @Test
    void setIndex3() {
        Data data = new Data();
        data.setIndex(-1);
        assertEquals(29999, data.getIndex());
    }

    /**
     * Test more then 2x out-of-range index
     */
    @Test
    void setIndex4() {
        Data data = new Data();
        data.setIndex(90002);
        assertEquals(2, data.getIndex());
    }

    /**
     * Test more than 2x negative out-of-range index
     */
    @Test
    void setIndex5() {
        Data data = new Data();
        data.setIndex(-90000);
        assertEquals(0, data.getIndex());
    }
}