import util.Command
import java.io.File

/** Execute string as a shell command. */
fun String.runCommand(workingDir: File = File(System.getProperty("user.dir"))) =
    ProcessBuilder(*split(" ").toTypedArray())
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .start()
        .let { Command(it) }
