plugins {
    kotlin("jvm") version "1.9.21"
    `maven-publish`
}

group = "com.ndgndg91"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "com.github.ndgndg91"
            artifactId = "hello-jitpack"
            version = "0.0.1"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.assertj:assertj-core:3.25.1")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}