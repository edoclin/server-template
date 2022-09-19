import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "server.template"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    maven {setUrl("https://maven.aliyun.com/nexus/content/groups/public")}
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")
    implementation("cn.dev33:sa-token-spring-boot-starter:1.31.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("mysql:mysql-connector-java")


    implementation("cn.hutool:hutool-all:5.8.6")
    implementation("redis.clients:jedis:4.2.3")
    implementation("cn.dev33:sa-token-jwt:1.31.0")
    implementation("com.baomidou:mybatis-plus-generator:3.5.2")
    implementation("org.freemarker:freemarker:2.3.31")

    implementation("com.qcloud:cos_api:5.6.103")
    implementation("com.qcloud:cos-sts_api:3.1.1")
//    implementation("com.tencentcloudapi:tencentcloud-sdk-java:4.0.11")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<org.springframework.boot.gradle.plugin.ResolveMainClassName> {

}
