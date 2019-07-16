import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.41"
}

group = "com.epam.epm-d4j.petclinic-demo-autotest"
version = "1.0-SNAPSHOT"

val jUnitVersion = "5.4.0"
val restAssuredVersion = "4.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testCompile("io.rest-assured:rest-assured:$restAssuredVersion")
    testImplementation("io.rest-assured:rest-assured:$restAssuredVersion")
    testCompile("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.named<Test>("test") {
    val agentPath = System.getProperty("agentPath")
    val adminUrl = System.getProperty("admin.url")
    val adminId = System.getProperty("agent.id")
    setJvmArgs(listOf("-javaagent:$agentPath=adminUrl=$adminUrl,agentId=$adminId"))
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}