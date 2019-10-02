package space.mori.servermove.bungee.commands

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.Command

class testCommand : Command("testcommand") {
    override fun execute(sender: CommandSender?, args: Array<out String>?) {
        if (sender is ProxiedPlayer) {
            sender.sendMessage(TextComponent("${ChatColor.GREEN}Hello world!"))
        }
    }
}
