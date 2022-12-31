package version

import org.gradle.api.Project

class SemanticVersion private constructor(
    var major: Int,
    var minor: Int,
    var patch: Int,
    var preRelease: String?,
    var metadata: String?
) {
    override fun toString(): String {
        var version = "${major}.${minor}.${patch}"
        preRelease?.let {
            if (it.isNotBlank()) {
                version += "-${it}"
            }
        }
        metadata?.let {
            if (it.isNotBlank()) {
                version += "+${it}"
            }
        }
        return version
    }

    companion object {
        val initial = SemanticVersion(0, 0, 0, "SNAPSHOT", null)

        fun from(str: String): SemanticVersion? {
            // https://semver.org/#is-there-a-suggested-regular-expression-regex-to-check-a-semver-string
            // ^v?(0|[1-9]\d*)\.(0|[1-9]\d*)\.(0|[1-9]\d*)(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\.(?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\+([0-9a-zA-Z-]+(?:\.[0-9a-zA-Z-]+)*))?$
            val regex =
                Regex("^v?(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?\$")
            val result = regex.matchEntire(str) ?: return null
            val groupValues = result.groupValues
            if (groupValues.size != 6)
                throw IllegalArgumentException("Invalid str $str")
            return SemanticVersion(
                groupValues[1].toInt(),
                groupValues[2].toInt(),
                groupValues[3].toInt(),
                groupValues[4],
                groupValues[5]
            )
        }
    }
}

fun createVersion(project: Project): String {
    "git fetch --tags".runCommand()
    val versionString = "git describe --tags --always --first-parent".runCommand().output
    val version = SemanticVersion.from(versionString) ?: SemanticVersion.initial
    if (version.preRelease != null) {
        val nextMajor = project.properties["nextVersion.major"] as? Int
        val nextMinor = project.properties["nextVersion.minor"] as? Int
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
