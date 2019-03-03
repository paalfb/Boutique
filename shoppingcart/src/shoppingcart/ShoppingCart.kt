package shoppingcart

class ShoppingCart {
    private var shoppingCart: MutableList<ItemQuantity> = mutableListOf()

    fun addItems(other: ItemQuantity) {
        when {
            (this.shoppingCart.containsItem(other.item)) -> {
                this.shoppingCart.set(
                        this.shoppingCart.indexOf(this.shoppingCart[this.shoppingCart.getKey(other.item)]),
                        ItemQuantity(this.shoppingCart[this.shoppingCart.getKey(other.item)].qty + other.qty,
                                this.shoppingCart[this.shoppingCart.getKey(other.item)].item))
            }
            (!this.shoppingCart.contains((other))) -> this.shoppingCart.add(other)
        }
    }

    fun removeItems(shoppingCart: ShoppingCart, other: ItemQuantity) {
        when {
            (this.shoppingCart.containsItem(other.item)) -> {
                when {
                    (this.shoppingCart[this.shoppingCart.getKey(other.item)].qty > other.qty) -> {
                        this.shoppingCart.set(
                                this.shoppingCart.indexOf(this.shoppingCart[this.shoppingCart.getKey(other.item)]),
                                ItemQuantity(shoppingCart.shoppingCart[this.shoppingCart.getKey(other.item)].qty - other.qty,
                                        this.shoppingCart[shoppingCart.shoppingCart.getKey(other.item)].item))

                    }
                    (shoppingCart.shoppingCart[shoppingCart.shoppingCart.getKey(other.item)].qty <= other.qty) -> {
                        shoppingCart.shoppingCart.removeAt(shoppingCart.shoppingCart.getKey(other.item))
                    }
                }
            }
        }
    }

    fun itemCount(item: Item): Int   {
        return if ((!this.shoppingCart.isEmpty()) &&
                this.shoppingCart.containsItem(item)) this.items(item)
        else 0
    }

    private fun items(item: Item): Int = this.shoppingCart.get(this.shoppingCart.getKey(item)).qty


    override fun toString(): String {
        return "ShoppingCart(shoppingCart=${shoppingCart})"
    }
}

private fun  MutableList<ItemQuantity>.containsItem(other: Item): Boolean {
    val filtered = this.filter { vareBeholdning: ItemQuantity -> vareBeholdning.erVareType(other) }.size
    return filtered > 0
}

private fun MutableList<ItemQuantity>.getKey(other: Item): Int {
    val iterator = this.listIterator()
    var index: Int = 0
    while (iterator.hasNext()) {
        val el = iterator.next().item.equals(other)
        when {
            el -> return index
        }
        index += 1
    }
    return -1
}
