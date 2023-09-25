package minevalley.core.api.utils;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.util.UUID;

public interface ArmorStand {

    void spawn();
    void update();

    Location getLocation();
    void setLocation(Location loc1);

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

    String getId();
    void setId(String var1);
}
