plugins {
    id(BuildPlugins.ANDROID_LIBRARY_COMMON)
}

dependencies {
    implementation(project(Modules.CORE_LIB))

    api(TestLibraries.JUNIT)
    api(TestLibraries.MOCKK)
}