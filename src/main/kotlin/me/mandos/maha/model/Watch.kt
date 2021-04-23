package me.mandos.maha.model

data class Watch(val id: String, val name: String, val price: Int, val discount: Discount)
data class Discount(val count: Int, val price: Int)