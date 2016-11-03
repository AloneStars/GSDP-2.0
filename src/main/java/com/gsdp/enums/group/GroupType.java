package com.gsdp.enums.group;

/**
 * Created by yizijun on 2016/11/3 0003.
 */
public enum GroupType {

    ART(1, "艺术类"),
    UTILITY(2, "公益类"),
    CULTURE(3, "文化类"),
    SCIENCE(4, "科创类"),
    SPORT(5, "体育类"),
    EXTENSION(6, "素拓类");

    private int typeId;

    private String typeName;

    GroupType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public static GroupType getGroupType(int typeId) {
        for (GroupType groupType : values()) {
            if(groupType.getTypeId() == typeId) {
                return groupType;
            }
        }
        return null;
    }
}
