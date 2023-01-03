package util

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
        val initial
            get() = SemanticVersion(0, 0, 0, "SNAPSHOT", null)

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
                groupValues[4].ifBlank { null },
                groupValues[5].ifBlank { null }
            )
        }
    }
}
