package jp.room417.twitter4kt.api

import twitter4j.*

/** A wrapper of [twitter4j.api.ListsResources] */
interface ListsResources {
    /** A wrapper of [twitter4j.api.ListsResources.getUserLists] */
    suspend fun getUserLists(listOwnerScreenName: String): ResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserLists] */
    suspend fun getUserLists(listOwnerScreenName: String, reverse: Boolean): ResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserLists] */
    suspend fun getUserLists(listOwnerUserId: Long): ResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserLists] */
    suspend fun getUserLists(listOwnerUserId: Long, reverse: Boolean): ResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListStatuses] */
    suspend fun getUserListStatuses(listId: Long, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListStatuses] */
    suspend fun getUserListStatuses(ownerId: Long, slug: String, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListStatuses] */
    suspend fun getUserListStatuses(ownerScreenName: String, slug: String, paging: Paging): ResponseList<Status>

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMember] */
    suspend fun destroyUserListMember(listId: Long, userId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMember] */
    suspend fun destroyUserListMember(listId: Long, screenName: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMembers] */
    suspend fun destroyUserListMembers(listId: Long, screenNames: Array<String>): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMembers] */
    suspend fun destroyUserListMembers(listId: Long, userIds: LongArray): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMembers] */
    suspend fun destroyUserListMembers(ownerScreenName: String, slug: String, screenNames: Array<String>): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMember] */
    suspend fun destroyUserListMember(ownerId: Long, slug: String, userId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListMember] */
    suspend fun destroyUserListMember(ownerScreenName: String, slug: String, userId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(count: Int, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(listMemberId: Long, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(listMemberId: Long, count: Int, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(listMemberScreenName: String, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(
        listMemberScreenName: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(
        listMemberScreenName: String,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(
        listMemberScreenName: String,
        count: Int,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(
        listMemberId: Long,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMemberships] */
    suspend fun getUserListMemberships(
        listMemberId: Long,
        count: Int,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(listId: Long, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(listId: Long, count: Int, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(
        listId: Long,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(ownerId: Long, slug: String, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(ownerId: Long, slug: String, count: Int, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(
        ownerId: Long,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(ownerScreenName: String, slug: String, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscribers] */
    suspend fun getUserListSubscribers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.createUserListSubscription] */
    suspend fun createUserListSubscription(listId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListSubscription] */
    suspend fun createUserListSubscription(ownerId: Long, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListSubscription] */
    suspend fun createUserListSubscription(ownerScreenName: String, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.showUserListSubscription] */
    suspend fun showUserListSubscription(listId: Long, userId: Long): User

    /** A wrapper of [twitter4j.api.ListsResources.showUserListSubscription] */
    suspend fun showUserListSubscription(ownerId: Long, slug: String, userId: Long): User

    /** A wrapper of [twitter4j.api.ListsResources.showUserListSubscription] */
    suspend fun showUserListSubscription(ownerScreenName: String, slug: String, userId: Long): User

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListSubscription] */
    suspend fun destroyUserListSubscription(listId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListSubscription] */
    suspend fun destroyUserListSubscription(ownerId: Long, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserListSubscription] */
    suspend fun destroyUserListSubscription(ownerScreenName: String, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMembers] */
    suspend fun createUserListMembers(listId: Long, vararg userIds: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMembers] */
    suspend fun createUserListMembers(ownerId: Long, slug: String, vararg userIds: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMembers] */
    suspend fun createUserListMembers(ownerScreenName: String, slug: String, vararg userIds: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMembers] */
    suspend fun createUserListMembers(listId: Long, vararg screenNames: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMembers] */
    @Deprecated(
        message = "The original function causes compile error with `Overload resolution ambiguity` and no solution in Kotlin.",
        level = DeprecationLevel.HIDDEN
    )
    suspend fun createUserListMembers(ownerId: Long, slug: String, vararg screenNames: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMembers] */
    suspend fun createUserListMembers(ownerScreenName: String, slug: String, vararg screenNames: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.showUserListMembership] */
    suspend fun showUserListMembership(listId: Long, userId: Long): User

    /** A wrapper of [twitter4j.api.ListsResources.showUserListMembership] */
    suspend fun showUserListMembership(ownerId: Long, slug: String, userId: Long): User

    /** A wrapper of [twitter4j.api.ListsResources.showUserListMembership] */
    suspend fun showUserListMembership(ownerScreenName: String, slug: String, userId: Long): User

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(listId: Long, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(listId: Long, count: Int, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(
        listId: Long,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(ownerId: Long, slug: String, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(ownerId: Long, slug: String, count: Int, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(
        ownerId: Long,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(ownerScreenName: String, slug: String, cursor: Long): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListMembers] */
    suspend fun getUserListMembers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User>

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMember] */
    suspend fun createUserListMember(listId: Long, userId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMember] */
    suspend fun createUserListMember(ownerId: Long, slug: String, userId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserListMember] */
    suspend fun createUserListMember(ownerScreenName: String, slug: String, userId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserList] */
    suspend fun destroyUserList(listId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserList] */
    suspend fun destroyUserList(ownerId: Long, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.destroyUserList] */
    suspend fun destroyUserList(ownerScreenName: String, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.updateUserList] */
    suspend fun updateUserList(
        listId: Long,
        newListName: String,
        isPublicList: Boolean,
        newDescription: String
    ): UserList

    /** A wrapper of [twitter4j.api.ListsResources.updateUserList] */
    suspend fun updateUserList(
        ownerId: Long,
        slug: String,
        newListName: String,
        isPublicList: Boolean,
        newDescription: String
    ): UserList

    /** A wrapper of [twitter4j.api.ListsResources.updateUserList] */
    suspend fun updateUserList(
        ownerScreenName: String,
        slug: String,
        newListName: String,
        isPublicList: Boolean,
        newDescription: String
    ): UserList

    /** A wrapper of [twitter4j.api.ListsResources.createUserList] */
    suspend fun createUserList(listName: String, isPublicList: Boolean, description: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.showUserList] */
    suspend fun showUserList(listId: Long): UserList

    /** A wrapper of [twitter4j.api.ListsResources.showUserList] */
    suspend fun showUserList(ownerId: Long, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.showUserList] */
    suspend fun showUserList(ownerScreenName: String, slug: String): UserList

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscriptions] */
    suspend fun getUserListSubscriptions(listSubscriberScreenName: String, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscriptions] */
    suspend fun getUserListSubscriptions(
        listSubscriberScreenName: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscriptions] */
    suspend fun getUserListSubscriptions(listSubscriberId: Long, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListSubscriptions] */
    suspend fun getUserListSubscriptions(
        listSubscriberId: Long,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListsOwnerships] */
    suspend fun getUserListsOwnerships(listOwnerScreenName: String, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListsOwnerships] */
    suspend fun getUserListsOwnerships(
        listOwnerScreenName: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListsOwnerships] */
    suspend fun getUserListsOwnerships(listOwnerId: Long, cursor: Long): PagableResponseList<UserList>

    /** A wrapper of [twitter4j.api.ListsResources.getUserListsOwnerships] */
    suspend fun getUserListsOwnerships(listOwnerId: Long, count: Int, cursor: Long): PagableResponseList<UserList>
}
