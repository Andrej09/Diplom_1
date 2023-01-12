import org.junit.Assert;
import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void addBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveBurgerIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
        burger.moveIngredient(0, 1);
        Assert.assertEquals("cutlet", burger.ingredients.get(1).name);
    }

    @Test
    public void getBurgerPrice() {
        Burger burger = new Burger();
        float price = 100;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(price * 2 + price, burger.getPrice(), 0);
    }
}