package minevalley.core.api;

import com.google.gson.Gson;
import lombok.NonNull;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.database.DatabaseEntry;
import minevalley.core.api.database.DatabaseEntryCollection;
import minevalley.core.api.database.DatabaseTable;
import minevalley.core.api.database.Value;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.enums.DebugType;
import minevalley.core.api.misc.Weather;
import minevalley.core.api.modulepipeline.Container;
import minevalley.core.api.modulepipeline.PipelineReceiver;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.regions.*;
import minevalley.core.api.timing.Reminder;
import minevalley.core.api.timing.RepeatingTimer;
import minevalley.core.api.timing.Timer;
import minevalley.core.api.utils.*;
import minevalley.core.api.utils.command.PlayerCommand;
import minevalley.core.api.utils.gui.GuiBuilder;
import minevalley.core.api.utils.gui.GuiItem;
import minevalley.smart.api.SmartApp;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import org.apache.logging.log4j.util.TriConsumer;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.sql.ResultSet;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface CoreServer {

    int scheduleSyncRepeatingTask(long delay, long period, BukkitRunnable runnable);

    int scheduleSyncRepeatingTask(long delay, long period, Runnable runnable);

    int scheduleAsyncRepeatingTask(long delay, long period, Runnable runnable);

    int scheduleSyncDelayedTask(long delay, BukkitRunnable runnable);

    int scheduleSyncDelayedTask(long delay, Runnable runnable);

    int scheduleSyncDelayedTask(BukkitRunnable runnable);

    int scheduleSyncDelayedTask(Runnable runnable);

    int scheduleAsyncDelayedTask(long delay, Runnable runnable);

    int scheduleAsyncDelayedTask(Runnable runnable);


    BukkitTask runTask(Runnable runnable);

    BukkitTask runTaskAsync(Runnable runnable);


    BukkitTask runTaskTimer(long delay, long period, BukkitRunnable runnable);

    BukkitTask runTaskTimer(long delay, long period, Runnable runnable);

    BukkitTask runTaskTimerAsync(long delay, long period, BukkitRunnable runnable);

    BukkitTask runTaskTimerAsync(long delay, long period, Runnable runnable);


    BukkitTask runTaskLater(long delay, BukkitRunnable runnable);

    BukkitTask runTaskLater(long delay, Runnable runnable);

    BukkitTask runTaskLaterAsync(long delay, BukkitRunnable runnable);

    BukkitTask runTaskLaterAsync(long delay, Runnable runnable);


    boolean isCurrentlyRunning(int taskId);

    void cancelTask(int taskId);

    JavaPlugin getInstance();

    void registerEvent(Class<? extends Event> cls, EventListener listener);

    void unregisterEvent(Class<? extends Event> cls, EventListener listener);

    void registerListeners(Listener listener);

    void registerPipelineReceiver(PipelineReceiver pipeLineManager);

    void sendPipelineContainer(String pipelineName, Container container);

    void registerCommand(PlayerCommand command);

    void sendTeamChatMessage(String message);

    void sendTeamChatMessage(BaseComponent[] message);

    void sendDebug(DebugType type, String message);

    DatabaseEntry getDatabaseEntry(String tableName, ResultSet resultSet, int index);

    DatabaseEntry getDatabaseEntry(String tableName, Value searchValue);

    DatabaseEntryCollection getDatabaseEntryCollection(String tableName, List<DatabaseEntry> entries);

    DatabaseEntryCollection getDatabaseEntryCollection(String tableName, Value searchValue);

    DatabaseTable getDatabaseTable(String tableName);

    void setSetting(String key, String value);

    String getSetting(String key);

    void updateStatistic(String key, double value);

    double getStatistic(String key);

    User getUser(String uuid);

    OnlineUser getOnlineUser(Player player);

    ClickEvent createClickEvent(boolean selfCancelling, Consumer<OnlineUser> callback);

    ClickableMessage createClickableMessage();

    ClickableMessage createClickableMessage(Consumer<OnlineUser> callback);

    ClickableMessage createClickableMessage(Consumer<OnlineUser> callback, boolean selfCancelling);

    ChatMenu createChatMenu(ChatMenu.Option... options);

    ChatMenu createChatMenu();

    void setMetadata(Metadatable metadatable, String key, Object value);

    void removeMetadata(Metadatable metadatable, String key);

    List<MetadataValue> getMetadata(Metadatable metadatable, String key);

    Gson getGson();

    String getName(String uniqueId);

    String getUniqueId(String name);

    String removeColorCodes(String text);

    String convertColorCodes(String text);

    int randomInteger(int chars);

    boolean isInteger(String string);

    boolean isDouble(String string);

    String formatMoney(double amount);

    String formatRelativeTimestamp(long time);

    Weather getWeather();

    Weather[] getUpcomingWeather();

    GuiBuilder createGui(Inventory inventory);

    GuiBuilder createGui(int size);

    GuiBuilder createGui(List<GuiItem> items, int size, String title, Core.PosItem... posItems);

    GuiItem createGuiItem(ItemStack itemStack, Consumer<OnlineUser> consumer);

    GuiItem createAdvancedGuiItem(ItemStack itemStack, BiConsumer<OnlineUser, ClickType> consumer);

    GuiItem createAdvancedGuiItem(ItemStack itemStack, TriConsumer<OnlineUser, ClickType, Inventory> consumer);

    Countdown createCountdown();

    void startCountdown(Countdown countdown);

    void stopCountdown(Countdown countdown);

    ItemBuilder createItem(ItemStack itemStack);

    ItemBuilder createItem(Material material);

    ItemBuilder createItem(Material material, int data);

    ItemBuilder createItem(Player player);

    ItemBuilder createItem(UUID uniqueId);

    ItemBuilder createItem(String url);

    ItemBuilder createItem(String value, String signature);

    Inventory getInventoryFromString(String inventory);

    String getStringFromInventory(Inventory inventory);

    BankAccount getBankAccount(String iban);

    BankAccount createBankAccount(Registrant holder);

    Group getGroup(String name);

    Region getRegion(int id);

    Region createRegion(List<Area> areas);

    List<Region> getRegions(Block block);

    Residence getResidence(int id);

    Residence getResidence(Region region);

    Plot createPlot(Region region, Street street, Registrant owner, int fertility, Sign plotSign, Block mailboxBlock,
                    Area mailboxConnectedBlocks, Location teleportLocation);

    Apartment createApartment(Region region, Registrant landlord, int fertility, int rent, Sign apartmentSign,
                              Block mailbox);

    Apartment createApartment(Region region, ApartmentBlock block, int rent, Sign apartmentSign, Block mailbox);

    ApartmentBlock createApartmentBlock(Street street, Location teleportLocation, Registrant landlord, int fertility,
                                        Block mailboxBlock, Area mailboxConnectedBlocks, Sign apartmentBlockSign,
                                        Sign bellSign, int maxFloors, int defaultFloor, Area defaultFloorShadow,
                                        List<Area> roofShadows, Area constructionFloorShadow, Vector constructionWorkerLocation,
                                        List<Location> craftsmanLocations, Block[] damagedFloorBlocks);

    ApartmentBlock createApartmentBlock(Street street, Location teleportLocation, Registrant landlord, int fertility,
                                        Block mailboxBlock, Area mailboxConnectedBlocks, Sign apartmentBlockSign,
                                        Sign bellSign, int floors, List<Location> craftsmanLocations, Block[] damagedFloorBlocks);

    List<Residence> getLoadedResidences();

    List<Street> getStreets();

    Street getStreet(int id);

    Street createStreet(String name, String description);

    District getDistrict(int id);

    District getDistrict(Chunk chunk);

    List<District> getDistricts();

    RadioMast createRadioMast(String name, Block location, int range);

    RadioMast getNearestRadioMast(Location location);

    Area getAreaFromString(String rawArea);

    Area getArea(Block loc1, Block loc2);

    void transferFromShadow(Area... areas);

    void loadPreset(Area presetArea, Block presetPivot, Block mainWorldPivot);

    void restartAndClean();

    FakeBlock createFakeBlock(Block block, Material material, int data);

    boolean containsForForbiddenWords(String string);

    Telephone getTelephone(String telephoneNumber);

    Registrant getRegistrant(String string);

    Boundary createBoundary(@NonNull Location anchorPoint, @NonNull Location pullPoint, @NonNull Consumer<PlayerInteractEvent> callback);

    Boundary createBoundary(@NonNull Location anchorPoint, @NonNull Vector vector, @NonNull Consumer<PlayerInteractEvent> callback);

    Timer startTimer(int delay, @NonNull Runnable callback);

    RepeatingTimer startRepeatingTimer(int period, @NonNull Runnable callback);

    Reminder createReminder(int hours, int minutes, @NonNull Runnable callback, DayOfWeek... weekdays);

    Reminder createReminder(int hours, int minutes, @NonNull Runnable callback, List<DayOfWeek> weekdays);

    Webhook createWebhook(String url);

    Webhook.EmbeddedMessage createEmbeddedMessage();

    boolean isMaintenance();

    NPC createNPC(UUID skinUniqueId, String name, Location location, boolean focusNearPlayers, boolean visibleToEveryone);

    NPC createNPC(UUID skinUniqueId, UUID uniqueId, String name, Location location, boolean focusNearPlayers, boolean visibleToEveryone);

    NPC createNPC(String value, String signature, String name, Location location, boolean focusNearPlayers, boolean visibleToEveryone);

    void registerSmartApp(SmartApp app);

    List<SmartApp> getSmartApps();

    List<OnlineUser> getOnlineUsers();

    CarBarrier createCarBarrier(Location loc, int rotation, List<Block> barrierBlocks);

    Hologram createHologram(Location loc, boolean visibleToEveryone, String... lines);

    String itemStackToString(ItemStack itemStack);

    ItemStack itemStackFromString(String itemStack);

    String locationToString(Location location);

    Location locationFromString(String location);

    String blockToString(Block block);

    Block blockFromString(String block);

}