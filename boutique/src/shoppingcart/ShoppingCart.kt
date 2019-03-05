package shoppingcart

import java.math.RoundingMode
import java.text.DecimalFormat

class ShoppingCart {
    private var shoppingCartList: MutableList<ItemQuantity> = mutableListOf()

   companion object {
       internal fun roundDecimalsTotalPrice(sum: Double): String? {
           val decimalFormat = DecimalFormat("#.###")
           decimalFormat.roundingMode = RoundingMode.CEILING
           return decimalFormat.format(sum)

       }
       internal fun totalPrice(shoppingCart: ShoppingCart): String? {
           val totalPrice = shoppingCart.shoppingCartList
                   .map { itemQuantity: ItemQuantity -> itemQuantity.item.itemPrice()*itemQuantity.qty }  // item prices * number of items
                   .reduce {sum, element -> sum + element}                           // total
           return ShoppingCart.roundDecimalsTotalPrice(totalPrice)

       }
   }

 /*   fun totalPrice(): String? {
        val totalPrice = this.shoppingCartList
                .map { itemQuantity: ItemQuantity -> itemQuantity.item.itemPrice()*itemQuantity.qty }  // item prices * number of items
                .reduce {sum, element -> sum + element}                           // total
        return ShoppingCart.roundDecimalsTotalPrice(totalPrice)

    }*/

    fun addItems(other: ItemQuantity) {
        when {
            (this.shoppingCartList.contains(other.item)) -> {
                this.shoppingCartList.set(
                        this.shoppingCartList.indexOf(this.shoppingCartList[this.shoppingCartList.getKey(other.item)]),
                        ItemQuantity(this.shoppingCartList[this.shoppingCartList.getKey(other.item)].qty + other.qty,
                                this.shoppingCartList[this.shoppingCartList.getKey(other.item)].item))
            }
            (!this.shoppingCartList.contains((other))) -> this.shoppingCartList.add(other)
        }
    }

    fun removeItems(other: ItemQuantity) {
        when {
            (this.shoppingCartList.contains(other.item)) -> {
                when {
                    (this.shoppingCartList[this.shoppingCartList.getKey(other.item)].qty > other.qty) -> {
                        this.shoppingCartList.set(
                                this.shoppingCartList.indexOf(this.shoppingCartList[this.shoppingCartList.getKey(other.item)]),
                                ItemQuantity(this.shoppingCartList[this.shoppingCartList.getKey(other.item)].qty - other.qty,
                                        this.shoppingCartList[this.shoppingCartList.getKey(other.item)].item))

                    }
                    (this.shoppingCartList[this.shoppingCartList.getKey(other.item)].qty <= other.qty) -> {
                        this.shoppingCartList.removeAt(this.shoppingCartList.getKey(other.item))
                    }
                }
            }
        }
    }

    fun itemCount(item: Item): Int   {
        return if ((!this.shoppingCartList.isEmpty()) &&
                this.shoppingCartList.contains(item)) this.items(item)
        else 0
    }

    private fun items(item: Item): Int = this.shoppingCartList.get(this.shoppingCartList.getKey(item)).qty


    override fun toString(): String {
        return "ShoppingCart(shoppingCartList=${shoppingCartList})"
    }
}

private fun  MutableList<ItemQuantity>.contains(other: Item): Boolean {
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
