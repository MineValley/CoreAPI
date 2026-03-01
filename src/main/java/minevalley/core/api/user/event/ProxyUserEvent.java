package minevalley.core.api.user.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import minevalley.core.api.event.ProxyEvent;
import minevalley.core.api.user.ProxyUser;

import javax.annotation.Nonnull;

@RequiredArgsConstructor
public abstract class ProxyUserEvent extends ProxyEvent {

    private final @Getter(onMethod_ = @Nonnull) ProxyUser user;
}