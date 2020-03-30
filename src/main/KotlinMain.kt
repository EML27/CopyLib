package main

import copy_utils.CopyUtils

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

    val copy = CopyUtils.clone(original)

    original.out()

    copy.out()
}
