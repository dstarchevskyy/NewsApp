package com.droiddevstar.newsapp.presentation.screen.about

class Person(val name: String) {
    init {
        println("name: $name")
    }

    constructor(val firstName: String, val lastName: String) : this(firstName)
}
