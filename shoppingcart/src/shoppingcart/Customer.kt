package shoppingcart


class Customer(private var name: String) {
    companion object {
        val customerNumbers: MutableList<Number> = mutableListOf()

        fun getCustomNumber(): Number {
            this.customerNumbers.add(customerNumbers.lastIndex + 1, customerNumbers.lastIndex + 1)
            return customerNumbers.lastIndex
        }
    }

    private var custerNumber: Number

    init {
        this.custerNumber = Customer.getCustomNumber()
    }

    fun customerNumber(): Number {
        return this.custerNumber
    }
}