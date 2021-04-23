package me.mandos.maha.controller

import me.mandos.maha.controller.dto.CheckoutResponse
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/checkout"])
class CheckoutController() {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun checkout(@RequestBody watchIdList: List<String>): ResponseEntity<CheckoutResponse> {
        log.debug(watchIdList.toString())
        return ResponseEntity.ok(CheckoutResponse(0))
    }

}