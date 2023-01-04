@file:Repository("https://repo.maven.apache.org/maven2/")
@file:DependsOn("io.github.ackeecz:danger-kotlin-junit:0.1.0")
@file:OptIn(ExperimentalPathApi::class)

import io.github.ackeecz.danger.junit.JUnitPlugin
import systems.danger.kotlin.*
import java.io.File
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.*
import kotlin.streams.toList

register plugin JUnitPlugin

danger(args) {
    val path = Path(System.getProperty("user.dir"))

    path.forEachDirectoryEntryRecursive(glob = "**/build/reports/**/build-error-log.txt") {
        it.useLines { seq ->
            seq.forEach { line ->
                when {
                    line.startsWith("w: ") -> {
                        warn(line.removeRange(0, 2))
                    }
                    line.startsWith("e: ") -> {
                        fail(line.removeRange(0, 2))
                    }
                }
            }
        }
    }
    path.forEachDirectoryEntryRecursive(glob = "**/build/reports/ktlint/**/ktlint*.xml") {
        warn("TODO: parse `$it`")
    }

    path.forEachDirectoryEntryRecursive(glob = "**/build/test-results/*/*.xml") {
        JUnitPlugin.parse(File(it.toUri()))
        JUnitPlugin.report()
    }
}

@Deprecated(
    message = "Use [forEachDirectoryEntryRecursive] as faster",
    replaceWith = ReplaceWith(
        "FileSystems.getDefault().getPathMatcher(\"glob:\$glob\").let { Files.walk(this).filter(it::matches).toList() }",
        "java.nio.file.FileSystems",
        "java.nio.file.Files",
        "kotlin.streams.toList"
    )
)
fun Path.glob(glob: String) =
    FileSystems.getDefault().getPathMatcher("glob:$glob")
        .let {
            Files.walk(this)
                .filter(it::matches)
                .toList()
        }

@SinceKotlin("1.5")
@Throws(IOException::class)
fun Path.forEachDirectoryEntryRecursive(glob: String, action: (Path) -> Unit) {
    if (notExists()) return
    if (!glob.contains("/")) return forEachDirectoryEntry(glob, action)
    when (val subdir = glob.split("/").first()) {
        "*" -> forEachDirectoryEntry(glob = "*") {
            if (it.isDirectory())
                it.forEachDirectoryEntryRecursive(glob.removePrefix("${subdir}/"), action)
        }
        "**" -> forEachDirectoryEntry(glob = "**") {
            if (it.isDirectory())
                it.forEachDirectoryEntryRecursive(glob.removePrefix("${subdir}/"), action)
        }
        else -> resolve(subdir)
            .forEachDirectoryEntryRecursive(glob.removePrefix("${subdir}/"), action)
    }
}
