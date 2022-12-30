package jp.room417.twitter4k

import kotlin.test.Test
import kotlin.test.assertTrue

class TwitterBuilderTest {
    @Test
    fun build() {
        val twitterInstance = Twitter.Builder()
            .setOAuthConsumer("foo", "bar")
            .build()
        assertTrue(twitterInstance is TwitterImpl)
    }
}
