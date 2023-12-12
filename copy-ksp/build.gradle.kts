import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")

    id("com.bennyhuo.kotlin.plugin.embeddable.test")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":copy-anno"))
    implementation("com.google.devtools.ksp:symbol-processing-api:1.8.10-1.0.9")
    implementation("com.squareup:kotlinpoet-ksp:1.12.0")
    testImplementation(kotlin("test-junit"))
    testImplementation("com.bennyhuo.kotlin:kotlin-compile-testing-extensions:1.9.20-1.3.0")
    testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable")
}

group = "cn.llonvne"
version = "unspecified"

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = listOf(
            "-Xopt-in=com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview",
            "-Xopt-in=com.google.devtools.ksp.KspExperimental",
            "-Xcontext-receivers"
        )
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "1.8"