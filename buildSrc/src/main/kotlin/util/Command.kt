package util

import java.util.concurrent.TimeUnit

class Command internal constructor(process: Process) {
    init {
        process.waitFor(60, TimeUnit.MINUTES)
    }

    val exitCode = process.exitValue()
    val output = process.inputStream.bufferedReader()
        .use { it.readText().trim() }
}
