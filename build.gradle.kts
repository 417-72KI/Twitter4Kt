import java.util.*

plugins {
    id(Plugins.gradleNexusPublishPlugin) version Plugins.Version.gradleNexusPublishPlugin
}

val properties = project.localProperties ?: Properties().apply {
    System.getenv("OSSRH_USERNAME")?.let {
        setProperty("ossrhUsername", it)
    }
    System.getenv("OSSRH_PASSWORD")?.let {
        setProperty("ossrhPassword", it)
    }
    System.getenv("SONATYPE_STAGING_PROFILE_ID")?.let {
        setProperty("sonatypeStagingProfileId", it)
    }
    System.getenv("SIGNING_KEY_ID")?.let {
        setProperty("signing.keyId", it)
    }
    System.getenv("SIGNING_KEY")?.let {
        setProperty("signing.key", it)
    }
    System.getenv("SIGNING_PASSWORD")?.let {
        setProperty("signing.password", it)
    }
}

group = "io.github.417-72ki"
version = createVersion(project)

val signingKeyId: String? by extra(properties.getProperty("signing.keyId"))
val signingKey: String? by extra(properties.getProperty("signing.key"))
val signingKeyPassword: String? by extra(properties.getProperty("signing.password"))

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(properties.getProperty("ossrhUsername"))
            password.set(properties.getProperty("ossrhPassword"))
            stagingProfileId.set(properties.getProperty("sonatypeStagingProfileId"))
        }
    }
}
