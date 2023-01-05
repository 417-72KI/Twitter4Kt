package jp.room417.twitter4kt

import twitter4j.TwitterFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class TwitterBuilderTest {
    @Test
    fun build() {
        val twitterInstance = Twitter.Builder(FakeTwitterFactory())
            .setOAuthConsumer("foo", "bar")
            .build()
        val clazz = Class.forName("jp.room417.twitter4kt.internal.TwitterImpl").kotlin
        assertEquals(twitterInstance.javaClass.name, clazz.qualifiedName)
    }

    // TODO implement fake
    class FakeTwitterFactory : TwitterFactory()
}
