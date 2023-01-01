import version.createVersion
import version.localProperties
import version.runCommand

plugins {
    kotlin("jvm") version "1.6.21"
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    api("org.twitter4j:twitter4j-core:4.0.7")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    val sourceJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn.add(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
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
            artifactId = "twitter4k"
            version = describedVersion
            from(components["kotlin"])

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
            url = uri("https://maven.pkg.github.com/417-72KI/Twitter4K")
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
