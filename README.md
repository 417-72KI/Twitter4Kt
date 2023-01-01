# Twitter4Kt

Twitter4Kt is a wrapper for [`Twitter4J`](https://github.com/Twitter4J/Twitter4J) to support Kotlin Coroutines.

## Motivation

All of the functions in `Twitter4J` are synchronous, and it may cause crash on GUI(Especially Android) apps.  
Twitter4Kt wraps some of Twitter4J functions with `suspend` and use `Dispatchers.IO` to execute Twitter's apis.

If using Twitter4Kt instead of Twitter4J directly, you needs no more calling Twitter's apis with `withContext` in coroutines.

### Before

```kotlin
viewModelScope.launch {
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
viewModelScope.launch {
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

#### top-level `build.gradle`

```groovy
allprojects {
    repositories {
        ・ ・ ・
        maven {
            url 'https://maven.pkg.github.com/417-72KI/Twitter4Kt'
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_USER")
                password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
```

#### `app/build.gradle`

```groovy
dependencies {
    implementation 'jp.room417:twitter4kt:0.0.1'
}
```

### Gradle(Kotlin)

TBD

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
