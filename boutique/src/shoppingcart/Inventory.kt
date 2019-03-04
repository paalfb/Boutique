package shoppingcart

class Inventory {

    companion object {
        private val inventory: MutableList<ItemQuantity> = mutableListOf()


        fun buildInventory() {
            inventory.add(30.bread)
            inventory.add(40.juice)
            inventory.add(50.chocolate)
            inventory.add(34.coffee)
            inventory.add(14.strawberryJam)
            inventory.add(24.cheese)
            inventory.add(100.eggs)
        }

        fun addItems(items: ItemQuantity) {
            when {
                (inventory.containsItem(items.item)) -> {
                    inventory.set(
                            inventory.indexOf(inventory[inventory.getKey(items.item)]),
                            ItemQuantity(inventory[inventory.getKey(items.item)].qty + items.qty,
                                    inventory[inventory.getKey(items.item)].item))
                }
                (!inventory.contains((items))) -> inventory.add(items)
            }
        }

        fun removeItems(other: ItemQuantity) {
            when {
                (this.inventory.containsItem(other.item)) -> {
                    when {
                        (this.inventory[this.inventory.getKey(other.item)].qty > other.qty) -> {
                            this.inventory.set(
                                    this.inventory.indexOf(this.inventory[this.inventory.getKey(other.item)]),
                                    ItemQuantity(this.inventory[this.inventory.getKey(other.item)].qty - other.qty,
                                            this.inventory[this.inventory.getKey(other.item)].item))

                        }
                        (this.inventory[this.inventory.getKey(other.item)].qty <= other.qty) -> {
                            this.inventory.removeAt(this.inventory.getKey(other.item))
                        }
                    }
                }
            }
        }

        fun itemCount(item: Item): Int   {
            return if ((!inventory.isEmpty()) &&
                    inventory.containsItem(item)) this.items(item)
            else 0
        }

        private fun items(item: Item): Int = inventory.get(inventory.getKey(item)).qty

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


    }

}