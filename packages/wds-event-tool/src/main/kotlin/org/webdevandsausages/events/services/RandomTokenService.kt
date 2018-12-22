package org.webdevandsausages.events.services

import java.util.*

object RandomTokenService {
    fun getWordPair(): String {
        val random = Random()
        val stream = "words.txt".asResourceStream()
        var token = ""
        stream?.reader().use {
            it?.useLines {
                val words = it.asSequence().toSet().shuffled()
                val wordOne = words.get(random.nextInt(words.size) + 1)
                val wordTwo = words.get(random.nextInt(words.size) + 1)
                token = "$wordOne-$wordTwo"
            }
        }
        return token
    }
}