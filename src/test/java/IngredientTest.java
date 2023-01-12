import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private final String NAME = "black bun";
    private final float PRICE = 200F;

    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,NAME,PRICE);
        Assert.assertEquals(PRICE, ingredient.getPrice(),0);
    }

    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,NAME,PRICE);
        Assert.assertEquals(NAME, ingredient.getName());
    }

    @Test
    public void getTypeReturnsType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING,NAME,PRICE);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void ingredientPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,NAME,PRICE);
        Assert.assertEquals(PRICE, ingredient.price,0);
    }

    @Test
    public void ingredientNameReturnsName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,NAME,PRICE);
        Assert.assertEquals(NAME, ingredient.name);
    }

    @Test
    public void ingredientTypeReturnsType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,NAME,PRICE);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.type);
    }
}
