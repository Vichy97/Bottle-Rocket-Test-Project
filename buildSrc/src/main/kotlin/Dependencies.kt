const val KOTLIN_VERSION = "1.3.61"

object BuildPlugins {

    private object Versions {
        const val GRADLE_BUILD_TOOLS = "4.0.0-beta01"
    }

    const val ANDROID_GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE_BUILD_TOOLS}"
    const val KOTLIN_GRADLE= "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"

    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"

    const val KAPT = "kapt"

    const val ANDROID_LIBRARY_COMMON = "androidLibraryCommon"
    const val ANDROID_APPLICATION_COMMON = "androidApplicationCommon"
}

object Libraries {

    private object Versions {
        const val MOSHI = "1.9.2"
        const val MATERIAL = "1.2.0-alpha02"
        const val TIMBER = "4.7.1"
        const val RETROFIT = "2.6.2"
        const val RX_JAVA = "2.1.1"
        const val PICASSO = "2.71828"
        const val KOIN = "2.1.3"
        const val GOOGLE_MAPS = "17.0.0"
    }

    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$KOTLIN_VERSION"
    const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val RX_JAVA = "io.reactivex.rxjava2:rxandroid:${Versions.RX_JAVA}"
    const val PICASSO = "com.squareup.picasso:picasso:${Versions.PICASSO}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
    const val RETROFIT_RX_JAVA_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"

    const val KOIN_ANDROID = "org.koin:koin-android:${Versions.KOIN}"
    const val KOIN_VIEW_MODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"

    const val GOOGLE_MAPS = "com.google.android.gms:play-services-maps:${Versions.GOOGLE_MAPS}"

    object AndroidX {

        private object Versions {
            const val CORE_KTX = "1.1.0"
            const val APP_COMPAT = "1.1.0"
            const val FRAGMENT = "1.2.0-rc02"
            const val NAVIGATION = "2.3.0-alpha03"
            const val CONSTRAINT_LAYOUT = "2.0.0-beta4"
            const val SWIPE_REFRESH_LAYOUT = "1.0.0"
            const val RECYCLER_VIEW = "1.1.0"
            const val CARD_VIEW = "1.0.0"
        }

        const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
        const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"

        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val SWIPE_REFRESH_LAYOUT = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
        const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
        const val CARD_VIEW = "androidx.cardview:cardview:${Versions.CARD_VIEW}"
    }
}

object TestLibraries {

    private object Versions {
        const val JUNIT = "4.12"
        const val MOCKK = "1.9.3"
    }

    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
}

object DebugLibraries {

    private object Versions {
        const val LEAK_CANARY = "2.0-beta-2"
    }

    const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAK_CANARY}"
}

object Modules {

    const val APP = ":app"
    const val CORE_LIB = ":core-lib"
    const val CORE_UI = ":core-ui"
    const val CORE_TEST = ":core-test"
    const val UTIL = ":util"
    const val NETWORK = ":network"
    const val DATA = ":data"
    const val UI = ":ui"
}