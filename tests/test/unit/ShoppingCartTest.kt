package unit

import org.junit.jupiter.api.Test
import shoppingcart.*
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class ShoppingCartTest {

    @Test fun `add items`() {
        val shoppingCart = ShoppingCart()
        shoppingCart.addItems(1.coffee)
        shoppingCart.addItems(2.coffee)
        shoppingCart.addItems(4.bread)
        shoppingCart.addItems(5.juice)
        shoppingCart.addItems(2.juice)
        assertEquals(3, shoppingCart.itemCount(Item.coffee), "addItem")
        assertEquals(4,shoppingCart.itemCount(Item.bread),"addItem")
        assertNotEquals(5, shoppingCart.itemCount(Item.juice),"addItem")

    }

    @Test fun `remove items`(){
        val shoppingCart = ShoppingCart()
        shoppingCart.addItems(4.eggs)
        shoppingCart.removeItems(shoppingCart, 2.eggs)
        assertEquals(2, shoppingCart.itemCount(Item.eggs), "removeItem")
        shoppingCart.removeItems(shoppingCart, 2.eggs)
        assertEquals(0,shoppingCart.itemCount(Item.eggs),"removeItem")
        shoppingCart.removeItems(shoppingCart, 1.eggs)
        assertEquals(0, shoppingCart.itemCount(Item.eggs),"removeItem")
        shoppingCart.addItems(5.juice)
        shoppingCart.removeItems(shoppingCart, 6.juice)
        assertEquals(0, shoppingCart.itemCount(Item.juice),"removeItem")

    }

}
