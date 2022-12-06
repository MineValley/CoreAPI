package minevalley.core.api.vehicles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class VehicleColor {
    private final String name, hex;
}