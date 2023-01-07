package minevalley.core.api.corporations;

import minevalley.core.api.Registrant;
import minevalley.core.api.economy.BankAccount;
import minevalley.core.api.enums.CorporatePermission;

import java.util.List;

public interface Department extends Registrant {

    /**
     * Gets this department's id.
     *
     * @return id as int
     */
    int getId();

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
     * Gets this departments banking account.
     *
     * @return departments banking account
     */
    BankAccount getBankAccount();

    /**
     * Gets this departments phone number.
     *
     * @return phone number as string
     */
    String getPhoneNumber();

    /**
     * Gets whether this department is the default department of the organization / company. The main department is the department, new members will be put into.
     *
     * @return true, if this department is the main department
     */
    boolean isDefaultDepartment();

    /**
     * Gets the base wage this departments members get. If a different base wage is specified in the member object, this is used.
     * <p>
     * <b>Note:</b> This is only usable for company-departments!
     *
     * @return departments base wage
     */
    double getBaseWage();

    /**
     * Sets this departments base wage.
     *
     * @param baseWage base wage as double
     */
    void setBaseWage(double baseWage);

    /**
     * Gets the service wage this departments members get. If a different service wage is specified in the member object, this is used.
     * <p>
     * <b>Note:</b> This is only usable for company-departments!
     *
     * @return departments service wage
     */
    double getServiceWage();

    /**
     * Sets this departments service wage.
     *
     * @param serviceWage service wage as double
     */
    void setServiceWage(double serviceWage);

    /**
     * Gets the permissions that are automatically granted to all members of this department.
     *
     * @return permissions as list
     */
    List<CorporatePermission> getPermissions();

    /**
     * Gets the members of this department.
     *
     * @return list with all members of this department
     */
    List<Member> getMembers();

    /**
     * Gets the tasks the members of this department are allowed to handle.
     * <p>
     * <b>Note:</b> This is only usable for company-departments!
     *
     * @return list of tasks to handle
     */
    List<Task> getTasks();
}
