package shoppingcart

class Item {

    companion object {
        val bread = Item("Bread")
        val juice = Item("Juice")
        val chocolate = Item("Chocolate")
        val coffee = Item("Coffee")
        val strawberryJam = Item("Strawberry Jam")
        val cheese = Item("Cheese")
        val eggs = Item("Eggs")
    }

    private val itemName: String

    private constructor(itemName: String) {
        this.itemName = itemName
    }

    fun itemName(): String = this.itemName

    override fun equals(other: Any?): Boolean {
        return when {
            this === other -> true
            other !is Item -> false
            this.itemName != other.itemName -> false
            else -> true
        }

    }

    internal fun hashCode(mengde: Int): Int {
        return itemName.hashCode() + mengde.hashCode()
    }

    override fun toString(): String {
        return "Item(vareTypeNavn='$itemName')"
    }
}

val Number.bread get() = ItemQuantity(this.toInt(), Item.bread)
val Number.juice get() = ItemQuantity(this.toInt(), Item.juice)
val Number.chocolate get() = ItemQuantity(this.toInt(), Item.chocolate)
val Number.coffee get() = ItemQuantity(this.toInt(), Item.coffee)
val Number.strawberryJam get() = ItemQuantity(this.toInt(), Item.strawberryJam)
val Number.cheese get() = ItemQuantity(this.toInt(), Item.cheese)
val Number.eggs get() = ItemQuantity(this.toInt(), Item.eggs)
