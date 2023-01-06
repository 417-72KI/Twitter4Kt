plugins {
    kotlin("jvm") version Plugins.Version.kotlin
    id(Plugins.dokka) version Plugins.Version.dokka
    id(Plugins.ktlint) version Plugins.Version.ktlint
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(Dependencies.kotlinBom))
    implementation(Dependencies.kotlinStdlib)
    implementation(Dependencies.kotlinCoroutines)

    api(Dependencies.twitter4j)

    testImplementation(TestDependencies.kotlinTest)
    testImplementation(TestDependencies.kotlinTestJunit)
}

ktlint {
    version.set(Dependencies.Version.ktlint)
    arrayOf(
        "no-wildcard-imports"
    ).forEach(disabledRules::add)
    reporters {
        ignoreFailures.set(true)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

val javadocJar by tasks.creating(Jar::class) {
    dependsOn("dokkaJavadoc")
    archiveClassifier.set("javadoc")
    from(tasks.named("dokkaJavadoc"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = Dependencies.Version.jvmTarget
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = Dependencies.Version.jvmTarget
    }

    artifacts {
        archives(sourcesJar)
        archives(javadocJar)
    }
}

tasks.register("printVersion") {
    doLast {
        println(createVersion(rootProject))
    }
}

tasks.register("createTagFromVersion") {
    doFirst {
        if ("git symbolic-ref --short HEAD".runCommand().output != "main") {
            throw GradleException("This task must be run in main branch")
        }
        "git pull --rebase --tags".runCommand()
    }
    doLast {
        var version = createVersion(rootProject)
            .replaceFirst("-SNAPSHOT", "")
        if (!version.startsWith("v")) {
            version = "v$version"
        }
        val versionList = "git tag".runCommand().output.split("\n")
        if (versionList.contains(version))
            throw GradleException("`$version` already exists.")

        println("set tag for `$version`")

        "git tag $version main".runCommand().exitCode.let {
            if (it != 0) throw GradleException("invalid return code on `git tag`: $it")
        }
        "gh release create $version --generate-notes".runCommand().exitCode.let {
            if (it != 0) throw GradleException("invalid return code on `gh release create`: $it")
        }
    }
}

group = rootProject.group
version = rootProject.version

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "twitter4kt"
            from(components["java"])
            artifact(sourcesJar)
            artifact(javadocJar)

            project.rootProject.getProperties("pom.properties")?.let { properties ->
                pom {
                    name.set(properties.getProperty("ARTIFACT_ID"))
                    description.set(properties.getProperty("DESCRIPTION"))
                    url.set(properties.getProperty("URL"))

                    licenses {
                        license {
                            name.set(properties.getProperty("LICENSE_NAME"))
                            url.set(properties.getProperty("LICENSE_URL"))
                        }
                    }
                    developers {
                        developer {
                            id.set(properties.getProperty("DEVELOPER_ID"))
                            name.set(properties.getProperty("DEVELOPER_NAME"))
                            email.set(properties.getProperty("DEVELOPER_EMAIL"))
                        }
                    }
                    scm {
                        connection.set(properties.getProperty("SCM_CONNECTION"))
                        developerConnection.set(properties.getProperty("SCM_DEVELOPER_CONNECTION"))
                        url.set(properties.getProperty("SCM_URL"))
                    }
                }
            }
        }
    }
}

val signingKeyId: String? by project
val signingKey: String? by project
val signingKeyPassword: String? by project

signing {
    useInMemoryPgpKeys(
        signingKeyId,
        signingKey,
        signingKeyPassword
    )
    sign(publishing.publications)
}
