package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.TrendsResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.*

internal class TrendsResourcesImpl(private val twitter: Twitter) : TrendsResources {
    override suspend fun getPlaceTrends(woeid: Int): Trends = withContext(Dispatchers.IO) {
        twitter.getPlaceTrends(woeid)
    }

    override suspend fun getAvailableTrends(): ResponseList<Location> = withContext(Dispatchers.IO) {
        twitter.availableTrends
    }

    override suspend fun getClosestTrends(location: GeoLocation): ResponseList<Location> = withContext(Dispatchers.IO) {
        twitter.getClosestTrends(location)
    }
}
