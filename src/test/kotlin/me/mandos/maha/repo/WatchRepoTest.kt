package me.mandos.maha.repo

import me.mandos.maha.MahaWatchShopApplication
import me.mandos.maha.exception.WatchNotFoundException
import me.mandos.maha.model.Watch
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [MahaWatchShopApplication::class])
class WatchRepoTest {

    @Autowired
    private lateinit var watchRepo: WatchRepo

    @Test
    fun crudTest() {
        val id = "001"
        val name = "name1"
        val price = 100
        val watch = Watch(id, name, price)
        watchRepo.save(watch)

        val savedWatch = watchRepo.findById(id)

        assertThat(savedWatch.id).isEqualTo(id)
        assertThat(savedWatch.name).isEqualTo(name)
        assertThat(savedWatch.price).isEqualTo(price)

        val newName = "name2"
        val newPrice = 200
        val newWatch = Watch(id, newName, newPrice)
        val updatedWatch = watchRepo.save(newWatch)

        assertThat(updatedWatch.id).isEqualTo(newWatch.id)
        assertThat(updatedWatch.name).isEqualTo(newWatch.name)
        assertThat(updatedWatch.price).isEqualTo(newWatch.price)

        watchRepo.delete(id)

        assertThrows(WatchNotFoundException::class.java) { watchRepo.findById(id) }
    }

}