package unit

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll

import shoppingcart.Customer
import shoppingcart.Shop
import kotlin.test.assertEquals

class ShopTest {
    var shop: Shop

    init {
        shop = Shop()
    }

    @Test
    fun `Register and remove customer`() {
        val customer1 = shop.registerCustomer("Anna A")
        val customer2 = shop.registerCustomer("Bobb B")
        assertEquals(2,shop.numberOfCustomers())
        shop.removeCustomer(customer1)
        shop.removeCustomer(customer2)
        assertEquals(0, shop.numberOfCustomers())
        val customer3 = shop.registerCustomer("Tore T")
        val customer4 = shop.registerCustomer("Celia C")
        val customer5 = shop.registerCustomer("Delia D")
        assertEquals(1,customer4.customerNumber())
        shop.removeCustomer(customer4)
        assertEquals(2, shop.numberOfCustomers())
        shop.removeCustomer(customer3)
        shop.removeCustomer(customer5)


    }

}