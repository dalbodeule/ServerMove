package space.mori.servermove.bungee

import org.bukkit.plugin.java.JavaPlugin

class ServerMove : JavaPlugin()  {
    companion object {
        lateinit var instance: ServerMove
    }

    override fun onEnable() {
        this.logger.info("plugin enabled")

    }

    override fun onDisable() {
        this.logger.info("plugin disabled")
    }
}