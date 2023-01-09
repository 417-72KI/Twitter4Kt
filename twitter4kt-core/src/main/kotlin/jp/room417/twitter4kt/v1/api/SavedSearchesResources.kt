package jp.room417.twitter4kt.v1.api

import twitter4j.ResponseList
import twitter4j.SavedSearch
import twitter4j.TwitterException

/** A wrapper of [twitter4j.api.SavedSearchesResources] */
interface SavedSearchesResources {
    /** A wrapper of [twitter4j.api.SavedSearchesResources.getSavedSearches] */
    @Throws(TwitterException::class)
    suspend fun getSavedSearches(): ResponseList<SavedSearch>

    /** A wrapper of [twitter4j.api.SavedSearchesResources.showSavedSearch] */
    @Throws(TwitterException::class)
    suspend fun showSavedSearch(id: Long): SavedSearch

    /** A wrapper of [twitter4j.api.SavedSearchesResources.createSavedSearch] */
    @Throws(TwitterException::class)
    suspend fun createSavedSearch(query: String): SavedSearch

    /** A wrapper of [twitter4j.api.SavedSearchesResources.destroySavedSearch] */
    @Throws(TwitterException::class)
    suspend fun destroySavedSearch(id: Long): SavedSearch
}
