package jp.room417.twitter4kt.v1

import jp.room417.twitter4kt.v1.api.*

/** A wrapper of [twitter4j.v1.TwitterV1] */
interface TwitterV1 {
    /** A wrapper of [twitter4j.v1.TwitterV1.timelines] */
    fun timelines(): TimelinesResources

    /** A wrapper of [twitter4j.v1.TwitterV1.tweets] */
    fun tweets(): TweetsResources

    /** A wrapper of [twitter4j.v1.TwitterV1.search] */
    fun search(): SearchResource

    /** A wrapper of [twitter4j.v1.TwitterV1.directMessages] */
    fun directMessages(): DirectMessagesResources

    /** A wrapper of [twitter4j.v1.TwitterV1.friendsFollowers] */
    fun friendsFollowers(): FriendsFollowersResources

    /** A wrapper of [twitter4j.v1.TwitterV1.users] */
    fun users(): UsersResources

    /** A wrapper of [twitter4j.v1.TwitterV1.favorites] */
    fun favorites(): FavoritesResources

    /** A wrapper of [twitter4j.v1.TwitterV1.list] */
    fun list(): ListsResources

    /** A wrapper of [twitter4j.v1.TwitterV1.savedSearches] */
    fun savedSearches(): SavedSearchesResources

    /** A wrapper of [twitter4j.v1.TwitterV1.placesGeo] */
    fun placesGeo(): PlacesGeoResources

    /** A wrapper of [twitter4j.v1.TwitterV1.trends] */
    fun trends(): TrendsResources

    /** A wrapper of [twitter4j.v1.TwitterV1.spamReporting] */
    fun spamReporting(): SpamReportingResource

    /** A wrapper of [twitter4j.v1.TwitterV1.help] */
    fun help(): HelpResources
}
