package space.mori.servermove.bungee.commands

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Command

class testMoveCommand : Command("testmove") {
    override fun execute(sender: CommandSender?, args: Array<out String>?) {
        if(sender is ProxiedPlayer) {
            if(sender.server.info.name == args?.get(0)) {
                sender.sendMessage(TextComponent("${ChatColor.RED}Already connected server"))
            } else {
                val target = ProxyServer.getInstance().getServerInfo(args?.get(0))
                sender.connect(target)
            }
        }
    }
}