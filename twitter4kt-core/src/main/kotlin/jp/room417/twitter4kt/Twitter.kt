package jp.room417.twitter4kt

import jp.room417.twitter4kt.api.TimelinesResources
import jp.room417.twitter4kt.api.TweetsResources
import jp.room417.twitter4kt.api.UsersResources
import jp.room417.twitter4kt.auth.OAuthSupport
import jp.room417.twitter4kt.internal.TwitterImpl
import jp.room417.twitter4kt.util.letWith
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken

/** A wrapper of [twitter4j.Twitter] */
interface Twitter : OAuthSupport {
    /** If an api that you want to use has not been wrapped yet, you can call the original api from here. */
    val origin: twitter4j.Twitter

    /** A wrapper of [twitter4j.Twitter.timelines] */
    fun timelines(): TimelinesResources

    /** A wrapper of [twitter4j.Twitter.tweets] */
    fun tweets(): TweetsResources

    /** A wrapper of [twitter4j.Twitter.users] */
    fun users(): UsersResources

    @Suppress("unused", "MemberVisibilityCanBePrivate")
    class Builder(
        private val factory: TwitterFactory = TwitterFactory(),
        private var consumerKey: String? = null,
        private var consumerSecret: String? = null,
        private var accessToken: AccessToken? = null
    ) {
        fun setOAuthConsumer(
            consumerKey: String,
            consumerSecret: String
        ): Builder {
            this.consumerKey = consumerKey
            this.consumerSecret = consumerSecret
            return this
        }

        fun setOAuthAccessToken(accessToken: AccessToken): Builder {
            this.accessToken = accessToken
            return this
        }

        fun setOAuthAccessToken(token: String, tokenSecret: String) =
            setOAuthAccessToken(AccessToken(token, tokenSecret))

        fun build(): Twitter = TwitterImpl(factory.instance).apply {
            consumerKey?.letWith(consumerSecret) { key, secret ->
                setOAuthConsumer(key, secret)
            }
            accessToken?.let {
                setOAuthAccessToken(it)
            }
        }
    }
}
