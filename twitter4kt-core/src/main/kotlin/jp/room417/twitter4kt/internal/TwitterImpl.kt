package jp.room417.twitter4kt.internal

import jp.room417.twitter4kt.Twitter
import jp.room417.twitter4kt.v1.TwitterV1
import jp.room417.twitter4kt.v1.internal.TwitterV1Impl

@Suppress("OverridingDeprecatedMember", "OVERRIDE_DEPRECATION")
internal class TwitterImpl(private val twitter: twitter4j.Twitter) : Twitter {
    override val origin = twitter

    override val v1: TwitterV1
        get() = TwitterV1Impl(twitter.v1())
}
