package me.mandos.maha.service

import me.mandos.maha.model.Watch
import me.mandos.maha.repo.WatchRepo
import org.springframework.stereotype.Service

@Service
class WatchServiceImpl(private val watchRepo: WatchRepo): WatchService {

    override fun checkout(watchIdList: List<String>): Int {
        var price = 0
        val watchCountMap = watchIdList.groupingBy{it}.eachCount()
        watchCountMap.forEach { (id, count) ->
            val watch = watchRepo.findById(id)
            price += calculatePrice(watch, count)
        }
        return price
    }

    override fun save(watch: Watch): Watch {
        return watchRepo.save(watch)
    }

    override fun getById(id: String): Watch {
        return watchRepo.findById(id)
    }

    override fun delete(id: String): Watch {
        return watchRepo.delete(id)
    }
}