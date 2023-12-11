plugins {
    kotlin("jvm") version "1.9.20" apply false
    id("com.bennyhuo.kotlin.plugin.embeddable.test") version "1.8.1" apply false
}

allprojects {
    pluginManager.withPlugin("java") {
        extensions.getByType<JavaPluginExtension>().sourceCompatibility = JavaVersion.VERSION_1_8
    }
}