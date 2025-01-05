package minevalley.core.api;

import com.google.gson.Gson;
import minevalley.core.api.armorstand.FakeArmorStand;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.companies.*;
import minevalley.core.api.database.StatementBuilder;
import minevalley.core.api.discord.EmbeddedMessage;
import minevalley.core.api.discord.Webhook;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.enums.DebugType;
import minevalley.core.api.enums.Server;
import minevalley.core.api.gui.GuiBuilder;
import minevalley.core.api.gui.GuiItem;
import minevalley.core.api.gui.MultiPageGui;
import minevalley.core.api.npc.NPC;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.regions.Region;
import minevalley.core.api.regions.residences.Apartment;
import minevalley.core.api.regions.residences.ApartmentBlock;
import minevalley.core.api.regions.residences.Plot;
import minevalley.core.api.regions.residences.Residence;
import minevalley.core.api.regions.structures.District;
import minevalley.core.api.regions.structures.RadioMast;
import minevalley.core.api.regions.structures.Street;
import minevalley.core.api.regions.utils.Area;
import minevalley.core.api.regions.utils.Boundary;
import minevalley.core.api.regions.utils.FakeBlock;
import minevalley.core.api.timing.Reminder;
import minevalley.core.api.timing.RepeatingTimer;
import minevalley.core.api.timing.Timer;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.utils.CarBarrier;
import minevalley.core.api.utils.EventListener;
import minevalley.core.api.utils.Hologram;
import minevalley.core.api.utils.ItemBuilder;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@ApiStatus.Internal
public interface CoreServer {

    @Nonnull
    JavaPlugin getInstance();

