package <package>;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.text.DecimalFormat;

public class SchedulerAPI {

    private static Plugin instance;

    public static boolean onEnable(Plugin plugin) {
        instance = plugin;

        return (instance != null);
    }

    public static void onDisable() {
        instance = null;
    }

    @SuppressWarnings("deprecation")
    public static int scheduleDelayedTask(Runnable runnable, boolean sync) {

        if (!sync) {
            return Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(instance, runnable);
        } else {
            return Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(instance, runnable);
        }
    }

    @SuppressWarnings("deprecation")
    public static int scheduleDelayedTask(Runnable runnable) {

        return Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(instance, runnable);
    }

    @SuppressWarnings("deprecation")
    public static int scheduleDelayedTask(Runnable runnable, boolean sync, double delay) {

        if (!sync) {
            return Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(instance, runnable, (long) round(delay) * 20L);
        } else {
            return Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(instance, runnable, (long) round(delay) * 20L);
        }
    }

    @SuppressWarnings("deprecation")
    public static int scheduleDelayedTask(Runnable runnable, double delay) {

        return Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(instance, runnable, (long) round(delay) * 20L);
    }

    @SuppressWarnings("deprecation")
    public static int scheduleRepeatingTask(Runnable runnable, boolean sync, double interval) {

        if (!sync) {
            return Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(instance, runnable, 0L, (long) round(interval) * 20L);
        } else {
            return Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(instance, runnable, 0L, (long) round(interval) * 20L);
        }
    }

    @SuppressWarnings("deprecation")
    public static int scheduleRepeatingTask(Runnable runnable, double interval) {
        return Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(instance, runnable, 0L, (long) round(interval) * 20L);
    }

    @SuppressWarnings("deprecation")
    public static int scheduleRepeatingTask(Runnable runnable, boolean sync, double interval, double delay) {

        if (!sync) {
            return Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(instance, runnable, (long) round(delay) * 20L, (long) round(interval) * 20L);
        } else {
            return Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(instance, runnable, (long) round(delay) * 20L, (long) round(interval) * 20L);
        }
    }

    @SuppressWarnings("deprecation")
    public static int scheduleRepeatingTask(Runnable runnable, double interval, double delay) {

        return Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(instance, runnable, (long) round(delay) * 20L, (long) round(interval) * 20L);
    }

    public static void cancelTask(int taskID) {

        Bukkit.getServer().getScheduler().cancelTask(taskID);
    }

    private static double round(double d) {

        DecimalFormat twoDForm = new DecimalFormat("#.#");
        return Double.valueOf(twoDForm.format(d));
    }
}
