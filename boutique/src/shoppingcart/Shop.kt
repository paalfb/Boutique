package shoppingcart

class Shop() {
    private var customers: MutableList<Customer>
    private var inventory: Inventory = Inventory()

    init {
        customers = mutableListOf()
    }

    fun registerCustomer(name: String) : Customer {
        customers.add(Customer(name))
        return customers.last()
    }

    fun removeCustomer(customer: Customer): Boolean {
        Customer.removeCustomer(customer.customerNumber())
        customers.removeAt(this.customers.getKey(customer)) == customer
        return true
    }

    fun numberOfCustomers(): Int = customers.size

}

private fun MutableList<Customer>.getKey(customer: Customer): Int {
    val iterator = this.listIterator()
    var index: Int = 0
    while (iterator.hasNext()) {
        var cust: Customer = iterator.next()
        val el = cust.customerNumber() == customer.customerNumber()
        when {
            el -> return index
        }
        index += 1
    }
    return -1
}