package com.twenty57.uidevshare;

class Planet
{
    private final String name;
    private final String description;

    Planet(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    String getDescription()
    {
        return description;
    }
}
