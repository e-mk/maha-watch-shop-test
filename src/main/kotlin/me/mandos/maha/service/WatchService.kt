package me.mandos.maha.service

import me.mandos.maha.model.Watch

interface WatchService {

    fun checkout(watchIdList: List<String>): Int

    fun save(watch: Watch): Watch

    fun getById(id: String): Watch

    fun update(watch: Watch): Watch

    fun delete(id: String): Watch
}