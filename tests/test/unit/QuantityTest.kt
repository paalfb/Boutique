package unit

import org.junit.jupiter.api.Test
import shoppingcart.*
import shoppingcart.Item.Companion.bread
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class QuantityTest {

    @Test fun `equality of like items`() {
        assertEquals(1.bread, 1.bread)
        assertEquals(2.bread, 2.bread)
    }

    @Test fun `unequal items with equal quantity`() {
        assertNotEquals(1.bread, 1.cheese)
    }

    @Test fun `unequal quantity of like items`(){
        assertNotEquals(2.bread, 3.bread)
    }

    @Test fun arithmetic() {
        assertEquals(2.bread, 1.bread.plus(1.bread))
        assertEquals(3.bread, 5.bread.minus(2.bread))
        assertEquals(1.bread, 3.bread.plus(-2.bread))
        assertEquals(1.bread, 3.bread + -2.bread)
        assertEquals(1.bread, -3.bread + 4.bread)
        assertNotEquals(2.bread, 3.bread -2.bread)
        assertEquals(0.bread, 3.bread - 3.bread)
        assertEquals(0.cheese, 4.cheese - 4.cheese)
    }

    @Test fun `item with largest quantity`() {
        assertEquals(5.bread, arrayListOf(2.juice, 5.bread, 1.eggs).most())
    }

}