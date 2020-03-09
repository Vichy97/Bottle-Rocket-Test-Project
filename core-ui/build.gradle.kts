plugins {
    id(BuildPlugins.ANDROID_LIBRARY_COMMON)
}

dependencies {
    implementation(project(Modules.CORE_LIB))
    implementation(project(Modules.UTIL))

    implementation(Libraries.AndroidX.FRAGMENT)

    api(Libraries.AndroidX.NAVIGATION_FRAGMENT)
    api(Libraries.AndroidX.NAVIGATION_UI)
    api(Libraries.AndroidX.CONSTRAINT_LAYOUT)
    api(Libraries.AndroidX.SWIPE_REFRESH_LAYOUT)
    api(Libraries.AndroidX.RECYCLER_VIEW)
    api(Libraries.AndroidX.CARD_VIEW)
    api(Libraries.MATERIAL)
    api(Libraries.PICASSO)
}