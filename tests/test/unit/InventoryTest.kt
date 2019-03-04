package unit

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import shoppingcart.*
class InventoryTest {

    @BeforeEach
    fun init() {
        Inventory.buildInventory(true)

    }
    @Test
    fun `add items to inventory`() {
        assertEquals(30, Inventory.itemCount(Item.bread))
        Inventory.addItems(1.bread)
        Inventory.addItems(6.coffee)
        assertEquals(31, Inventory.itemCount(Item.bread))
        assertEquals(40, Inventory.itemCount(Item.coffee))
        assertEquals(100, Inventory.itemCount(Item.eggs))
    }

    @Test fun `remove items from inventory`(){
        Inventory.removeItems(1.bread)
        Inventory.removeItems(6.coffee)
        assertEquals(29, Inventory.itemCount(Item.bread))
        assertEquals(28, Inventory.itemCount(Item.coffee))
    }
}