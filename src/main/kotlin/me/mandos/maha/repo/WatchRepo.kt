package me.mandos.maha.repo

import me.mandos.maha.model.Watch

interface WatchRepo {

    fun save(watch: Watch): Watch

    fun findById(id: String): Watch

    fun delete(id: String): Watch
}