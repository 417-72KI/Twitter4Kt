package jp.room417.twitter4kt

import jp.room417.twitter4kt.api.*
import jp.room417.twitter4kt.auth.OAuthSupport
import jp.room417.twitter4kt.internal.TwitterImpl
import jp.room417.twitter4kt.util.letWith
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken

/** A wrapper of [twitter4j.Twitter] */
interface Twitter : OAuthSupport {
    /** If an api that you want to use has not been wrapped yet, you can call the original api from here. */
    @Deprecated(
        message = "All apis in `twitter4j` is supported now. This will be removed in future.",
        level = DeprecationLevel.WARNING
    )
    val origin: twitter4j.Twitter

    /** A wrapper of [twitter4j.Twitter.timelines] */
    fun timelines(): TimelinesResources

    /** A wrapper of [twitter4j.Twitter.tweets] */
    fun tweets(): TweetsResources

    /** A wrapper of [twitter4j.Twitter.search] */
    fun search(): SearchResource

    /** A wrapper of [twitter4j.Twitter.directMessages] */
    fun directMessages(): DirectMessagesResources

    /** A wrapper of [twitter4j.Twitter.friendsFollowers] */
    fun friendsFollowers(): FriendsFollowersResources

    /** A wrapper of [twitter4j.Twitter.users] */
    fun users(): UsersResources

    /** A wrapper of [twitter4j.Twitter.suggestedUsers] */
    fun suggestedUsers(): SuggestedUsersResources

    /** A wrapper of [twitter4j.Twitter.favorites] */
    fun favorites(): FavoritesResources

    /** A wrapper of [twitter4j.Twitter.list] */
    fun list(): ListsResources

    /** A wrapper of [twitter4j.Twitter.savedSearches] */
    fun savedSearches(): SavedSearchesResources

    /** A wrapper of [twitter4j.Twitter.placesGeo] */
    fun placesGeo(): PlacesGeoResources

    /** A wrapper of [twitter4j.Twitter.trends] */
    fun trends(): TrendsResources

    /** A wrapper of [twitter4j.Twitter.spamReporting] */
    fun spamReporting(): SpamReportingResource

    /** A wrapper of [twitter4j.Twitter.help] */
    fun help(): HelpResources

    /** A builder of [Twitter] instance. */
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
