package minevalley.core.api.regions;

import lombok.NonNull;
import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.users.User;
import org.bukkit.Location;
import org.bukkit.block.Block;

import java.time.DayOfWeek;
import java.util.List;

/**
 * The Resident contains both types of living spaces: plots and apartments.
 * <br>
 * <b>Note:</b> Plots may have been merged! Even if they are, every plot still consists of its residence.
 * When dealing with plots, always take note of merged plots.
 */
public interface Residence extends PlayerLocation {

    /**
     * Each residence can be clearly identified by its ID. The Residences IDs are unique, regardless if it's a plot
     * or an apartment. There'll be neither a plot nor an apartment with the same ID as this one. The ID won't change.
     */
    int getId();

    /**
     * Every Residence is associated with a region. This region defines the habitat in which the user is allowed to build.
     * <br>
     * <b>Note:</b> Since Residences can be plots that are merged to other ones, keep in mind that there might be other
     * residences that are merged with this one. Therefore, it might be necessary to get the merged regions and the
     * merging regions (regions between merged plots), too.
     */
    Region getRegion();

    /**
     * Residences have to have a mailbox specified, to be rented by a player. Whenever a user tries to add a new apartment
     * he is asked to add a mailbox. If he doesn't add one, he should not be able to open the apartment for anyone to rent.
     * He might still use the apartment for personal purpose but is not able to define a rent nor search for renters.
     * <br>
     * If a plot gets merged with another one, its mailbox will get unplaced by the system. In this case, all contents are
     * directly delivered to the mailbox of the main plot (without time delay). Every plot merge does have a mailbox on
     * its main plot. If there is mail added to an unplaced mailbox, the system redirects the mail automatically to its new destination (main plot).
     */
    Mailbox getMailbox();

    /**
     * The ResidenceSign displays important information about the residence. It is also used to take actions on it.
     * It is placed outside the residence. Players use it to take actions, sell or buy the resident.
     * Every Resident has a sign, but merged plots unplace their sign and use the residence sign of the main plot.
     * When unmerging a plot, the original residence sign is replaced.
     */
    ResidenceSign getSign();

    /**
     * Every residence has a specific location. When creating new plots or apartments, the teamer has to define this location.
     * It is used for teamlers to teleport to a specific residence and is used as navigation target,
     * whenever a user tries to navigate to this residence.
     * In case this residence is an apartment created by a player, this location is set to the location of the ResidenceSign.
     */
    Location getLocation();

    /**
     * Every Residence has a Street. If this residence is a player-created apartment,
     * the street is the same as the one from the plot, this apartment lies on.
     * If the apartment lies on a merged plot, the street will be taken from the plotmerges main plot.
     */
    Street getStreet();

    /**
     * The owner has full permission over his residence. The ownership only changes if the residence is sold or transmitted.
     * <br>
     * <b>Note:</b> The owner of an apartment is its renter! To get the landlord, use the apartment-object and check for its landlord.
     * The result of getOwner() might be null! This is only the case, if the residence is for sale / for rent.
     * Plots for sale keep their owner until they are bought. To check, whether a plot is for sale, check the getSale()-method.
     */
    Registrant getOwner();

    /**
     * Permissioned users are allowed to build and have access to locked chests (and other locked blocks) if they are set up this way.
     * The list of permissioned users can be edited by the owner or the admins of this residence.
     * <br>
     * <b>Note:</b> This method only gives a copy of the original list. use the grantPermission and revokePermission method to adjust the contents.
     * Future changes won't be added to this list.
     */
    List<Registrant> getPermissioned();

    /**
     * Admin users have full permission for everything, the owner can access to, but:
     * <br>
     * - Admins aren't allowed to add / remove other admins
     * <br>
     * - Admins can't sell / reset / unrent the residence.
     * <br>
     * - Admins can't merge plots
     * <br>
     * They are allowed to add / remove users as permissioned users.
     * The list of admins users can only be edited by the owner of this residence.
     * <br>
     * <b>Note:</b> This method only gives a copy of the original list. use the grantAdminPermission and
     * revokeAdminPermission method to adjust the contents.
     * Future changes won't be added to this list.
     */
    List<Registrant> getAdmins();

    /**
     * Checks whether a user is part of the permissioned users list.
     * <br>
     * <b>Note:</b> The user doesn't have to be mentioned in the list! He just might be member of a
     * company/organisation/department that is listed as a permissioned user!
     */
    boolean isPermissioned(User user);

    /**
     * Checks whether a user is part of the admin-users list.
     * <br>
     * <b>Note:</b> The user doesn't have to be mentioned in the list! He just might be member of a
     * company/organisation/department that is listed as an admin-user!
     */
    boolean isAdmin(User user);

    /**
     * Adds a registrant to the permissioned list.
     */
    void grantPermission(Registrant registrant);

    /**
     * Adds a registrant to the admin list.
     */
    void grantAdminPermission(Registrant registrant);

