rootProject.name = "TabooLib"
include("common", "common-env", "common-util", "common-legacy-api", "common-reflex", "common-platform-api")
include(
    // 基础工具
    "module:basic:basic-configuration",
    "module:basic:basic-submit-chain",

    // 针对 Bukkit 平台的常规工具
    "module:bukkit:bukkit-fake-op",
    "module:bukkit:bukkit-hook",
    "module:bukkit:bukkit-ui",
    "module:bukkit:bukkit-util",
    "module:bukkit:bukkit-xseries",

    // 针对 Bukkit 平台的 NMS 工具
    "module:bukkit-nms",
    "module:bukkit-nms:bukkit-nms-stable",
    "module:bukkit-nms:bukkit-nms-tag",
    "module:bukkit-nms:bukkit-nms-tag:bukkit-nms-tag-modern",

    // 针对 Minecraft 的多平台工具
    "module:minecraft:minecraft-chat",
    "module:minecraft:minecraft-i18n",
    "module:minecraft:minecraft-metrics",

    // 字节码切术
    "module:incision"
)
include(
    "platform:platform-bukkit",
    "platform:platform-bukkit-impl"
)
