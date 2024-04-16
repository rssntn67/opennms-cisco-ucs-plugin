
package it.xeniaprogetti.cisco.ucs.plugin.connection;


import java.net.InetAddress;

public interface Connection {

    /**
     * Returns the alias of the connection.
     * The alias is a unique identifier representing a connection configuration.
     *
     * @return the alias
     */
    String getAlias();

    /**
     * Returns the ip address of the cisco ucs Manager.
     * @return the cisco ucs manager ip address
     */
    InetAddress getCiscoUcsInetAddress();

    /**
     * Changes the InetAddress of the cisco UCS Manager.
     * @param inetAddress  the new InetAddress
     */
    void setCiscoUcsInetAddress(final InetAddress inetAddress);

    /**
     * Returns the SNMP SecurityName used to authenticate the connection.
     * @return the username
     */
    String getUsername();

    /**
     * Changes the SNMP SecurityName used to authenticate the connection.
     * @param username username
     */
    void setUsername(final String username);

    /**
     * Returns the Auth password used to authenticate the connection.
     * @return the password
     */
    String getPassword();

    /**
     * Changes the Auth password used to authenticate the connection.
     * @param password password
     */
    void setPassword(final String password);

    /**
     * Returns the location the connection.
     * @return the location
     */
    String getLocation();


    /**
     * Save the altered connection config in the underlying store.
     */
    void save();

    void delete();

}
