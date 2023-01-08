package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.SearchResource] */
interface SearchResource {
    /** A wrapper of [twitter4j.v1.SearchResource.search] */
    @Throws(TwitterException::class)
    suspend fun search(query: Query): QueryResult
}
