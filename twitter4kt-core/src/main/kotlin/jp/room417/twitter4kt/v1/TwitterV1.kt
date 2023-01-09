package jp.room417.twitter4kt.v1

import jp.room417.twitter4kt.v1.api.*

interface TwitterV1 {
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
    @Suppress("DEPRECATION")
    @Deprecated(
        message = "Deprecated from Twitter and will be removed on Twitter4j 4.1.0.\nSee https://twittercommunity.com/t/upcoming-changes-to-user-object-and-get-users-suggestions-endpoints/124732",
        level = DeprecationLevel.WARNING
    )
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
}
