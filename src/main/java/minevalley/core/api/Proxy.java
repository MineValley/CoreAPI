package minevalley.core.api;

import minevalley.core.api.users.ProxyUser;

import javax.annotation.Nonnull;
import java.util.UUID;

@SuppressWarnings("unused")
public interface Proxy {

    /**
     * Gets the ProxyUser of this specific uuid.
     *
     * @param uuid uuid to get user from
     * @return user object of the given uuid
     * @throws IllegalArgumentException if the uuid is null or not found
     */
    @Nonnull
    ProxyUser getProxyUser(UUID uuid) throws IllegalArgumentException;

    /**
     * Gets the ProxyUser of this specific id.
     *
     * @param id id to get user from
     * @return user object of the given id
     * @throws IllegalArgumentException if the id is null or not found
     */
    @Nonnull
    ProxyUser getProxyUser(String id);
}
