import org.gradle.api.Project
import util.SemanticVersion

fun createVersion(project: Project): String {
    "git fetch --tags".runCommand()
    val versionString = "git describe --tags --always --first-parent".runCommand().output
    val version = SemanticVersion.from(versionString) ?: SemanticVersion.initial
    if (version.preRelease != null) {
        val nextMajor = project.properties["nextVersion.major"]?.toString()?.toInt()
        val nextMinor = project.properties["nextVersion.minor"]?.toString()?.toInt()
        if (nextMajor != null && nextMajor > version.major) {
            version.major = nextMajor
            version.minor = 0
            version.patch = 0
        } else if (nextMinor != null && nextMinor > version.minor) {
            version.minor = nextMinor
            version.patch = 0
        } else {
            version.patch += 1
        }
        version.preRelease = "SNAPSHOT"
    }
    return version.toString()
}
