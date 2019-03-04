package unit

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import shoppingcart.*
class CustomerTest {

    @Test
    fun `add and remove customer`() {
        val customer1 = Customer("Billy B")
        val customer2 = Customer("Silly C")
        assertEquals(0, customer1.customerNumber())
        assertEquals(1, customer2.customerNumber())
        customer1.remove()
        customer2.remove()
    }

    @Test fun `add items to customers shopping cart`() {
        val customer: Customer = Customer("Per P")
        customer.addItems(3.bread)
        assertEquals(3, customer.ItemCount(Item.bread))
        customer.remove()

    }

    @Test fun `remove items from customers shopping cart`(){
        val customer: Customer = Customer("Are A")
        customer.addItems(3.bread)
        customer.removeItem(2.bread)
        assertEquals(1, customer.ItemCount(Item.bread))
        customer.remove()
    }
}