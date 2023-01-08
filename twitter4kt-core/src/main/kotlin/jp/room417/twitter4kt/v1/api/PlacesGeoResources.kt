package jp.room417.twitter4kt.v1.api

import twitter4j.*
import twitter4j.v1.*

/** A wrapper of [twitter4j.v1.PlacesGeoResources] */
interface PlacesGeoResources {
    /** A wrapper of [twitter4j.v1.PlacesGeoResources.getGeoDetails] */
    @Throws(TwitterException::class)
    suspend fun getGeoDetails(placeId: String): Place

    /** A wrapper of [twitter4j.v1.PlacesGeoResources.reverseGeoCode] */
    @Throws(TwitterException::class)
    suspend fun reverseGeoCode(query: GeoQuery): ResponseList<Place>

    /** A wrapper of [twitter4j.v1.PlacesGeoResources.searchPlaces] */
    @Throws(TwitterException::class)
    suspend fun searchPlaces(query: GeoQuery): ResponseList<Place>
}
