package minevalley.core.api.users.friends;

import minevalley.core.api.users.User;

public interface FriendRequest {

    User getSender();

    User getTarget();

    long getSendingTimestamp();

    void accept();

    void reject();
}