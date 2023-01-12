import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {

    private final String NAME = "black bun";
    private final float PRICE = 200F;

    @Test
    public void getNameReturnsName() {
        Bun bun = new Bun(NAME,1);
        Assert.assertEquals("Метод должен вернуть name!",NAME,bun.getName());
    }

    @Test
    public void getPriceReturnsPrice() {
        Bun bun = new Bun(NAME,PRICE);
        Assert.assertEquals("Метод должен вернуть price!",PRICE,bun.getPrice(),0);
    }

    @Test
    public void bunReturnsName() {
        Bun bun = new Bun(NAME,PRICE);
        Assert.assertEquals(NAME, bun.name);
    }

    @Test
    public void bunReturnsPrice() {
        Bun bun = new Bun(NAME, PRICE);
        Assert.assertEquals(PRICE, bun.price, 0);
    }
}
