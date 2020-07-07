package com.eve_engine.esi4k

fun Boolean.isTrue(action: () -> Unit): Boolean {
    if(this) {
        action.invoke()
    }
    return this
}

fun Boolean.isFalse(action: () -> Unit): Boolean {
    if(!this){
        action.invoke()
    }
    return this
}