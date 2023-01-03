plugins {
    kotlin("jvm") version Dependencies.Version.kotlin
    id("org.jetbrains.dokka") version Dependencies.Version.kotlin
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    `java-library`
    `maven-publish`
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

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    arrayOf(
        "import-ordering",
        "no-wildcard-imports"
    ).forEach(disabledRules::add)
    reporters {
        ignoreFailures.set(true)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}

val sourceJar by tasks.creating(Jar::class) {
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

    dokkaJavadoc {
        inputs.dir("src/main/kotlin")
    }

    artifacts {
        archives(sourceJar)
        archives(javadocJar)
        archives(jar)
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
            throw GradleException("`${version}` already exists.")

        println("set tag for `${version}`")

        "git tag $version main".runCommand().exitCode.let {
            if (it != 0) throw GradleException("invalid return code on `git tag`: $it")
        }
        "gh release create $version --generate-notes".runCommand().exitCode.let {
            if (it != 0) throw GradleException("invalid return code on `gh release create`: $it")
        }
    }
}

publishing {
    publications {
        val describedVersion = createVersion(rootProject)
        create<MavenPublication>("maven") {
            groupId = "jp.room417"
            artifactId = "twitter4kt"
            version = describedVersion
            from(components["java"])
            artifact(javadocJar)

            // pom {
            //     withXml {
            //         println(asNode().get("dependencies"))
            //         val dependenciesNode = asNode().appendNode("dependencies")
            //         configurations.implementation.get().allDependencies.forEach {
            //             if (it.group == null || it.version == null || it.name == "unspecified")
            //                 return@forEach
            //             val dependencyNode = dependenciesNode.appendNode("dependency")
            //             if (it.group == rootProject.name) {
            //                 val dependency = project(":${it.name}")
            //                 val maven = dependency.publishing.publications["maven"] as MavenPublication
            //                 dependencyNode.appendNode(
            //                     "groupId",
            //                     maven.groupId
            //                 )
            //                 dependencyNode.appendNode(
            //                     "artifactId",
            //                     maven.artifactId
            //                 )
            //                 dependencyNode.appendNode(
            //                     "version",
            //                     maven.version
            //                 )
            //             } else {
            //                 dependencyNode.appendNode("groupId", it.group)
            //                 dependencyNode.appendNode("artifactId", it.name)
            //                 dependencyNode.appendNode("version", it.version)
            //             }
            //         }
            //     }
            // }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/417-72KI/Twitter4Kt")
            credentials {
                username = rootProject.localProperties?.getProperty("gpr.user")
                    ?: rootProject.findProperty("gpr.user") as? String
                        ?: System.getenv("GITHUB_USER")
                password = rootProject.localProperties?.getProperty("gpr.key")
                    ?: rootProject.findProperty("gpr.key") as? String
                        ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
