package me.mandos.maha.model

data class Watch(val id: String, val name: String, val price: Int, val discount: Discount?) {
    constructor(id: String, name: String, price: Int) : this(id, name, price, null)
}
data class Discount(val count: Int, val price: Int)