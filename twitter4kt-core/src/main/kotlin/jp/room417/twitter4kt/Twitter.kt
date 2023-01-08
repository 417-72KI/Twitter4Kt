package jp.room417.twitter4kt

import jp.room417.twitter4kt.api.*
import jp.room417.twitter4kt.auth.Authorization
import jp.room417.twitter4kt.auth.OAuthSupport
import jp.room417.twitter4kt.internal.TwitterImpl
import jp.room417.twitter4kt.util.letWith
import jp.room417.twitter4kt.v1.TwitterV1
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken

/** A wrapper of [twitter4j.Twitter] */
@Suppress("DEPRECATION")
interface Twitter : OAuthSupport {
    /** If an api that you want to use has not been wrapped yet, you can call the original api from here. */
    @Deprecated(
        message = "All apis in `twitter4j` is supported now. This will be removed in future.",
        level = DeprecationLevel.WARNING
    )
    val origin: twitter4j.Twitter

    /** A wrapper of [twitter4j.Twitter.getAuthorization] */
    val authorization: Authorization

    /** An interface for v1.1 apis. */
    val v1: TwitterV1

    /** A wrapper of [twitter4j.Twitter.timelines] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.timelines()"))
    fun timelines(): TimelinesResources

    /** A wrapper of [twitter4j.Twitter.tweets] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.tweets()"))
    fun tweets(): TweetsResources

    /** A wrapper of [twitter4j.Twitter.search] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.search()"))
    fun search(): SearchResource

    /** A wrapper of [twitter4j.Twitter.directMessages] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.directMessages()"))
    fun directMessages(): DirectMessagesResources

    /** A wrapper of [twitter4j.Twitter.friendsFollowers] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.friendsFollowers()"))
    fun friendsFollowers(): FriendsFollowersResources

    /** A wrapper of [twitter4j.Twitter.users] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.users()"))
    fun users(): UsersResources

    /** A wrapper of [twitter4j.Twitter.suggestedUsers] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.suggestedUsers()"))
    fun suggestedUsers(): SuggestedUsersResources

    /** A wrapper of [twitter4j.Twitter.favorites] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.favorites()"))
    fun favorites(): FavoritesResources

    /** A wrapper of [twitter4j.Twitter.list] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.list()"))
    fun list(): ListsResources

    /** A wrapper of [twitter4j.Twitter.savedSearches] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.savedSearches()"))
    fun savedSearches(): SavedSearchesResources

    /** A wrapper of [twitter4j.Twitter.placesGeo] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.placesGeo()"))
    fun placesGeo(): PlacesGeoResources

    /** A wrapper of [twitter4j.Twitter.trends] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.trends()"))
    fun trends(): TrendsResources

    /** A wrapper of [twitter4j.Twitter.spamReporting] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.spamReporting()"))
    fun spamReporting(): SpamReportingResource

    /** A wrapper of [twitter4j.Twitter.help] */
    @Deprecated(message = "Moved to `v1`", replaceWith = ReplaceWith("v1.help()"))
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
