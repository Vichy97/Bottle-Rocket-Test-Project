plugins {
    id(BuildPlugins.ANDROID_LIBRARY_COMMON)
    kotlin(BuildPlugins.KAPT)
}

dependencies {
    implementation(project(Modules.CORE_LIB))
    implementation(project(Modules.NETWORK))
}
