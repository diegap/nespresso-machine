import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    idea
    kotlin("jvm") version "1.3.31"
    id("org.jlleitschuh.gradle.ktlint") version "6.3.1" apply false
}

repositories {
    mavenCentral()
    jcenter()
}

allprojects {
    group = "trainning.nespresso.machine"
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
        jcenter()
    }

    val spekVersion = "2.0.5"
    val arrowVersion = "0.8.2"
    val assertJVersion = "3.11.1"

    dependencies{
        compile(kotlin("stdlib-jdk8"))
        compile(kotlin("reflect"))
        compile("io.arrow-kt:arrow-core:$arrowVersion")
        testCompile(kotlin("test"))
        testCompile("org.assertj:assertj-core:$assertJVersion")

        testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion") {
            exclude(group = "org.jetbrains.kotlin")
        }
        testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion") {
            exclude(group = "org.junit.platform")
            exclude(group = "org.jetbrains.kotlin")
        }

        testImplementation(group = "org.junit.platform", name = "junit-platform-engine", version = "1.3.0")
    }

    tasks {
        withType<Test> {
            useJUnitPlatform {
                includeEngines("spek2")
            }
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}



buildscript {
    repositories {
        jcenter()
    }
}
