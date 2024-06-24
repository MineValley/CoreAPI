package minevalley.core.api.users.events;

import minevalley.core.api.users.User;

/**
 * This event is called, when a user is loaded or reloaded from the database.
 * It is used to change user-dependent data in modules when that user's data has been updated.
 * You can update a user manually by calling the refresh()-method.
 */
public final class UserRefreshEvent extends UserEvent {

    public UserRefreshEvent(User user) {
        super(user);
    }
}