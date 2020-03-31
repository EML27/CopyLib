package main

import copy_utils.CopyMaker

fun main() {
    fun Man.out() {
        println(name)
        println(age)
        println(favoriteBooks)
    }

    val original =
            Man(
                    "Steve", 20, listOf(
                    "the Martian",
                    "1984",
                    "Voynich manuscript ",
                    "Vingt mille lieues sous les mers"
            )
            )

    var copy = Man("Yes", 2, arrayListOf("you", "have to", "make an instance", "first"))

    CopyMaker.copy(original, copy)

    original.out()

    copy.out()
}
