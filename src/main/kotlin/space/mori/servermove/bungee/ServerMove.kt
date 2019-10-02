package space.mori.servermove.bungee

import net.md_5.bungee.api.plugin.Plugin

import space.mori.servermove.bungee.commands.testCommand
import space.mori.servermove.bungee.commands.testMoveCommand

class ServerMove : Plugin()  {
    companion object {
        lateinit var instance: ServerMove
    }

    override fun onEnable() {
        this.logger.info("plugin enabled")

        this.proxy.pluginManager.registerCommand(this, testCommand())
        this.proxy.pluginManager.registerCommand(this, testMoveCommand())
    }

    override fun onDisable() {
        this.logger.info("plugin disabled")
    }
}