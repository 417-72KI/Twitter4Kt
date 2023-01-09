package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.SavedSearchesResources] */
interface SavedSearchesResources {
    /** A wrapper of [twitter4j.v1.SavedSearchesResources.getSavedSearches] */
    @Throws(TwitterException::class)
    suspend fun getSavedSearches(): ResponseList<SavedSearch>

    /** A wrapper of [twitter4j.v1.SavedSearchesResources.showSavedSearch] */
    @Throws(TwitterException::class)
    suspend fun showSavedSearch(id: Long): SavedSearch

    /** A wrapper of [twitter4j.v1.SavedSearchesResources.createSavedSearch] */
    @Throws(TwitterException::class)
    suspend fun createSavedSearch(query: String): SavedSearch

    /** A wrapper of [twitter4j.v1.SavedSearchesResources.destroySavedSearch] */
    @Throws(TwitterException::class)
    suspend fun destroySavedSearch(id: Long): SavedSearch
}
