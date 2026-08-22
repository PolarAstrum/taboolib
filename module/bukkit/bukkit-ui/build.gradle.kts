dependencies {
    compileOnly(project(":common"))
    compileOnly(project(":common-util"))
    compileOnly(project(":common-platform-api"))
    compileOnly(project(":module:minecraft:minecraft-chat"))
    compileOnly(project(":module:bukkit-nms"))
    compileOnly(project(":module:bukkit:bukkit-util"))
    compileOnly(project(":platform:platform-bukkit-impl"))
    compileOnly(project(":platform:platform-bukkit"))
    // 服务端
    compileOnly("ink.ptms.core:v12104:12104-minimize:mapped")
    compileOnly("ink.ptms.core:v260100:260100-minimize")
}