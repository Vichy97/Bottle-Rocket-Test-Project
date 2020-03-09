plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:4.0.0-beta01")
}

gradlePlugin {
    plugins {
        register("AndroidLibraryCommon") {
            id = "androidLibraryCommon"
            implementationClass = "plugin.AndroidLibraryCommon"
        }
        register("AndroidApplicationCommon") {
            id = "androidApplicationCommon"
            implementationClass = "plugin.AndroidApplicationCommon"
        }
    }
}