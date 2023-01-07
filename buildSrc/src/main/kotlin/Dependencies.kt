object Dependencies {
    val kotlinBom by lazy { "org.jetbrains.kotlin:kotlin-bom" }
    val kotlinStdlib by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8" }
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}" }
    val twitter4j by lazy { "org.twitter4j:twitter4j-core:${Version.twitter4j}" }

    object Version {
        val jvmTarget by lazy { "1.8" }
        val kotlin by lazy { "1.7.20" }
        val kotlinCoroutines by lazy { "1.6.4" }
        val ktlint by lazy { "0.45.2" }
        val twitter4j by lazy { "4.1.2" }
    }
}

object TestDependencies {
    val kotlinTest by lazy { "org.jetbrains.kotlin:kotlin-test" }
    val kotlinTestJunit by lazy { "org.jetbrains.kotlin:kotlin-test-junit" }
}

object Plugins {
    val dokka by lazy { "org.jetbrains.dokka" }
    val ktlint by lazy { "org.jlleitschuh.gradle.ktlint" }
    val gradleNexusPublishPlugin by lazy { "io.github.gradle-nexus.publish-plugin" }

    object Version {
        val kotlin by lazy { Dependencies.Version.kotlin }
        val dokka by lazy { kotlin }
        val ktlint by lazy { "11.0.0" }
        val gradleNexusPublishPlugin by lazy { "1.1.0" }
    }
}
