package space.mori.servermove

import com.google.common.io.ByteStreams
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.messaging.PluginMessageListener
import space.mori.servermove.commands.testCommand
import space.mori.servermove.commands.testMoveCommand

class ServerMove : JavaPlugin(), PluginMessageListener {
    companion object {
        lateinit var instance: ServerMove
    }

    override fun onEnable() {
        this.logger.info("plugin enabled")

        this.server.messenger.registerOutgoingPluginChannel(this, "BungeeCord")
        this.server.messenger.registerIncomingPluginChannel(this, "BungeeCord", this)

        this.getCommand("test")?.setExecutor(testCommand)
        this.getCommand("testmove")?.setExecutor(testMoveCommand)
    }

    override fun onPluginMessageReceived(channel: String, player: Player, message: ByteArray) {
        if (channel === "BungeeCord") {
            val data = ByteStreams.newDataInput(message)
            val subchannel = data.readUTF()

            if (subchannel == "GetServers") {
                val playerList = data.readUTF()
                this.logger.info(playerList)
            }
        }
    }

    override fun onDisable() {
        this.logger.info("plugin disabled")
    }
}