package taboolib.module.nms

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.event.entity.CreatureSpawnEvent
import taboolib.common.util.unsafeLazy
import java.util.function.Consumer

/**
 *  在坐标处中生成实体，并在生成前执行回调函数
 */
fun <T : Entity> Location.spawnEntity(entity: Class<T>, randomizeData: Boolean = false, prepare: Consumer<T> = Consumer { }): T {
    return NMSEntity.instance.spawnEntity(this, entity, randomizeData, prepare)
}

/**
 * TabooLib
 * taboolib.module.nms.NMSEntity
 *
 * @author 坏黑
 * @since 2023/8/5 03:47
 */
abstract class NMSEntity {

    /** 在坐标处中生成实体，并在生成前执行回调函数 */
    abstract fun <T : Entity> spawnEntity(location: Location, entity: Class<T>, randomizeData: Boolean, callback: Consumer<T>): T

    companion object {

        val instance by unsafeLazy { nmsProxy<NMSEntity>() }
    }
}

// region NMSEntityImpl
class NMSEntityImpl : NMSEntity() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : Entity> spawnEntity(location: Location, entity: Class<T>, randomizeData: Boolean, callback: Consumer<T>): T {
        return if (MinecraftVersion.isHigherOrEqual(MinecraftVersion.V1_20)) {
            location.world?.spawn(location, entity, randomizeData) { callback.accept(it) } ?: error("world is null")
        } else {
            val craftWorld = location.world as org.bukkit.craftbukkit.v1_12_R1.CraftWorld
            val nmsEntity = craftWorld.createEntity(location, entity)
            try {
                callback.accept(nmsEntity.bukkitEntity as T)
            } catch (ex: Throwable) {
                ex.printStackTrace()
            }
            craftWorld.addEntity(nmsEntity, CreatureSpawnEvent.SpawnReason.CUSTOM)
        }
    }
}
// endregion