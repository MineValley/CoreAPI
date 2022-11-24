package minevalley.core.api.regions;

import minevalley.core.api.Registered;
import minevalley.core.api.User;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.List;

public interface Residence {

    int getId();

    List<Region> getRegions();

    Mailbox getMailbox();

    ResidenceSign getSign();

    Location getLocation();

    Street getStreet();

    Registered getOwner();

    List<Registered> getPermissioned();

    List<Registered> getAdmins();

    boolean isPermissioned(User user);

    boolean isAdmin(User user);

    void grantPermission(Registered registered);

    void grantAdminPermission(Registered registered);

    void revokePermission(Registered registered);

    void revokeAdminPermission(Registered registered);

    boolean isLocked();

    boolean contains(Block block);

    boolean contains(Location location);

    Warning getWarning();

    void addWarning(Warning notice);

    void removeWarning();

    void resetByTeamler(User teamler);

    void addElectricityCost(double cost);

    double getElectricityCosts();

    int getFertility();

    void updateFromDatabase();
}
