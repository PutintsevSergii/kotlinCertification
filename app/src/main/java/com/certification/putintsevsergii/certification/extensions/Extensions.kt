package com.certification.putintsevsergii.certification.extensions
import java.util.*



public inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}