    @Nonnull
    BukkitTask runSyncTaskLater(long delay, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runAsyncTaskLater(long delay, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runSyncTaskPeriodically(long delay, long period, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    BukkitTask runAsyncTaskPeriodically(long delay, long period, @Nonnull Runnable runnable) throws IllegalArgumentException;

    @Nonnull
    StatementBuilder prepareSQL(@Nonnull @Language("SQL") String sql, boolean retrieveGeneratedKeys) throws SQLException;

    int generateUniqueId(@Nonnull String table, @Nonnull String column, int amountOfChars) throws IllegalArgumentException, SQLException;

    void registerListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener) throws IllegalArgumentException;

    void unregisterListener(@Nonnull Class<? extends Event> cls, @Nonnull EventListener<? extends Event> listener) throws IllegalArgumentException;

    void registerListener(@Nonnull Listener listener) throws IllegalArgumentException;

    void callEvent(@Nonnull Event event) throws IllegalArgumentException;

    @Nullable
    User getUser(@Nullable UUID uuid);

    @Nonnull
    OnlineUser getOnlineUser(@Nonnull Player player);

    @Nullable
    String getName(@Nullable UUID uniqueId);

    @Nullable
    UUID getUniqueId(@Nullable String name);

    void sendTeamChatMessage(@Nonnull String message);

    @Deprecated
    void sendTeamChatMessage(@Nonnull BaseComponent[] message);

    void sendDebug(@Nonnull DebugType type, @Nonnull String message);

    void setSetting(@Nonnull String key, @Nonnull String value) throws IllegalArgumentException;

    String getSetting(String key);

    void updateStatistic(@Nonnull String key, double value) throws IllegalArgumentException;

    double getStatistic(@Nonnull String key) throws IllegalArgumentException;

    @Nullable
    String removeColorCodes(@Nullable String text);

    @Nullable
    String convertColorCodes(@Nullable String text);

    boolean containsForForbiddenWords(@Nullable String string);

    @Nonnull
    Gson getGson();

    int getRandomInteger(int chars) throws IllegalArgumentException;

    boolean isInteger(@Nullable String string);

    boolean isDouble(@Nullable String string);

    @Nonnull
    String formatMoney(int amountInCents);

    @Nonnull
    String formatRelativeTimestamp(long time);

    @Nonnull
    GuiBuilder createGui(int size) throws IllegalArgumentException;

    @Nonnull
    MultiPageGui createMultiPageGui(int size) throws IllegalArgumentException;

    GuiItem createGuiItem(@Nonnull ItemStack itemStack, @Nullable Consumer<OnlineUser> consumer);

    GuiItem createAdvancedGuiItem(@Nonnull ItemStack itemStack, @Nullable BiConsumer<OnlineUser, InventoryClickEvent> callback);

    @Nonnull
    World getMainWorld();

    @Nonnull
    World getBuildingWorld() throws IllegalStateException;

    @Nonnull
    World getPresetsWorld() throws IllegalStateException;

    void loadPreset(@Nonnull Area presetArea, @Nonnull Block presetPivot, @Nonnull Block mainWorldPivot) throws IllegalArgumentException;

    void restartAndClean();

    @Nonnull
    FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material, int data) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(@Nonnull Material material) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(@Nonnull Material material, int data) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(@Nonnull Player player) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(@Nonnull UUID uniqueId) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(@Nonnull String value, @Nonnull String signature) throws IllegalArgumentException;

    @Nonnull
    ItemBuilder createItem(String url) throws IllegalArgumentException;

    ChatMenu createChatMenu(ChatMenu.Option... options);

    ChatMenu createChatMenu();

    @Nonnull
    Inventory getInventoryFromString(@Nonnull String inventory) throws IllegalArgumentException;

    @Nonnull
    String getStringFromInventory(@Nonnull Inventory inventory) throws IllegalArgumentException;

    @Nullable
    BankAccount getBankAccount(@Nullable String iban);

    @Nullable
    BankAccount getBankAccount(@Nullable ItemStack bankingCard);

    @Nonnull
    BankAccount createBankAccount(Registrant holder) throws IllegalArgumentException;

    @Nonnull
    List<Group> getGroups();

    @Nullable
    Group getGroup(String name);

    @Nonnull
    Einzelunternehmen createEinzelunternehmen(User owner) throws IllegalArgumentException;

    @Nonnull
    Personengesellschaft createPersonengesellschaft(User owner, List<User> coOwners) throws IllegalArgumentException;

    @Nonnull
    Kapitalgesellschaft createKapitalgesellschaft(int address) throws IllegalArgumentException;

    @Nonnull
    StateCompany createStateCompany(int address, StateCompany.Sector sector) throws IllegalArgumentException;

    @Nonnull
    Aktiengesellschaft createAktiengesellschaft(int address, int stocks) throws IllegalArgumentException;

    @Nonnull
    List<StateCompany> getStateCompanies();

    @Nullable
    Telephone getTelephone(@Nullable String telephoneNumber);

    @Nullable
    Registrant getRegistrant(@Nullable String string);

    @Nonnull
    Boundary createBoundary(@Nonnull Location anchorPoint, @Nonnull Location pullPoint, @Nonnull Consumer<PlayerInteractEvent> callback) throws IllegalArgumentException;

    @Nonnull
    Boundary createBoundary(@Nonnull Location anchorPoint, @Nonnull Vector vector, @Nonnull Consumer<PlayerInteractEvent> callback) throws IllegalArgumentException;

    @Nonnull
    Timer startTimer(int delay, @Nonnull Runnable callback) throws IllegalArgumentException;

    @Nonnull
    RepeatingTimer startRepeatingTimer(int period, @Nonnull Runnable callback) throws IllegalArgumentException;

    @Nonnull
    Reminder createReminder(int hours, int minutes, @Nonnull Runnable callback, DayOfWeek... weekdays) throws IllegalArgumentException;

    @Nonnull
    Reminder createReminder(int hours, int minutes, @Nonnull Runnable callback, List<DayOfWeek> weekdays) throws IllegalArgumentException;

    @Nonnull
    Webhook createWebhook(@Nonnull String url) throws IllegalArgumentException;

    @Nonnull
    EmbeddedMessage createEmbeddedMessage();

    boolean isMaintenance();

    NPC createNPC(UUID skinUniqueId, String name, Location location, boolean focusNearPlayers);

    NPC createNPC(String value, String signature, String name, Location location, boolean focusNearPlayers);

    @Nonnull
    List<OnlineUser> getOnlineUsers();

    @Nonnull
    CarBarrier createCarBarrier(@Nonnull Location loc, int rotation, @Nonnull List<Block> barrierBlocks) throws IllegalArgumentException;

    @Nonnull
    Hologram createHologram(@Nonnull Location loc, boolean visibleToEveryone, @Nonnull String... lines) throws IllegalArgumentException;

    @Nonnull
    String itemStackToString(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nullable
    ItemStack itemStackFromString(@Nullable String itemStack);

    @Nonnull
    String locationToString(@Nonnull Location location) throws IllegalArgumentException;

    @Nullable
    Location locationFromString(@Nullable String location);

    @Nonnull
    String blockToString(@Nonnull Block block) throws IllegalArgumentException;

    @Nullable
    Block blockFromString(@Nullable String block);

    @Nullable
    Region getRegion(int id);

    @Nonnull
    Region createRegion(@Nonnull List<Area> included, @Nonnull List<Area> excluded) throws IllegalArgumentException;

    @Nonnull
    List<Region> getRegions(@Nonnull Block block);

    @Nullable
    Residence getResidence(int id);

    @Nullable
    Residence getResidence(@Nullable Region region);

    @Nonnull
    Plot createPlot(@Nonnull Region region, @Nonnull Street street, @Nonnegative int houseNumber,
                    @Nonnull Registrant owner, @Nonnull Sign plotSign, @Nonnull Location teleportLocation) throws IllegalArgumentException;

    @Nonnull
    Apartment createApartment(@Nonnull Region region, @Nonnull Registrant landlord, int fertility, int rent,
                              @Nonnull Sign apartmentSign, @Nonnull Block mailbox) throws IllegalArgumentException;

    @Nonnull
    Apartment createApartment(@Nonnull Region region, @Nonnull ApartmentBlock block, int rent, @Nonnull Sign apartmentSign, @Nonnull Block mailbox) throws IllegalArgumentException;

    @Nonnull
    List<Residence> getLoadedResidences();

    @Nonnull
    List<Street> getStreets();

    @Nullable
    Street getStreet(int id);

    @Nonnull
    Street createStreet(@Nonnull String name, @Nullable String description) throws IllegalArgumentException;

    @Nonnull
    List<District> getDistricts();

    @Nullable
    District getDistrict(int id);

    @Nullable
    District getDistrict(Chunk chunk);

    void updateDistricts();

    @Nonnull
    RadioMast createRadioMast(@Nonnull String name, @Nonnull Block location, int range) throws IllegalArgumentException;

    @Nullable
    RadioMast getNearestRadioMast(@Nullable Location location);

    @Nonnull
    Area getArea(@Nonnull Block loc1, @Nonnull Block loc2) throws IllegalArgumentException;

    @Nullable
    Area getAreaFromString(@Nullable String rawArea);

    int convertHexToDecimalColor(@Nonnull String hex) throws IllegalArgumentException;

    @Nonnull
    FakeArmorStand createFakeArmorStand(@Nonnull Location location) throws IllegalArgumentException;

    @Nullable
    FakeArmorStand getFakeArmorStand(int id);

    @Nonnull
    Server getServerType();

    @Nullable
    String convertToTransparent(@Nullable String text) throws IllegalArgumentException;
}