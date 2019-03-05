package shoppingcart

import com.sun.xml.internal.xsom.impl.UName.comparator


interface Orderable <T> {
    fun isMoreThan(other: T) : Boolean
}

fun <S: Orderable<S>> List<S>.most(): S? {
    if (this.isEmpty()) return null
    var champion = this.first()
    for (challenger in this)
        if (challenger.isMoreThan(champion)) champion = challenger
    return champion
}
