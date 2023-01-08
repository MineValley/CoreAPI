package minevalley.core.api.corporations;

import com.google.common.collect.Lists;
import minevalley.core.api.Property;
import minevalley.core.api.User;
import minevalley.core.api.corporations.business.Kapitalgesellschaft;
import minevalley.core.api.mail.Parcel;
import minevalley.core.api.regions.Residence;

import java.util.List;

public abstract class StateCompany implements Kapitalgesellschaft {

    @Override
    public boolean contains(User user) {
        return false;
    }

    @Override
    public Residence getAddress() {
        return null;
    }

    @Override
    public void deliverParcel(Parcel parcel) {

    }

    @Override
    public List<Property> getProperties() {
        return Lists.newArrayList();
    }

    @Override
    public List<Property> getProperties(Property.Type type) {
        return Lists.newArrayList();
    }

    @Override
    public boolean ownsProperty(int id, Property.Type type) {
        return false;
    }

    @Override
    public boolean ownsProperty(Property property) {
        return false;
    }

    @Override
    public void addProperty(Property property) {
        // do nothing
    }

    @Override
    public void removeProperty(int id, Property.Type type) {
        // do nothing
    }

    @Override
    public void removeProperty(Property property) {
        // do nothing
    }

    @Override
    public RenameFeedback changeName(String name) {
        // do nothing
        return null;
    }

    @Override
    public RenameFeedback changeDescription(String description) {
        // do nothing
        return null;
    }

    @Override
    public Department getDefaultDepartment() {
        return null;
    }

    @Override
    public List<Department> getDepartments() {
        return Lists.newArrayList();
    }

    @Override
    public void removeMember(User user) {
        // do nothing
    }

    @Override
    public void addMember(User user) {
        // do nothing
    }

    @Override
    public List<Shareholder> getShareholders() {
        return Lists.newArrayList();
    }

    @Override
    public void distribution(int distributionInCents) {
        // do nothing
    }
}
