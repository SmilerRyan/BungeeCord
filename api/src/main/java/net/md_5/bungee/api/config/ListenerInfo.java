package net.md_5.bungee.api.config;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class representing the configuration of a server listener. Used for allowing
 * multiple listeners on different ports.
 */
@Data
@AllArgsConstructor
public class ListenerInfo
{

    /**
     * Host to bind to.
     */
    private final SocketAddress socketAddress;
    /**
     * Displayed MOTD.
     */
    private final String motd;
    /**
     * Number of players to be shown on the tab list.
     */
    private final int tabListSize;
    /**
     * List of servers in order of join attempt. First attempt is the first
     * element, second attempt is the next element, etc etc.
     */
    private final List<String> serverPriority;
    /**
     * Whether reconnect locations will be used, or else the user is simply
     * transferred to the default server on connect.
     */
    private final boolean forceDefault;
    /**
     * A list of host to server name mappings which will force a user to be
     * transferred depending on the host they connect to.
     */
    private final Map<String, String> forcedHosts;
    /**
     * The type of tab list to use
     */
    private final String tabListType;
    /**
     * Whether to set the local address when connecting to servers.
     */
    private final boolean setLocalAddress;
    /**
     * Whether to pass the ping through when we can reliably get the target
     * server (force default server).
     */
    private final boolean pingPassthrough;
    /**
     * What port to run udp query on.
     */
    private final int queryPort;
    /**
     * Whether to enable udp query.
     */
    private final boolean queryEnabled;
    /**
     * Whether to support HAProxy PROXY protocol.
     */
    private final boolean proxyProtocol;

    @Deprecated
    public ListenerInfo(InetSocketAddress host, String motd, int tabListSize, List<String> serverPriority, boolean forceDefault, Map<String, String> forcedHosts, String tabListType, boolean setLocalAddress, boolean pingPassthrough, int queryPort, boolean queryEnabled)
    {
        this( host, motd, tabListSize, serverPriority, forceDefault, forcedHosts, tabListType, setLocalAddress, pingPassthrough, queryPort, queryEnabled, false );
    }

    /**
     * Gets the highest priority server to join.
     *
     * @return default server
     * @deprecated replaced by {@link #serverPriority}
     */
    @Deprecated
    public String getDefaultServer()
    {
        return serverPriority.get( 0 );
    }

    /**
     * Gets the second highest priority server to join, or else the highest
     * priority.
     *
     * @return fallback server
     * @deprecated replaced by {@link #serverPriority}
     */
    @Deprecated
    public String getFallbackServer()
    {
        return ( serverPriority.size() > 1 ) ? serverPriority.get( 1 ) : getDefaultServer();
    }

    /**
     * Gets the bind address as an InetSocketAddress if possible.
     *
     * @return bind host
     * @deprecated BungeeCord can listen via Unix domain sockets
     */
    @Deprecated
    public InetSocketAddress getHost()
    {
        return (InetSocketAddress) socketAddress;
    }
}
