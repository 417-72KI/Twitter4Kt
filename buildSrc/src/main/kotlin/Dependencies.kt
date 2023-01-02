object Dependencies {
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}" }
    val twitter4j by lazy { "org.twitter4j:twitter4j-core:${Version.twitter4j}" }

    object Version {
        val kotlin by lazy { "1.7.20" }
        val kotlinCoroutines by lazy { "1.6.4" }
        val twitter4j by lazy { "4.0.7" }
    }
}
