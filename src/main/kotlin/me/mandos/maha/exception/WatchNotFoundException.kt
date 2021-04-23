package me.mandos.maha.exception

import java.lang.Exception

class WatchNotFoundException(override val message: String): Exception(message) {

}