package minevalley.core.api.corporate;

import java.util.List;

public interface Employee extends Member {

    /**
     * Gets the base wage this departments members get. Equally if the wage is specified in the employee-object or the department-object.
     * @return employees base wage
     */
    double getBaseWage();

    /**
     * Gets the service wage this departments members get. Equally if the wage is specified in the employee-object or the department-object.
     * @return employees service wage
     */
    double getServiceWage();


    /**
     * Sets the base wage this departments members get.
     * <p>
     * <b>Note:</b> This overwrites the departments base wage for this user! Specify 0 to use the departments wage.
     */
    void setBaseWage();

    /**
     * Sets the service wage this departments members get.
     * <p>
     * <b>Note:</b> This overwrites the departments service wage for this user! Specify 0 to use the departments wage.
     */
    void setServiceWage();

    /**
     * Gets the tasks this employee is allowed to handle.
     * <p>
     * <b>Note:</b> This list also contains the tasks of this employees department!
     * @return list of tasks to handle
     */
    List<Task> getTasks();
}
