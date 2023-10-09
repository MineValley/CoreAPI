package minevalley.core.api.utils.armorstand;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.utils.Pair;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.function.Function;

public interface FakeArmorStand {

    Pair<Integer, Byte> BYTE_MASK = new Pair<>(11, (byte) 0x00);
    Pair<Integer, EulerAngle> HEAD_ROTATION = new Pair<>(12, new EulerAngle(0, 0, 0));
    Pair<Integer, EulerAngle> BODY_ROTATION = new Pair<>(13, new EulerAngle(0, 0, 0));
    Pair<Integer, EulerAngle> LEFT_ARM_ROTATION = new Pair<>(14, new EulerAngle(0, 0, 0));
    Pair<Integer, EulerAngle> RIGHT_ARM_ROTATION = new Pair<>(15, new EulerAngle(0, 0, 0));
    Pair<Integer, EulerAngle> LEFT_LEG_ROTATION = new Pair<>(16, new EulerAngle(0, 0, 0));
    Pair<Integer, EulerAngle> RIGHT_LEG_ROTATION = new Pair<>(17, new EulerAngle(0, 0, 0));

    /**
     * Exposes the Armorstand to everyone who fulfills the {@link #visibilityCondition(Function)}
     */
    void show();

    /**
     * Hides the Armorstand from everyone
     */
    void hide();

    /**
     * Creates the Armorstand but won't display it, until {@link #show()} was called
     */
    void create();

    /**
     * Updates the ArmorStand
     */
    void update();

    /**
     * Destroy the ArmorStand and delete it from any existing unit
     */
    void destroy();

    /**
     * Defines who can see the armorstand. By default, everyone can see the armorstand.
     */
    void visibilityCondition(Function<OnlineUser, Boolean> visibilityCondition);

    Location getLocation();

    void setLocation(Location location);

    ItemStack getItemInHand();

    void setItemInHand(ItemStack item);

    ItemStack getBoots();

    void setBoots(ItemStack boots);

    ItemStack getLeggings();

    void setLeggings(ItemStack leggings);

    ItemStack getChestplate();

    void setChestplate(ItemStack chestplate);

    ItemStack getHelmet();

    void setHelmet(ItemStack helmet);

    EulerAngle getBodyPose();

    void setBodyPose(EulerAngle bodyPose);

    EulerAngle getLeftArmPose();

    void setLeftArmPose(EulerAngle leftArmPose);

    EulerAngle getRightArmPose();

    void setRightArmPose(EulerAngle rightArmPose);

    EulerAngle getLeftLegPose();

    void setLeftLegPose(EulerAngle leftLegPose);

    EulerAngle getRightLegPose();

    void setRightLegPose(EulerAngle rightLegPose);

    EulerAngle getHeadPose();

    void setHeadPose(EulerAngle headPose);

    boolean hasBasePlate();

    void setBasePlate(boolean baseplate);

    boolean isVisible();

    void setVisible(boolean visible);

    boolean hasArms();

    void setArms(boolean hasArms);

    boolean isSmall();

    void setSmall(boolean small);

    boolean isMarker();

    void setMarker(boolean marker);

    int getId();

    void setId(int id);

    /**
     * Get the current passenger.
     *
     * @return OnlineUser or null if no passenger provided
     */
    OnlineUser getPassenger();

    /**
     * Add a passenger to the armorstand
     *
     * @param user
     * @return if the passenger applied correctly
     */
    boolean addPassenger(OnlineUser user);

    /**
     * Add a passenger to the armorstand
     *
     * @param user
     * @return if the passenger removed correctly
     */
    boolean removePassenger(OnlineUser user);
}
