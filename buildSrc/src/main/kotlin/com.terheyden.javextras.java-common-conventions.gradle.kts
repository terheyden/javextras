/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Apply the java Plugin to add support for Java.
    java
    // For importing JARs and docs into the IDE.
    idea
}

////////////////////////////////////////
// Properties:

// Confirmed that these do propagate to subprojects:
group = "com.terheyden.javextras"

// https://stackoverflow.com/questions/52401740/how-to-efficiently-populate-extra-properties-in-the-gradle-kotlin-dsl
// another way to set an extra:
//   val jdkVersion by extra("8")
//   extra.set("jdkVersion", "8")
//   extra["jdkVersion"] = "8"

extra.apply {
    set("jdkVersion", "8")
}

// How to read extra props:
//   val jdkVersion = project.extra["jdkVersion"] as String
//   val jdkVersion = project.extra.get("jdkVersion") as String
val jdkVersion = project.extra.get("jdkVersion") as String

dependencies {

    ////////////////////////////////////////
    // Must-have dependencies:

    ///////////////////////////////////////
    // Unit testing

    // Use JUnit Jupiter (API and engine) for testing.
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    // Fluent assertions
    // https://joel-costigliola.github.io/assertj/assertj-core-quick-start.html
    // https://mvnrepository.com/artifact/org.assertj/assertj-core
    testImplementation("org.assertj:assertj-core:3.24.2")
    // Mocking; https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:5.5.0")
    // Adds @ExtendWith support; https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
    testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

// Confirmed that these do propagate to subprojects:
java {
    // Create JARs with sources and javadocs attached.
    // https://docs.gradle.org/current/userguide/java_plugin.html
    withJavadocJar()
    withSourcesJar()

    // Preferred way to specify Java version.
    // https://docs.gradle.org/current/userguide/java_plugin.html
    // https://docs.gradle.org/current/userguide/toolchains.html
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(jdkVersion))
    }
}

// Confirmed that these do propagate to subprojects:
// Download sources and docs for dependencies in IntelliJ IDEA.
// https://stackoverflow.com/questions/28404149
// To run: ./gradlew cleanIdea idea
idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

////////////////////////////////////////
// Testing and Coverage

tasks.test {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}