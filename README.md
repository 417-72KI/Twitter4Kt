# Twitter4Kt
![publish](https://github.com/417-72KI/Twitter4Kt/actions/workflows/publish.yml/badge.svg)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.417-72ki/twitter4kt/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/io.github.417-72ki/twitter4kt)

Twitter4Kt is a wrapper for [`Twitter4J`](https://github.com/Twitter4J/Twitter4J) to support Kotlin Coroutines.

## Motivation

All of the functions in `Twitter4J` are synchronous, and it may cause crash on GUI(Especially Android) apps.  
Twitter4Kt wraps some of Twitter4J functions with `suspend` and use `Dispatchers.IO` to execute Twitter's apis.

If using Twitter4Kt instead of Twitter4J directly, you needs no more calling Twitter's apis with `withContext` in coroutines.

### Before

```kotlin
scope.launch {
    prepare()
    withContext(Dispatchers.IO) {
        try {
            twitter.updateStatus(text)
            withContext(Dispatchers.Main) {
                onSuccess()
            }
        } catch (e: TwitterException) {
            withContext(Dispatchers.Main) {
                onError()
            }
        } finally {
            withContext(Dispatchers.Main) {
                onFinally()
            }
        }
    }
}
```

### After

```kotlin
scope.launch {
    prepare()
    try {
        twitter.updateStatus(text)
        onSuccess()
    } catch (e: TwitterException) {
        onError()
    } finally {
        onFinally()
    }
}
```

## Installation

### Gradle(Groovy)
#### >= `v0.1.0`
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.417-72ki:twitter4kt:0.2.0'
}
```

### Gradle(Kotlin)
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.417-72ki:twitter4kt:0.2.0")
}
```

## Usage example

```kotlin
val twitter = Twitter.Builder()
    .setOAuthConsumer("consumer key", "consumer secret")
    .setOAuthAccessToken("access token", "access token secret")
    .build()
scope.launch {
    twitter.updateStatus("Hello world!")
}
```

## License

[Apache License Version 2.0](https://github.com/417-72KI/Twitter4Kt/blob/master/LICENSE)

## Author

[417-72KI](https://github.com/417-72KI)
