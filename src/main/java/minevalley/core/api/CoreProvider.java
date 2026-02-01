package minevalley.core.api;

import com.google.gson.Gson;
import minevalley.core.api.armorstand.FakeArmorStand;
import minevalley.core.api.banking.BankAccount;
import minevalley.core.api.corporations.Group;
import minevalley.core.api.corporations.companies.*;
import minevalley.core.api.database.StatementBuilder;
import minevalley.core.api.discord.EmbeddedMessage;
import minevalley.core.api.discord.Webhook;
import minevalley.core.api.displays.BlockDisplay;
import minevalley.core.api.displays.ItemDisplay;
import minevalley.core.api.displays.TextDisplay;
import minevalley.core.api.enums.DebugType;
import minevalley.core.api.gui.FillItem;
import minevalley.core.api.gui.InventoryGui;
import minevalley.core.api.gui.MultiPageGui;
import minevalley.core.api.interaction.InteractionTrigger;
import minevalley.core.api.npc.NPC;
import minevalley.core.api.phone.Telephone;
import minevalley.core.api.server.Server;
import minevalley.core.api.team.Team;
import minevalley.core.api.timing.Reminder;
import minevalley.core.api.timing.RepeatingTimer;
import minevalley.core.api.timing.Timer;
import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.users.User;
import minevalley.core.api.utils.*;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URL;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

@ApiStatus.Internal
public interface CoreProvider {

    @Nonnull
    JavaPlugin getInstance();

    @Nonnull
    Server server();

    @Nonnull
    @Contract(pure = true)
    String getVersion(@Nonnull CoreModule module) throws IllegalArgumentException;

    @Nonnull
    @Contract(pure = true)
    Developer[] getDevelopers(@Nonnull CoreModule module) throws IllegalArgumentException;

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

    @Nonnull
    Team team();

    void sendDebug(@Nonnull DebugType type, @Nonnull String message);

    void setSetting(@Nonnull String key, @Nonnull String value) throws IllegalArgumentException;

    String getSetting(String key);

    void updateStatistic(@Nonnull String key, double value) throws IllegalArgumentException;

    double getStatistic(@Nonnull String key) throws IllegalArgumentException;

    @Contract("null -> null")
    String removeColorCodes(@Nullable String text);

    @Contract("null -> null")
    String convertColorCodes(@Nullable String text);

    @Contract("null -> false")
    boolean containsForForbiddenWords(@Nullable String string);

    @Nonnull
    Gson getGson();

    int getRandomInteger(int chars) throws IllegalArgumentException;

    @Contract("null -> false")
    boolean isInteger(@Nullable String string);

    @Contract("null -> false")
    boolean isDouble(@Nullable String string);

    @Nonnull
    String formatMoney(int amountInCents);

    @Nonnull
    String formatRelativeTimestamp(long time);

    @Nonnull
    InventoryGui createGUI(@Nonnull Component title, @Nonnegative int size) throws IllegalArgumentException;

    @Nonnull
    MultiPageGui createMultiPageGui(@Nonnull Component title, @Nonnegative int size, @Nonnull List<FillItem> fillItems) throws IllegalArgumentException;

    @Nonnull
    World getMainWorld();

    @Nonnull
    World getBuildingWorld() throws IllegalStateException;

    @Nonnull
    World getPresetsWorld() throws IllegalStateException;

    @Nonnull
    FakeBlock createFakeBlock(@Nonnull Block block, @Nonnull Material material, int data) throws IllegalArgumentException;

    @Nonnull
    BlockDisplay createBlockDisplay(@Nonnull Location location, @Nonnull Material material) throws IllegalArgumentException;

    @Nonnull
    ItemDisplay createItemDisplay(@Nonnull Location location, @Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nonnull
    TextDisplay createTextDisplay(@Nonnull Location location, @Nonnull ComponentLike text) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull Material material) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull Player player) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(@Nonnull UUID uniqueId) throws IllegalArgumentException;

    @Nonnull
    @Contract("_, _ -> new")
    ItemBuilder createItem(@Nonnull String value, @Nonnull String signature) throws IllegalArgumentException;

    @Nonnull
    @Contract("_ -> new")
    ItemBuilder createItem(String url) throws IllegalArgumentException;

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
    Timer startTimer(int delay, @Nonnull Runnable callback) throws IllegalArgumentException;

    @Nonnull
    RepeatingTimer startRepeatingTimer(int period, @Nonnull Runnable callback) throws IllegalArgumentException;

    @Nonnull
    Reminder createReminder(int hours, int minutes, @Nonnull Runnable callback, DayOfWeek... weekdays) throws IllegalArgumentException;

    @Nonnull
    Webhook createWebhook(@Nonnull URL url) throws IllegalArgumentException;

    @Nonnull
    EmbeddedMessage createEmbeddedMessage();

    @Nonnull
    NPC createNPC(@Nonnull UUID skinUniqueId, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException;

    @Nonnull
    NPC createNPC(@Nonnull String value, @Nonnull String signature, @Nonnull String name, @Nonnull Location location)
            throws IllegalArgumentException;

    @Nonnull
    CarBarrier createCarBarrier(@Nonnull Location loc, int rotation, @Nonnull List<Block> barrierBlocks) throws IllegalArgumentException;

    @Nonnull
    Hologram createHologram(@Nonnull Location loc, boolean visibleToEveryone, @Nonnull String... lines) throws IllegalArgumentException;

    @Nonnull
    String itemStackToString(@Nonnull ItemStack itemStack) throws IllegalArgumentException;

    @Nullable
    ItemStack itemStackFromString(@Nullable String itemStack);

    int convertHexToDecimalColor(@Nonnull String hex) throws IllegalArgumentException;

    @Nonnull
    FakeArmorStand createFakeArmorStand(@Nonnull Location location) throws IllegalArgumentException;

    @Nullable
    FakeArmorStand getFakeArmorStand(int id);

    @Nullable
    String convertToTransparent(@Nullable String text) throws IllegalArgumentException;

    @Nonnull
    InteractionTrigger createInteractionTrigger(@Nonnull World world,
                                                double minX, double minY, double minZ,
                                                double maxX, double maxY, double maxZ,
                                                @Nonnull Consumer<PlayerInteractEvent> callback,
                                                @Nonnegative double range)
            throws IllegalArgumentException;
}