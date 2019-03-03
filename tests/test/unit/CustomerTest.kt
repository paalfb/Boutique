package unit

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

import shoppingcart.*
class CustomerTest {

    @Test
    fun `add customer`() {
        assertEquals(0, Customer("Billy B").customerNumber())
        assertEquals(1, Customer("Silly C").customerNumber())

    }
}