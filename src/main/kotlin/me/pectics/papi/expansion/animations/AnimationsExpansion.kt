package me.pectics.papi.expansion.animations

import me.clip.placeholderapi.expansion.Configurable
import me.clip.placeholderapi.expansion.PlaceholderExpansion
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer

@Suppress("unused")
class AnimationsExpansion : PlaceholderExpansion(), Configurable {

    override fun getIdentifier(): String {
        return "anim"
    }

    override fun getAuthor(): String {
        return "Pectics"
    }

    override fun getVersion(): String {
        return BuildConfig.VERSION
    }

    override fun getRequiredPlugin(): String {
        return "PexilLibs"
    }

    override fun canRegister(): Boolean {
        return Bukkit.getPluginManager().getPlugin(requiredPlugin) != null
    }

    override fun onRequest(ignored: OfflinePlayer?, params: String): String? {
        val args = params.split("_", limit = 2)
        if (args.isEmpty()) return null
        return when (args[0].lowercase()) {
            "chaos" -> chaos(getDouble("chaos.probability", CHAOS_PROBABILITY))
            else -> null
        }
    }

    override fun getDefaults(): Map<String?, Any?>? {
        return mapOf(
            "minimessage_format" to true,
            "chaos.probability" to CHAOS_PROBABILITY
        )
    }

}