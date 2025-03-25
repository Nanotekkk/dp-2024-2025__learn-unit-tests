package fr.anthonyquere.fizzbuzz;

import fr.anthonyquere.teashop.TeaShop;
import fr.anthonyquere.teashop.Tea;
import fr.anthonyquere.teashop.TeaCup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TeaShopUnitTests {

    private Tea tea;
    private TeaShop teaShop;

    @BeforeEach
    void setUp() {
        tea = new Tea("Green Tea", 180, 80, true);
        teaShop = new TeaShop(90);
    }

    @Test
    void testTeaConstructor() {
        assertEquals("Green Tea", tea.getName());
        assertEquals(180, tea.getSteepingTimeSeconds());
        assertEquals(80, tea.getIdealTemperatureCelsius());
        assertTrue(tea.isLoose());
    }

    @Test
    void testTeaSettersAndGetters() {
        tea.setName("Black Tea");
        assertEquals("Black Tea", tea.getName());

        tea.setSteepingTimeSeconds(240);
        assertEquals(240, tea.getSteepingTimeSeconds());

        tea.setIdealTemperatureCelsius(85);
        assertEquals(85, tea.getIdealTemperatureCelsius());

        tea.setLoose(false);
        assertFalse(tea.isLoose());
    }

    @Test
    void testTeaShopAddTea() {
        teaShop.addTea(tea);
        TeaCup cup = teaShop.prepareTea("Green Tea");
        assertNotNull(cup);
    }

    @Test
    void testTeaShopPrepareNonExistentTea() {
        assertThrows(IllegalArgumentException.class, () -> teaShop.prepareTea("Oolong"));
    }

    @Test
    void testTeaShopSetWaterTemperature() {
        teaShop.setWaterTemperature(75);
        assertThrows(IllegalArgumentException.class, () -> teaShop.setWaterTemperature(-5));
    }
}