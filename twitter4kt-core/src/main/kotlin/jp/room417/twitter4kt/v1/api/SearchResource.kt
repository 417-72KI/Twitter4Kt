package jp.room417.twitter4kt.v1.api

import twitter4j.Query
import twitter4j.QueryResult
import twitter4j.TwitterException

/** A wrapper of [twitter4j.api.SearchResource] */
interface SearchResource {
    /** A wrapper of [twitter4j.api.SearchResource.search] */
    @Throws(TwitterException::class)
    suspend fun search(query: Query): QueryResult
}
