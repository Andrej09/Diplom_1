import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    Database database = new Database();
    int numberIngridients;

    @Before
    public void newBurger() {
        burger = new Burger();
        for (int i = 0; i <= 5; i++) {
            burger.addIngredient(database.availableIngredients().get(i));
        }
        numberIngridients = burger.ingredients.size();
    }

    @Mock
    Bun bun;

    @Test
    public void addBurgerIngredient() {
        int quantity = burger.ingredients.size();
        Assert.assertEquals(6, quantity);
    }

    @Test
    public void removeBurgerIngredient() {
        burger.removeIngredient(5);
        Assert.assertEquals(numberIngridients - 1, burger.ingredients.size());
    }

    @Test
    public void moveBurgerIngredient() {
        Ingredient beforeBurger = burger.ingredients.get(1);
        burger.moveIngredient(1, 0);
        Ingredient afterBurger = burger.ingredients.get(0);
        Assert.assertEquals(beforeBurger, afterBurger);
    }

    @Test
    public void getBurgerPrice() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100f);
        burger.addIngredient(database.availableIngredients().get(5));
        float actualPrice = burger.getPrice();
        Assert.assertEquals( 1700, actualPrice, 0);
    }
}