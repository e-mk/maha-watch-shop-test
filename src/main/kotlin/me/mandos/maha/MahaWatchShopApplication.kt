package me.mandos.maha

import me.mandos.maha.model.Discount
import me.mandos.maha.model.Watch
import me.mandos.maha.service.WatchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class MahaWatchShopApplication {

	@Autowired
	private lateinit var watchService: WatchService

	@PostConstruct
	fun initApplication() {
		watchService.save(Watch("001", "Rolex", 100, Discount(3, 200)))
		watchService.save(Watch("002", "Michael Kors", 80, Discount(2, 120)))
		watchService.save(Watch("003", "Rolex", 50, null))
		watchService.save(Watch("004", "Rolex", 30, null))
	}


	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<MahaWatchShopApplication>(*args)
		}
	}
}
