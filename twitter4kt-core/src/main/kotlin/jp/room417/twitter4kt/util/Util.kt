package jp.room417.twitter4kt.util

internal inline fun <T1, T2, R> T1.letWith(other: T2?, action: (T1, T2) -> R): R? =
    other?.let { action(this, other) }
