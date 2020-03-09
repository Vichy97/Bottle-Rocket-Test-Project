plugins {
    id(BuildPlugins.ANDROID_APPLICATION_COMMON)
}

android {
    buildTypes {
        all {
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(Modules.CORE_LIB))
    implementation(project(Modules.CORE_UI))
    implementation(project(Modules.UTIL))
    implementation(project(Modules.NETWORK))
    implementation(project(Modules.DATA))
    implementation(project(Modules.UI))

    implementation(Libraries.AndroidX.APP_COMPAT)

    testImplementation(project(Modules.CORE_TEST))

    debugImplementation(DebugLibraries.LEAK_CANARY)
}