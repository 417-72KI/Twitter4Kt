package jp.room417.twitter4kt.api

import twitter4j.Category
import twitter4j.ResponseList
import twitter4j.TwitterException
import twitter4j.User

/** A wrapper of [twitter4j.api.SuggestedUsersResources] */
@Deprecated(
    message = "Deprecated from Twitter and will be removed on Twitter4j 4.1.0.\nSee https://twittercommunity.com/t/upcoming-changes-to-user-object-and-get-users-suggestions-endpoints/124732",
    level = DeprecationLevel.WARNING
)
interface SuggestedUsersResources {
    /** A wrapper of [twitter4j.api.SuggestedUsersResources.getUserSuggestions] */
    @Throws(TwitterException::class)
    suspend fun getUserSuggestions(categorySlug: String): ResponseList<User>

    /** A wrapper of [twitter4j.api.SuggestedUsersResources.getSuggestedUserCategories] */
    @Throws(TwitterException::class)
    suspend fun getSuggestedUserCategories(): ResponseList<Category>

    /** A wrapper of [twitter4j.api.SuggestedUsersResources.getMemberSuggestions] */
    @Throws(TwitterException::class)
    suspend fun getMemberSuggestions(categorySlug: String): ResponseList<User>
}
