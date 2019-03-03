package shoppingcart

class ItemQuantity internal constructor(internal val qty: Int, internal var item: Item) {


    internal fun erSammeVareType(other: ItemQuantity): Boolean = this.item.equals(other.item)

    internal fun erVareType(other: Item): Boolean = this.item.equals(other)

    override fun equals(other: Any?): Boolean = this === other || other is ItemQuantity && this.equals(other)

    private fun equals(other: ItemQuantity) = this.item.equals(other.item) && this.qty == other.qty

    override fun hashCode() = item.hashCode(qty)

    operator fun plus(other: ItemQuantity) = ItemQuantity(this.qty.toInt() + other.qty.toInt(), this.item)

    operator fun minus(other: ItemQuantity) = ItemQuantity(this.qty - other.qty, this.item)

    operator fun unaryPlus() = this

    operator fun unaryMinus() = ItemQuantity(-qty, item)

    override fun toString(): String {
        return "ItemQuantity(item=$item, qty=$qty)"
    }


}

