package net.legio.esi4k

import java.lang.Exception

class TestPropertiesException: Exception {
    constructor(): super()
    constructor(message: String): super(message)
    constructor(cause: Throwable): super(cause)
    constructor(message: String, cause: Throwable): super(message, cause)
}