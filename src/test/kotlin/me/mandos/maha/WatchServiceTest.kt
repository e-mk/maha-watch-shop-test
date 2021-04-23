package me.mandos.maha

import me.mandos.maha.model.Discount
import me.mandos.maha.model.Watch
import me.mandos.maha.service.WatchService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest(classes = [MahaWatchShopApplication::class])
class WatchServiceTest {

    @Autowired
    private lateinit var watchService: WatchService

    @Test
    fun checkoutTest() {
        val watch1 = Watch("001", "name1", 100, Discount(2, 150))
        val watch2 = Watch("002", "name2", 200)
        val savedWatch1 = watchService.save(watch1)
        val savedWatch2 = watchService.save(watch2)

        assertThat(savedWatch1).isNotNull
        assertThat(savedWatch2).isNotNull

        val price = watchService.checkout(listOf(savedWatch1.id, savedWatch1.id, savedWatch2.id))

        assertThat(price).isEqualTo(350)
    }
}