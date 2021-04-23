package me.mandos.maha.service

import me.mandos.maha.model.Watch

fun calculatePrice(watch: Watch, count: Int): Int =
    if (watch.discount == null) {
        count*watch.price
    } else {
        val discounted = count / watch.discount.count
        val remaining = count - discounted * watch.discount.count
        discounted * watch.discount.price + remaining * watch.price
    }