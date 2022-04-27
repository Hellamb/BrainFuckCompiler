import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @Test
    //Test in-range index
    void setIndex1()
    {
        Data data = new Data();
        data.setIndex(5);
        assertEquals(5,data.getIndex());
    }

    @Test
    //Test out-of-range index
    void setIndex2()
    {
        Data data = new Data();
        data.setIndex(30000);
        assertEquals(0,data.getIndex());
    }

    @Test
    //Test negative index
    void setIndex3()
    {
        Data data = new Data();
        data.setIndex(-1);
        assertEquals(29999,data.getIndex());
    }

    @Test
    //Test more then 2x out-of-range index
    void setIndex4()
    {
        Data data = new Data();
        data.setIndex(90002);
        assertEquals(2,data.getIndex());
    }

    @Test
    //Test more than 2x negative out-of-range index
    void setIndex5()
    {
        Data data = new Data();
        data.setIndex(-90000);
        assertEquals(0,data.getIndex());
    }
}