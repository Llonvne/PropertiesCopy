import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
}

dependencies {
    compileOnly(projects.copyAnno)
    ksp(projects.copyKsp)
}

repositories {
    mavenCentral()
}


group = "cn.llonvne"
version = "unspecified"

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"