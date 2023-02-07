package com.john.oauth.common.exception

/**
 * @author yoonho
 * @since 2023.02.07
 */
class NotFoundDataException: RuntimeException {
    constructor(msg: String?): super(msg)
    constructor(): super()
}