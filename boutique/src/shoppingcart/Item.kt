package shoppingcart

import java.math.BigDecimal

class Item {

    companion object {
        val bread = Item("Bread", 22.60)
        val juice = Item("Juice", 15.30)
        val chocolate = Item("Chocolate", 25.80)
        val coffee = Item("Coffee", 18.40)
        val strawberryJam = Item("Strawberry Jam", 10.00)
        val cheese = Item("Cheese", 57.70)
        val eggs = Item("Eggs", 13.10)
    }

    private val itemName: String
    private val itemPrice: Double

    private constructor(itemName: String) {
        this.itemName = itemName
        this.itemPrice = 0.0
    }
    private constructor(itemName: String, itemPrice: Double) {
        this.itemName = itemName
        this.itemPrice = itemPrice
    }

    internal fun itemName(): String = this.itemName
    internal fun itemPrice(): Double = this.itemPrice


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
val String.bread get() = Item.bread.itemName()
val String.juice get() = Item.juice.itemName()
val String.chocolate get() = Item.chocolate.itemName()
val String.coffee get() = Item.cheese.itemName()
val String.strawberry get() = Item.strawberryJam.itemName()
val String.cheese get() = Item.cheese.itemName()
val String.eggs get() = Item.eggs.itemName()
