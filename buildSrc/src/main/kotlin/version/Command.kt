package version

import java.io.File
import java.util.concurrent.TimeUnit

/** Execute string as a shell command. */
fun String.runCommand(workingDir: File = File(System.getProperty("user.dir"))): Command {
    val process = ProcessBuilder(*split(" ").toTypedArray())
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
    return Command(process)
}

class Command internal constructor(process: Process) {
    init {
        process.waitFor(60, TimeUnit.MINUTES)
    }

    val exitCode = process.exitValue()
    val output = process.inputStream.bufferedReader()
        .use { it.readText().trim() }
}
