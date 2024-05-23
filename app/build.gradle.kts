plugins {
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass = "com.dhanush.App"
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "com.dhanush.App"
    }
}
