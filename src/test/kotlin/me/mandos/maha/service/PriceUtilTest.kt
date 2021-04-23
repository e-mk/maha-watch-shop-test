package me.mandos.maha.service

import me.mandos.maha.MahaWatchShopApplication
import me.mandos.maha.model.Discount
import me.mandos.maha.model.Watch
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [MahaWatchShopApplication::class])
class PriceUtilTest {

    @Test
    fun calculatePriceTest() {
        val watch = Watch("001", "Rolex", 100, Discount(3, 200))
        val price = calculatePrice(watch, 10)

        assertThat(price).isEqualTo(700)
    }
}