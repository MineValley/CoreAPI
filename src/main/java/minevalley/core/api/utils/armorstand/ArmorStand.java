package minevalley.core.api.utils.armorstand;

import minevalley.core.api.users.OnlineUser;
import minevalley.core.api.utils.Pair;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public interface ArmorStand {

    Pair<Integer, Byte> BYTE_MASK = new Pair<>(11, (byte) 0x00);
    Pair<Integer, EulerAngle> HEAD_ROTATION = new Pair<>(12, new EulerAngle(0,0,0));
    Pair<Integer, EulerAngle> BODY_ROTATION = new Pair<>(13, new EulerAngle(0,0,0));
    Pair<Integer, EulerAngle> LEFT_ARM_ROTATION = new Pair<>(14, new EulerAngle(0,0,0));
    Pair<Integer, EulerAngle> RIGHT_ARM_ROTATION = new Pair<>(15, new EulerAngle(0,0,0));
    Pair<Integer, EulerAngle> LEFT_LEG_ROTATION = new Pair<>(16, new EulerAngle(0,0,0));
    Pair<Integer, EulerAngle> RIGHT_LEG_ROTATION = new Pair<>(17, new EulerAngle(0,0,0));

    /**
     * Exposes the Armorstand for onlineusers
     */
    void show();

    /**
     * Hides the Armorstand for onlineusers
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

    void canSee(boolean canSee, OnlineUser... players);

    Location getLocation();
    void setLocation(Location var1);

    ItemStack getItemInHand();

    void setItemInHand(ItemStack var1);

    ItemStack getBoots();

    void setBoots(ItemStack var1);

    ItemStack getLeggings();

    void setLeggings(ItemStack var1);

    ItemStack getChestplate();

    void setChestplate(ItemStack var1);

    ItemStack getHelmet();

    void setHelmet(ItemStack var1);

    EulerAngle getBodyPose();

    void setBodyPose(EulerAngle var1);

    EulerAngle getLeftArmPose();

    void setLeftArmPose(EulerAngle var1);

    EulerAngle getRightArmPose();

    void setRightArmPose(EulerAngle var1);

    EulerAngle getLeftLegPose();

    void setLeftLegPose(EulerAngle var1);

    EulerAngle getRightLegPose();

    void setRightLegPose(EulerAngle var1);

    EulerAngle getHeadPose();

    void setHeadPose(EulerAngle var1);

    boolean hasBasePlate();

    void setBasePlate(boolean var1);

    boolean isVisible();

    void setVisible(boolean var1);

    boolean hasArms();

    void setArms(boolean var1);

    boolean isSmall();

    void setSmall(boolean var1);

    boolean isMarker();

    void setMarker(boolean var1);

    int getId();
    void setId(int var1);

    /**
     * Add a passenger to the armorstand
     * @param user
     * @return if the passenger applied correctly
     */
    boolean addPassenger(OnlineUser user);

    /**
     * Add a passenger to the armorstand
     * @param user
     * @return if the passenger removed correctly
     */
    boolean removePassenger(OnlineUser user);

    /**
     * Get the current passenger.
     * @return OnlineUser or null if no passenger provided
     */
    OnlineUser getPassenger();


}
