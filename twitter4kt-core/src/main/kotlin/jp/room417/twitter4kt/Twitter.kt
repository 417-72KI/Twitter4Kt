package jp.room417.twitter4kt

import jp.room417.twitter4kt.internal.TwitterImpl
import jp.room417.twitter4kt.v1.TwitterV1
import twitter4j.AccessToken
import twitter4j.Twitter.TwitterBuilder

/** A wrapper of [twitter4j.Twitter] */
interface Twitter {
    /** If an api that you want to use has not been wrapped yet, you can call the original api from here. */
    @Deprecated(
        message = "All apis in `twitter4j` is supported now. This will be removed in future.",
        level = DeprecationLevel.WARNING
    )
    val origin: twitter4j.Twitter

    /** An interface for v1.1 apis. */
    val v1: TwitterV1

    /** A builder of [Twitter] instance. */
    @Suppress("unused", "MemberVisibilityCanBePrivate")
    class Builder(
        private val builder: TwitterBuilder = twitter4j.Twitter.newBuilder(),
        consumerKey: String? = null,
        consumerSecret: String? = null,
        accessToken: AccessToken? = null
    ) {
        init {
            builder.oAuthConsumer(consumerKey, consumerSecret)
            if (accessToken != null) {
                builder.oAuthAccessToken(accessToken)
            }
        }

        fun setOAuthConsumer(consumerKey: String, consumerSecret: String): Builder {
            builder.oAuthConsumer(consumerKey, consumerSecret)
            return this
        }

        fun setOAuthAccessToken(accessToken: AccessToken): Builder {
            builder.oAuthAccessToken(accessToken)
            return this
        }

        fun setOAuthAccessToken(token: String, tokenSecret: String): Builder {
            builder.oAuthAccessToken(token, tokenSecret)
            return this
        }

        fun build(): Twitter = TwitterImpl(builder.build())
    }
}
