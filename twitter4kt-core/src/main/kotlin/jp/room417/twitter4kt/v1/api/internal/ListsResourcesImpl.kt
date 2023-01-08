package jp.room417.twitter4kt.v1.api.internal

import jp.room417.twitter4kt.v1.api.ListsResources
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.v1.*

internal class ListsResourcesImpl(private val list: twitter4j.v1.ListsResources) : ListsResources {

    override suspend fun getUserLists(listOwnerScreenName: String): ResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserLists(listOwnerScreenName)
        }

    override suspend fun getUserLists(listOwnerScreenName: String, reverse: Boolean): ResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserLists(listOwnerScreenName, reverse)
        }

    override suspend fun getUserLists(listOwnerUserId: Long): ResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserLists(listOwnerUserId)
    }

    override suspend fun getUserLists(listOwnerUserId: Long, reverse: Boolean): ResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserLists(listOwnerUserId, reverse)
        }

    override suspend fun getUserListStatuses(listId: Long, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            list.getUserListStatuses(listId, paging)
        }

    override suspend fun getUserListStatuses(ownerId: Long, slug: String, paging: Paging): ResponseList<Status> =
        withContext(Dispatchers.IO) {
            list.getUserListStatuses(ownerId, slug, paging)
        }

    override suspend fun getUserListStatuses(
        ownerScreenName: String,
        slug: String,
        paging: Paging
    ): ResponseList<Status> = withContext(Dispatchers.IO) {
        list.getUserListStatuses(ownerScreenName, slug, paging)
    }

    override suspend fun destroyUserListMember(listId: Long, userId: Long): UserList = withContext(Dispatchers.IO) {
        list.destroyUserListMember(listId, userId)
    }

    override suspend fun destroyUserListMember(listId: Long, screenName: String): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListMember(listId, screenName)
        }

    override suspend fun destroyUserListMembers(listId: Long, screenNames: Array<String>): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListMembers(listId, screenNames)
        }

    override suspend fun destroyUserListMembers(listId: Long, userIds: LongArray): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListMembers(listId, userIds)
        }

    override suspend fun destroyUserListMembers(
        ownerScreenName: String,
        slug: String,
        screenNames: Array<String>
    ): UserList = withContext(Dispatchers.IO) {
        list.destroyUserListMembers(ownerScreenName, slug, screenNames)
    }

    override suspend fun destroyUserListMember(ownerId: Long, slug: String, userId: Long): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListMember(ownerId, slug, userId)
        }

    override suspend fun destroyUserListMember(ownerScreenName: String, slug: String, userId: Long): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListMember(ownerScreenName, slug, userId)
        }

    override suspend fun getUserListMemberships(cursor: Long): PagableResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserListMemberships(cursor)
        }

    override suspend fun getUserListMemberships(count: Int, cursor: Long): PagableResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserListMemberships(count, cursor)
        }

    override suspend fun getUserListMemberships(listMemberId: Long, cursor: Long): PagableResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserListMemberships(listMemberId, cursor)
        }

    override suspend fun getUserListMemberships(
        listMemberId: Long,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberId, count, cursor)
    }

    override suspend fun getUserListMemberships(
        listMemberScreenName: String,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberScreenName, cursor)
    }

    override suspend fun getUserListMemberships(
        listMemberScreenName: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberScreenName, count, cursor)
    }

    override suspend fun getUserListMemberships(
        listMemberScreenName: String,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberScreenName, cursor, filterToOwnedLists)
    }

    override suspend fun getUserListMemberships(
        listMemberScreenName: String,
        count: Int,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberScreenName, count, cursor, filterToOwnedLists)
    }

    override suspend fun getUserListMemberships(
        listMemberId: Long,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberId, cursor, filterToOwnedLists)
    }

    override suspend fun getUserListMemberships(
        listMemberId: Long,
        count: Int,
        cursor: Long,
        filterToOwnedLists: Boolean
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListMemberships(listMemberId, count, cursor, filterToOwnedLists)
    }

    override suspend fun getUserListSubscribers(listId: Long, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            list.getUserListSubscribers(listId, cursor)
        }

    override suspend fun getUserListSubscribers(listId: Long, count: Int, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            list.getUserListSubscribers(listId, count, cursor)
        }

    override suspend fun getUserListSubscribers(
        listId: Long,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListSubscribers(listId, count, cursor, skipStatus)
    }

    override suspend fun getUserListSubscribers(ownerId: Long, slug: String, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            list.getUserListSubscribers(ownerId, slug, cursor)
        }

    override suspend fun getUserListSubscribers(
        ownerId: Long,
        slug: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListSubscribers(ownerId, slug, count, cursor)
    }

    override suspend fun getUserListSubscribers(
        ownerId: Long,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListSubscribers(ownerId, slug, count, cursor, skipStatus)
    }

    override suspend fun getUserListSubscribers(
        ownerScreenName: String,
        slug: String,
        cursor: Long
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListSubscribers(ownerScreenName, slug, cursor)
    }

    override suspend fun getUserListSubscribers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListSubscribers(ownerScreenName, slug, count, cursor)
    }

    override suspend fun getUserListSubscribers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListSubscribers(ownerScreenName, slug, count, cursor, skipStatus)
    }

    override suspend fun createUserListSubscription(listId: Long): UserList = withContext(Dispatchers.IO) {
        list.createUserListSubscription(listId)
    }

    override suspend fun createUserListSubscription(ownerId: Long, slug: String): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListSubscription(ownerId, slug)
        }

    override suspend fun createUserListSubscription(ownerScreenName: String, slug: String): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListSubscription(ownerScreenName, slug)
        }

    override suspend fun showUserListSubscription(listId: Long, userId: Long): User = withContext(Dispatchers.IO) {
        list.showUserListSubscription(listId, userId)
    }

    override suspend fun showUserListSubscription(ownerId: Long, slug: String, userId: Long): User =
        withContext(Dispatchers.IO) {
            list.showUserListSubscription(ownerId, slug, userId)
        }

    override suspend fun showUserListSubscription(ownerScreenName: String, slug: String, userId: Long): User =
        withContext(Dispatchers.IO) {
            list.showUserListSubscription(ownerScreenName, slug, userId)
        }

    override suspend fun destroyUserListSubscription(listId: Long): UserList = withContext(Dispatchers.IO) {
        list.destroyUserListSubscription(listId)
    }

    override suspend fun destroyUserListSubscription(ownerId: Long, slug: String): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListSubscription(ownerId, slug)
        }

    override suspend fun destroyUserListSubscription(ownerScreenName: String, slug: String): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserListSubscription(ownerScreenName, slug)
        }

    override suspend fun createUserListMembers(listId: Long, vararg userIds: Long): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListMembers(listId, *userIds)
        }

    override suspend fun createUserListMembers(ownerId: Long, slug: String, vararg userIds: Long): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListMembers(ownerId, slug, *userIds)
        }

    override suspend fun createUserListMembers(ownerScreenName: String, slug: String, vararg userIds: Long): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListMembers(ownerScreenName, slug, *userIds)
        }

    override suspend fun createUserListMembers(listId: Long, vararg screenNames: String): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListMembers(listId, *screenNames)
        }

    @Suppress("OVERRIDE_DEPRECATION", "OverridingDeprecatedMember")
    override suspend fun createUserListMembers(ownerId: Long, slug: String, vararg screenNames: String): UserList =
        TODO("The original function causes compile error with `Overload resolution ambiguity` and no solution in Kotlin.")
    //  withContext(Dispatchers.IO) {
    //      list.createUserListMembers(ownerId, slug, *screenNames)
    //  }

    override suspend fun createUserListMembers(
        ownerScreenName: String,
        slug: String,
        vararg screenNames: String
    ): UserList = withContext(Dispatchers.IO) {
        list.createUserListMembers(ownerScreenName, slug, *screenNames)
    }

    override suspend fun showUserListMembership(listId: Long, userId: Long): User = withContext(Dispatchers.IO) {
        list.showUserListMembership(listId, userId)
    }

    override suspend fun showUserListMembership(ownerId: Long, slug: String, userId: Long): User =
        withContext(Dispatchers.IO) {
            list.showUserListMembership(ownerId, slug, userId)
        }

    override suspend fun showUserListMembership(ownerScreenName: String, slug: String, userId: Long): User =
        withContext(Dispatchers.IO) {
            list.showUserListMembership(ownerScreenName, slug, userId)
        }

    override suspend fun getUserListMembers(listId: Long, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            list.getUserListMembers(listId, cursor)
        }

    override suspend fun getUserListMembers(listId: Long, count: Int, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            list.getUserListMembers(listId, count, cursor)
        }

    override suspend fun getUserListMembers(
        listId: Long,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListMembers(listId, count, cursor, skipStatus)
    }

    override suspend fun getUserListMembers(ownerId: Long, slug: String, cursor: Long): PagableResponseList<User> =
        withContext(Dispatchers.IO) {
            list.getUserListMembers(ownerId, slug, cursor)
        }

    override suspend fun getUserListMembers(
        ownerId: Long,
        slug: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListMembers(ownerId, slug, count, cursor)
    }

    override suspend fun getUserListMembers(
        ownerId: Long,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListMembers(ownerId, slug, count, cursor, skipStatus)
    }

    override suspend fun getUserListMembers(
        ownerScreenName: String,
        slug: String,
        cursor: Long
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListMembers(ownerScreenName, slug, cursor)
    }

    override suspend fun getUserListMembers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListMembers(ownerScreenName, slug, count, cursor)
    }

    override suspend fun getUserListMembers(
        ownerScreenName: String,
        slug: String,
        count: Int,
        cursor: Long,
        skipStatus: Boolean
    ): PagableResponseList<User> = withContext(Dispatchers.IO) {
        list.getUserListMembers(ownerScreenName, slug, count, cursor, skipStatus)
    }

    override suspend fun createUserListMember(listId: Long, userId: Long): UserList = withContext(Dispatchers.IO) {
        list.createUserListMember(listId, userId)
    }

    override suspend fun createUserListMember(ownerId: Long, slug: String, userId: Long): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListMember(ownerId, slug, userId)
        }

    override suspend fun createUserListMember(ownerScreenName: String, slug: String, userId: Long): UserList =
        withContext(Dispatchers.IO) {
            list.createUserListMember(ownerScreenName, slug, userId)
        }

    override suspend fun destroyUserList(listId: Long): UserList = withContext(Dispatchers.IO) {
        list.destroyUserList(listId)
    }

    override suspend fun destroyUserList(ownerId: Long, slug: String): UserList = withContext(Dispatchers.IO) {
        list.destroyUserList(ownerId, slug)
    }

    override suspend fun destroyUserList(ownerScreenName: String, slug: String): UserList =
        withContext(Dispatchers.IO) {
            list.destroyUserList(ownerScreenName, slug)
        }

    override suspend fun updateUserList(
        listId: Long,
        newListName: String,
        isPublicList: Boolean,
        newDescription: String
    ): UserList = withContext(Dispatchers.IO) {
        list.updateUserList(listId, newListName, isPublicList, newDescription)
    }

    override suspend fun updateUserList(
        ownerId: Long,
        slug: String,
        newListName: String,
        isPublicList: Boolean,
        newDescription: String
    ): UserList = withContext(Dispatchers.IO) {
        list.updateUserList(ownerId, slug, newListName, isPublicList, newDescription)
    }

    override suspend fun updateUserList(
        ownerScreenName: String,
        slug: String,
        newListName: String,
        isPublicList: Boolean,
        newDescription: String
    ): UserList = withContext(Dispatchers.IO) {
        list.updateUserList(ownerScreenName, slug, newListName, isPublicList, newDescription)
    }

    override suspend fun createUserList(listName: String, isPublicList: Boolean, description: String): UserList =
        withContext(Dispatchers.IO) {
            list.createUserList(listName, isPublicList, description)
        }

    override suspend fun showUserList(listId: Long): UserList = withContext(Dispatchers.IO) {
        list.showUserList(listId)
    }

    override suspend fun showUserList(ownerId: Long, slug: String): UserList = withContext(Dispatchers.IO) {
        list.showUserList(ownerId, slug)
    }

    override suspend fun showUserList(ownerScreenName: String, slug: String): UserList = withContext(Dispatchers.IO) {
        list.showUserList(ownerScreenName, slug)
    }

    override suspend fun getUserListSubscriptions(
        listSubscriberScreenName: String,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListSubscriptions(listSubscriberScreenName, cursor)
    }

    override suspend fun getUserListSubscriptions(
        listSubscriberScreenName: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListSubscriptions(listSubscriberScreenName, count, cursor)
    }

    override suspend fun getUserListSubscriptions(listSubscriberId: Long, cursor: Long): PagableResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserListSubscriptions(listSubscriberId, cursor)
        }

    override suspend fun getUserListSubscriptions(
        listSubscriberId: Long,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListSubscriptions(listSubscriberId, count, cursor)
    }

    override suspend fun getUserListsOwnerships(
        listOwnerScreenName: String,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListsOwnerships(listOwnerScreenName, cursor)
    }

    override suspend fun getUserListsOwnerships(
        listOwnerScreenName: String,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListsOwnerships(listOwnerScreenName, count, cursor)
    }

    override suspend fun getUserListsOwnerships(listOwnerId: Long, cursor: Long): PagableResponseList<UserList> =
        withContext(Dispatchers.IO) {
            list.getUserListsOwnerships(listOwnerId, cursor)
        }

    override suspend fun getUserListsOwnerships(
        listOwnerId: Long,
        count: Int,
        cursor: Long
    ): PagableResponseList<UserList> = withContext(Dispatchers.IO) {
        list.getUserListsOwnerships(listOwnerId, count, cursor)
    }
}
