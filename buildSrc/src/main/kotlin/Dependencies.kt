object Dependencies {
    val kotlinBom by lazy { "org.jetbrains.kotlin:kotlin-bom" }
    val kotlinStdlib by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8" }
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}" }
    val twitter4j by lazy { "org.twitter4j:twitter4j-core:${Version.twitter4j}" }

    object Version {
        val jvmTarget by lazy { "1.8" }
        val kotlin by lazy { "1.7.20" }
        val kotlinCoroutines by lazy { "1.6.4" }
        val twitter4j by lazy { "4.0.7" }
    }
}

object TestDependencies {
    val kotlinTest by lazy { "org.jetbrains.kotlin:kotlin-test" }
    val kotlinTestJunit by lazy { "org.jetbrains.kotlin:kotlin-test-junit" }
}
