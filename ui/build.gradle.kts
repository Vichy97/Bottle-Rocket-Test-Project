plugins {
    id(BuildPlugins.ANDROID_LIBRARY_COMMON)
}

dependencies {
    implementation(project(Modules.CORE_LIB))
    implementation(project(Modules.CORE_UI))
    implementation(project(Modules.DATA))
    implementation(project(Modules.UTIL))
    implementation(Libraries.GOOGLE_MAPS)

    testImplementation(project(Modules.CORE_TEST))
}
