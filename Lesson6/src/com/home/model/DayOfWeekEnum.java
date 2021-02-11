package com.home.model;

public enum DayOfWeekEnum {
    MONDAY("понедельник"),
    TUESDAY("вторник"),
    WEDNESDAY("среда");
//    THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private final String localization;

    DayOfWeekEnum(String localization) {
        this.localization = localization;
    }

    public String getLocalization() {
        return localization;
    }
}
