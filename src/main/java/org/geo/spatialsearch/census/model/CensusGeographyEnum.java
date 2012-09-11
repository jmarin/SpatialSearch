package org.geo.spatialsearch.census.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Juan Marin
 * 
 */
public enum CensusGeographyEnum {
    STATE2010("state2010"), COUNTY2010("county2010"), TRACT2010("tract2010"), BLOCK2010(
            "block2010"), CONGRESSIONAL_DISTRICT("congdistrict"), PLACE(
            "censusplace"), MSA("msa"), TRIBAL("tribalnation"), STATE_HOUSE_DISTRICT(
            "statehouse"), STATE_SENATE_DISTRICT("statesenate"), ALL("all");

    private String externalGeographyType;

    private static final Map<String, CensusGeographyEnum> CENSUS_GEOGRAPHIES_MAP = new HashMap<String, CensusGeographyEnum>() {
        private static final long serialVersionUID = 6474684037808425957L;
        {
            for (CensusGeographyEnum geography : CensusGeographyEnum.values()) {
                put(geography.getExternalGeographyType().toLowerCase(),
                        geography);
            }
        }
    };

    private CensusGeographyEnum(String externalGeographyType) {
        this.externalGeographyType = externalGeographyType;
    }

    public String getExternalGeographyType() {
        return externalGeographyType;
    }

    public void setExternalGeographyType(String externalGeographyType) {
        this.externalGeographyType = externalGeographyType;
    }

    public static CensusGeographyEnum getGeographyTypeWithKey(
            String externalGeographyTypeKey) {
        return CENSUS_GEOGRAPHIES_MAP.get(externalGeographyTypeKey
                .toLowerCase());
    }
}
