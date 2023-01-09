package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.PlacesGeoResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.*

internal class PlacesGeoResourcesImpl(private val twitter: Twitter) : PlacesGeoResources {
    override suspend fun getGeoDetails(placeId: String): Place = withContext(Dispatchers.IO) {
        twitter.getGeoDetails(placeId)
    }

    override suspend fun reverseGeoCode(query: GeoQuery): ResponseList<Place> = withContext(Dispatchers.IO) {
        twitter.reverseGeoCode(query)
    }

    override suspend fun searchPlaces(query: GeoQuery): ResponseList<Place> = withContext(Dispatchers.IO) {
        twitter.searchPlaces(query)
    }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override suspend fun getSimilarPlaces(
        location: GeoLocation,
        name: String,
        containedWithin: String,
        streetAddress: String
    ): ResponseList<Place> = withContext(Dispatchers.IO) {
        twitter.getSimilarPlaces(location, name, containedWithin, streetAddress)
    }
}
