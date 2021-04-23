package me.mandos.maha.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.Exception

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class WatchNotFoundException(override val message: String): Exception(message)