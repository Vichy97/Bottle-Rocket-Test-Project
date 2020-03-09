plugins {
    id(BuildPlugins.ANDROID_LIBRARY_COMMON)
    kotlin(BuildPlugins.KAPT)
}

dependencies {
    implementation(project(Modules.CORE_LIB))

    implementation(Libraries.MOSHI)
    implementation(Libraries.RETROFIT)
    implementation(Libraries.RETROFIT_MOSHI_CONVERTER)
    implementation(Libraries.RETROFIT_RX_JAVA_ADAPTER)
}