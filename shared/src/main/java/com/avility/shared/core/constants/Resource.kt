package com.avility.shared.core.constants

/**
 * [Resource] to represents the possible states of a request.
 *
 * @author Heiner Gomez
 */
sealed class Resource<T>(val data:T? = null, val message: Int? = null) {
    class Success<T>(data: T?): Resource<T>(data)
    class Error<T>(message: Int, data: T? = null): Resource<T>(data, message)
}