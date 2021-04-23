package me.mandos.maha.repo

import me.mandos.maha.exception.WatchNotFoundException
import me.mandos.maha.model.Watch
import org.springframework.stereotype.Repository

@Repository
class WatchRepoImpl: WatchRepo {

    private val watchDb = mutableMapOf<String, Watch>()

    override fun save(watch: Watch): Watch {
        watchDb[watch.id] = watch
        return watch
    }

    override fun findById(id: String): Watch {
        if (!watchDb.containsKey(id)) {
            throw WatchNotFoundException("Couldn't find watch with given ID : $id")
        }
        return watchDb[id]!!
    }

    override fun delete(id: String): Watch {
        if (!watchDb.containsKey(id)) {
            throw WatchNotFoundException("Couldn't delete watch with given ID : $id")
        }
        return watchDb.remove(id)!!
    }
}