package net.dv8tion.jda.entities.impl;

import net.dv8tion.jda.Region;
import net.dv8tion.jda.entities.*;

import java.util.*;

public class GuildImpl implements Guild
{
    private final String id;
    private String name;
    private String iconId;
    private String afkChannelId;
    private String ownerId;
    private int afkTimeout;
    private Region region;
    private Map<String, TextChannel> textChannels = new HashMap<>();
    private Map<String, VoiceChannel> voiceChannels = new HashMap<>();
    private Map<String, Role> roles = new HashMap<>();
    private Map<User, List<Role>> userRoles = new HashMap<>();

    public GuildImpl(String id)
    {
        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getIconId()
    {
        return iconId;
    }

    @Override
    public String getIconUrl()
    {
        return "https://cdn.discordapp.com/icons/" + getId() + "/" + getIconId() + ".jpg";
    }

    @Override
    public String getAfkChannelId()
    {
        return afkChannelId;
    }

    @Override
    public String getOwnerId()
    {
        return ownerId;
    }

    @Override
    public int getAfkTimeout()
    {
        return afkTimeout;
    }

    @Override
    public Region getRegion()
    {
        return region;
    }


    @Override
    public List<TextChannel> getTextChannels()
    {
        List<TextChannel> list = new ArrayList<>();
        list.addAll(textChannels.values());
        return list;
    }

    @Override
    public List<VoiceChannel> getVoiceChannels()
    {
        List<VoiceChannel> list = new ArrayList<>();
        list.addAll(voiceChannels.values());
        return list;
    }

    @Override
    public List<Role> getRoles()
    {
        List<Role> list = new ArrayList<>();
        list.addAll(roles.values());
        return list;
    }

    public Map<String, Role> getRolesMap()
    {
        return roles;
    }

    @Override
    public List<Role> getRolesForUser(User user)
    {
        return userRoles.get(user) == null ? new LinkedList<>() : Collections.unmodifiableList(userRoles.get(user));
    }

    public Map<User, List<Role>> getUserRoles()
    {
        return userRoles;
    }

    public GuildImpl setName(String name)
    {
        this.name = name;
        return this;
    }

    public GuildImpl setIconId(String iconId)
    {
        this.iconId = iconId;
        return this;
    }

    public GuildImpl setOwnerId(String ownerId)
    {
        this.ownerId = ownerId;
        return this;
    }

    public GuildImpl setAfkTimeout(int afkTimeout)
    {
        this.afkTimeout = afkTimeout;
        return this;
    }

    public GuildImpl setAfkChannelId(String channelId)
    {
        this.afkChannelId = channelId;
        return this;
    }

    public GuildImpl setRegion(Region region)
    {
        this.region = region;
        return this;
    }

    public Map<String, TextChannel> getTextChannelsMap()
    {
        return textChannels;
    }

    public Map<String, VoiceChannel> getVoiceChannelsMap()
    {
        return voiceChannels;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Guild))
            return false;
        Guild oGuild = (Guild) o;
        return this == oGuild || this.getId().equals(oGuild.getId());
    }

    @Override
    public int hashCode()
    {
        return getId().hashCode();
    }
}