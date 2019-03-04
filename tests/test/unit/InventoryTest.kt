package unit

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import shoppingcart.*
class InventoryTest {

    @Test
    fun `add items to inventory`() {
        val inventory = Inventory()
        Inventory.buildInventory()
        assertEquals(30, Inventory.itemCount(Item.bread))
        Inventory.addItems(1.bread)
        Inventory.addItems(6.coffee)
        assertEquals(31, Inventory.itemCount(Item.bread))
        assertEquals(40, Inventory.itemCount(Item.coffee))
        assertEquals(100, Inventory.itemCount(Item.eggs))
    }

    @Test fun `remove items from inventory`(){
        val inventory = Inventory()
        Inventory.buildInventory()
        Inventory.removeItems(1.bread)
        Inventory.removeItems(6.coffee)
        assertEquals(29, Inventory.itemCount(Item.bread))
        assertEquals(28, Inventory.itemCount(Item.coffee))
    }
}