plugins {
    kotlin("jvm") version "1.9.20" apply false
    id("com.bennyhuo.kotlin.plugin.embeddable.test") version "1.8.1" apply false
    id("maven-publish")
    signing

}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

group = "cn.llonvne"
version = "0.0.1"

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "cn.llonvne"
            artifactId = "PropertiesCopy"
            version = "0.0.1"

            pom {
                name = "PropertiesCopy"
                description = "Copy Properties From Class to Class"

                licenses {
                    name = "MIT"
                    url = "https://github.com/Llonvne/PropertiesCopy/blob/main/LICENSE"
                }

                developers {
                    developer {
                        id = "llonvne"
                        name = "llonvne"
                        email = "Llonvne@gmail.com"
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/llonvne/PropertiesCopy.git")
                    developerConnection.set("scm:git:ssh://github.com:llonvne/PropertiesCopy.git")
                    url.set("https://github.com/llonvne/PropertiesCopy")
                }
            }
        }
    }
    repositories {
        maven {
            name = "PropertiesCopy"
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            setUrl { snapshotRepoUrl }
        }
    }
}

//signing {
//    signing {
//        useInMemoryPgpKeys(
//            System.getProperty("GPG_PRIVATE_KEY"),
//            System.getProperty("GPG_PRIVATE_PASSWORD")
//        )
//        sign(publishing.publications)
//    }
//}

allprojects {
    pluginManager.withPlugin("java") {
        extensions.getByType<JavaPluginExtension>().sourceCompatibility = JavaVersion.VERSION_1_8
    }
}

