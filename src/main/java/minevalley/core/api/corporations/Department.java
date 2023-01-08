package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;

import java.util.List;

public interface Department extends Registrant {

    /**
     * Gets this department's name.
     *
     * @return name as string
     */
    String getName();

    /**
     * Sets this departments name.
     *
     * @param name name as string
     */
    void setName(String name);

    /**
     * Gets this department's description.
     *
     * @return description as string
     */
    String getDescription();

    /**
     * Sets this departments description.
     *
     * @param description description as string
     */
    void setDescription(String description);

    /**
     * Gets the holder of this department.
     *
     * @return holder of this department (company/organization)
     */
    Group getHolder();

    /**
     * Gets whether this department is the default department of the organization / company. The main department is the department, new members will be put into.
     *
     * @return true, if this department is the main department
     */
    boolean isDefaultDepartment();

    PermissionConfiguration getDefaultPermissionConfiguration();

    WageConfiguration getDefaultWageConfiguration();

    /**
     * Gets the members of this department.
     *
     * @return list with all members of this department
     */
    List<Member> getMembers();
}
