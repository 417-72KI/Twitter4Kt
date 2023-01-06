import org.gradle.api.Project
import java.io.File
import java.util.*

/**
 * Load all local properties defined on local.properties files in all projects (root and sub projects).
 * How to use:
 * - add apply from: 'properties-reader.gradle' on the root project's build.gradle
 * - get the values by calling project.localProperties.get("property name")
 * - check property existence by calling project.localProperties.contains("property name")
 *
 * https://gist.github.com/ronaldstevanus/b4fab9802b2b0979db97f45cb6207caf
 */

private const val LOCAL_PROPERTIES_FILENAME = "local.properties"

fun getFile(dir: String, filename: String): File? =
    File("$dir${File.separator}$filename")
        .let { if (it.exists()) it else null }

fun getLocalProperties(dir: String) = getFile(dir, LOCAL_PROPERTIES_FILENAME)?.let { file ->
    Properties().apply {
        file.inputStream()
            .use { load(it) }
    }
}

val Project.localProperties
    get() = getLocalProperties(rootDir.absolutePath)

fun Project.getProperties(filename: String) = getFile(rootDir.absolutePath, filename)?.let { file ->
    Properties().apply {
        file.inputStream()
            .use { load(it) }
    }
}
