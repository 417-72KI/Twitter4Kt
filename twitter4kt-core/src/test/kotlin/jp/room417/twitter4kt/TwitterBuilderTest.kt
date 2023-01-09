package jp.room417.twitter4kt

import kotlin.test.Test
import kotlin.test.assertEquals

class TwitterBuilderTest {
    @Test
    fun build() {
        val twitterInstance = Twitter.Builder()
            .setOAuthConsumer("foo", "bar")
            .setOAuthAccessToken("baz", "qux")
            .build()
        val clazz = Class.forName("jp.room417.twitter4kt.internal.TwitterImpl").kotlin
        assertEquals(twitterInstance.javaClass.name, clazz.qualifiedName)
    }
}
