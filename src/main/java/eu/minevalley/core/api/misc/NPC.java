package eu.minevalley.core.api.misc;

import eu.minevalley.core.api.enums.NPCAnimationEnum;
import javafx.scene.control.Skin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface NPC {


    String getName();

    String getDisplayName();

    void setMetadata(String metadata);

    String getMetadata();

    List<Player> getPlayers();

    Location getLocation();
}
