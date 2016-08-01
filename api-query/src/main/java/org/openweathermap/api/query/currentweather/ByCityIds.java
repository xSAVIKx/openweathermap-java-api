package org.openweathermap.api.query.currentweather;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.openweathermap.api.query.AbstractQuery;

import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityIds extends AbstractQuery implements CurrentWeatherMultipleLocationsQuery {
    private Collection<String> cityIds;

    public ByCityIds(Collection<String> cityIds) {
        this.cityIds = cityIds;
    }

    public ByCityIds() {
        this.cityIds = new ArrayList<>();
    }

    public boolean addCityId(String cityId) {
        return cityIds.add(cityId);
    }

    @Override
    protected String getSearchPath() {
        return "/group";
    }

    @Override
    protected String getRequestPart() {
        return "id=" + StringUtils.join(cityIds, ',');
    }
}
