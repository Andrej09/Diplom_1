import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class ParameterizedGetReceiptTest {

    private final String BUN_BURGER;
    private final float PRICE_BUN_BURGER;
    private final IngredientType INGREDIENT_TYPE;
    private final String FILLING;
    private final float PRICE_FILLING;
    private final String EXPECTED;

    public ParameterizedGetReceiptTest(String BUN_BURGER, float PRICE_BUN_BURGER, IngredientType INGREDIENT_TYPE,
                                       String FILLING, float PRICE_FILLING, String EXPECTED) {
        this.BUN_BURGER = BUN_BURGER;
        this.PRICE_BUN_BURGER = PRICE_BUN_BURGER;
        this.INGREDIENT_TYPE = INGREDIENT_TYPE;
        this.FILLING = FILLING;
        this.PRICE_FILLING = PRICE_FILLING;
        this.EXPECTED = EXPECTED;
    }


    @Parameterized.Parameters()
    public static Object[][] getReceipt() {
        return new Object[][]{
                {"black bun", 100f, IngredientType.FILLING, "dinosaur", 200f,"(==== black bun ====)" + "\r\n" + "= filling dinosaur =" + "\r\n" +
                        "(==== black bun ====)" +"\r\n" +"\r\n" + "Price: 400,000000\r\n"},
                {"white bun", 200f, IngredientType.FILLING, "cutlet", 100f,"(==== white bun ====)" + "\r\n" + "= filling cutlet =" + "\r\n" +
                        "(==== white bun ====)" +"\r\n" +"\r\n" + "Price: 500,000000\r\n"}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Test
    public void getBurgerReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(BUN_BURGER);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN_BURGER);
        Mockito.when(ingredient.getType()).thenReturn(INGREDIENT_TYPE);
        Mockito.when(ingredient.getName()).thenReturn(FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_FILLING);
        Assert.assertEquals(EXPECTED, burger.getReceipt());
    }
}