    /**
     * Removes a registrant from the permissioned list.
     */
    void revokePermission(Registrant registrant);

    /**
     * Removes a registrant from the admin list.
     */
    void revokeAdminPermission(Registrant registrant);

    /**
     * Transmits this residence to another owner. This method should never be called to sell/rent the residence.
     * It only changes the given parameters. No money is transferred. This plots worth remains unchanged.
     *
     * @param user the given user will be marked as the responsible in a letter, that is sent to the transmitted plot.
     */
    void transmit(User user, @NonNull Registrant registrant, @NonNull BankAccount account);

    /**
     * Residences can be locked by a teamler or by the system.
     * This might be the case, to prevent new users from buying/renting this residence.
     * Plots are also locked, when the owner doesn't pay its electricity bills at time.
     * <p>
     * If a residence is locked but still has an owner, the owner (and admins / permissioned) are neither allowed
     * to build nor to sell/unrent/reset/merge. But they are allowed to add/remove permissioned users / admins and
     * are still allowed to open the mailbox. The security-protection of chests and other blocks keeps unchanged when a resident is locked.
     * Security-protections can still be edited, added or removed.
     * <p>
     * If there is an apartment on a locked plot, it should always be terminated by the system.
     * But until the 14-days period is over, the apartment isn't affected by the locked plot in any case.
     * Unrented apartments that are part of a locked plot can't be rented until the plot is unlocked.
     */
    boolean isLocked();

    /**
     * Locks this residence.
     * <br>
     * <b>Note:</b> The option to lock a residence should never be granted to any user and should only be used for administrative purposes.
     */
    void lock();

    /**
     * Unlocks this residence.
     */
    void unlock();

    /**
     * Checks whether the given block is part of this residence region.
     * <br>
     * <b>Note:</b> If this residence is a plot which is part of a PlotMerge, the other plots are ignored.
     * Use the contains()-method of the PlotMerge object instead to check for all merged plots!
     */
    boolean contains(Block block);

    /**
     * Checks whether the given location is part of this residence region.
     * <br>
     * <b>Note:</b> If this residence is a plot which is part of a PlotMerge, the other plots are ignored.
     * Use the contains()-method of the PlotMerge object instead to check for all merged plots!
     */
    boolean contains(Location location);

    /**
     * If the building of this residence does not meet the building regulations, a team member can issue a warning.
     * There can only be one warning on a residence at a time. If this is null, there is no warning.
     */
    Warning getWarning();

    /**
     * Adds a new warning. If there already is a warning, this method will do nothing!
     */
    void addWarning(Warning notice);

    /**
     * Removes the current warning.
     */
    void removeWarning();

    /**
     * Resets the residence to its original state.
     *
     * @param teamler can be null, if this is issued by the system.
     */
    void resetByTeamler(User teamler);

    default void reset() {
        resetByTeamler(null);
    }

    /**
     * The electricity costs are increased by heavy machines that are placed.
     * Since the electricity costs are cached and not directly updated to the database,
     * there is no need to regulate the amount of times, this method is used.
     * Electricity costs are updated to the database hourly and can be set to zero, if they get paid.
     *
     * @param cost the costs have to be a positive number. Negative numbers will be ignored!
     */
    void addElectricityCost(double cost);

    /**
     * Gets the electricity costs that are summed up since the latest bill.
     */
    double getElectricityCosts();

    void sendElectricityBill();

    DayOfWeek getElectricityPayDay();

    /**
     * The fertility of a residence defines, how fast plants can grow.
     * Apartments that are created by users always get the fertility of the plot they lie on.
     * If a user-created apartment lies on two plots with different fertility, the lower fertility is used.
     */
    int getFertility();

    // setup-method
    void setFertility(int fertility);

    /**
     * If there is a termination for a residence, the renter (apartment) oder owner (plot) has to leave the residence.
     * The landlord of an apartment can set up a termination to get full access to the apartment again.
     * Plots normally don't have a termination. It can only be set up by team members or the system.
     * The termination always stays for 14 days until it is executed. It can be cancelled in those 14 days.
     * <br>
     * If the owner of an apartment decides to move out, there is no delay in the termination.
     */
    Termination[] getTerminations();

    /**
     * Adds a termination. This can be used by a team member or the landlord of an apartment.
     *
     * @param termination termination to add to this residences termination list.
     */
    void terminate(@NonNull Termination termination);

    /**
     * Removes a termination.
     *
     * @param termination termination to remove.
     */
    void removeTermination(Termination termination);

    /**
     * Removes all existing terminations.
     */
    void removeAllTerminations();

    /**
     * Reloads all the data from the database.
     * this is only needed if there are some changes directly put into the database.
     * All variable values (such as the ones that are changeable in this interface) are updated automatically.
     */
    void updateFromDatabase();

    // setup-method
    void remove();

    // setup-method
    void setRegion(Region region);
}
