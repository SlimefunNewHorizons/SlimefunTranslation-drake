plugins {
    java
    id("com.gradleup.shadow") version "9.4.1"
    id("de.eldoria.plugin-yml.bukkit") version "0.8.0"
}

version = "11.0-Universal-26.x-SNAPSHOT"

repositories {
    maven("https://pack.drakescraft.cl/builds/maven/")
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.2.build.129-stable")
    compileOnly("com.github.drakescraft_labs:slimefun-core:11.0-Universal-26.x-SNAPSHOT")
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    compileOnly("org.projectlombok:lombok:1.18.46")
    annotationProcessor("org.projectlombok:lombok:1.18.46")

    compileOnly("me.clip:placeholderapi:2.11.6")
    // 5.4+: mapeo 1.21.4+ (HashedStack en WINDOW_CLICK). En el servidor usar ProtocolLib ≥5.4.0.
    compileOnly("net.dmulloy2:ProtocolLib:5.4.0")
    implementation("net.guizhanss:guizhanlib-all:2.2.0")
    implementation("org.bstats:bstats-bukkit:3.1.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.named<Jar>("jar") {
    enabled = false
}

tasks.build { dependsOn(tasks.shadowJar) }

tasks.shadowJar {
    relocate("net.guizhanss.guizhanlib", "com.github.drakescraft_labs.slimefuntranslation.libs.guizhanlib")
    relocate("org.bstats", "com.github.drakescraft_labs.slimefuntranslation.libs.bstats")
    archiveFileName.set("SlimefunTranslation-11.0-Universal-26.x-SNAPSHOT.jar")
    // minimize() eliminaba clases de GuizhanLib → NoClassDefFoundError AbstractAddon en runtime
}

bukkit {
    main = "com.github.drakescraft_labs.slimefuntranslation.SlimefunTranslation"
    apiVersion = "1.21"
    authors = listOf("ybw0014")
    description = "A Slimefun Addon that translates items without actually modifying the items. DrakesLab Edition."
    depend = listOf("Slimefun", "ProtocolLib", "PlaceholderAPI")

    commands {
        register("sftranslation") {
            description = "SlimefunTranslation command"
            aliases = listOf("slimefuntranslation", "sft", "sftr", "sftransl")
        }
    }
}
