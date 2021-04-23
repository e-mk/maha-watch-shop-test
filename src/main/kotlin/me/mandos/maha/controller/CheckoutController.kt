package me.mandos.maha.controller

import me.mandos.maha.controller.dto.CheckoutResponse
import me.mandos.maha.exception.WatchNotFoundException
import me.mandos.maha.service.WatchService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/checkout"])
class CheckoutController(private val watchService: WatchService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping
    @Throws(WatchNotFoundException::class)
    fun checkout(@RequestBody watchIdList: List<String>): ResponseEntity<CheckoutResponse> {
        log.debug(watchIdList.toString())
        return ResponseEntity.ok(CheckoutResponse(watchService.checkout(watchIdList)))
    }

}