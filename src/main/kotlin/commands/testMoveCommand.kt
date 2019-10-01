package space.mori.servermove.commands

import com.google.common.io.ByteStreams
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ProxiedCommandSender
import space.mori.servermove.ServerMove

object testMoveCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player = sender as ProxiedCommandSender

        if (player.server.name == args[0]) {
            sender.sendMessage("already connected server")
        } else {
            val playerInBukkit = Bukkit.getPlayer(sender.name)

            var out = ByteStreams.newDataOutput()
            out.writeUTF("GetServers")
            playerInBukkit?.sendPluginMessage(ServerMove.instance, "BungeeCord", out.toByteArray())


            if (false) {

            } else {
                out = ByteStreams.newDataOutput()
                out.writeUTF("Connect")
                out.writeUTF(args[0])

                playerInBukkit?.sendPluginMessage(ServerMove.instance, "BungeeCord", out.toByteArray())
            }
        }

        return true
    }
}