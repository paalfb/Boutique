package shoppingcart

import java.math.BigDecimal


class Customer constructor(private val name: String,
                                   private val customerNumber: Number = Customer.getCustomerNumber()) {

    companion object {
        internal var customerNumbers: MutableList<Number>

        init {
            customerNumbers = mutableListOf()
        }

        internal fun getCustomerNumber(): Number {
            this.customerNumbers.add(customerNumbers.lastIndex + 1, customerNumbers.lastIndex + 1)
            return customerNumbers.lastIndex
        }

        internal fun removeCustomer(customerNumber: Number): Boolean = (customerNumbers.contains(customerNumber)).and(customerNumbers.remove(customerNumber))

    }

    private var shoppingCart: ShoppingCart

    init {
        shoppingCart = ShoppingCart()
    }

    fun customerNumber(): Number = customerNumber

    fun remove() = Customer.removeCustomer(this.customerNumber)

    fun addItems(itemQuantity: ItemQuantity) = shoppingCart.addItems(itemQuantity)

    fun removeItem(itemQuantity: ItemQuantity) = shoppingCart.removeItems(itemQuantity)

    fun ItemCount(item: Item): Number = shoppingCart.itemCount(item)

    override fun toString(): String {
        return "Customer(name='$name', customerNumber=$customerNumber)"
    }

    fun totalPrice() : String? = ShoppingCart.totalPrice(this.shoppingCart)


}