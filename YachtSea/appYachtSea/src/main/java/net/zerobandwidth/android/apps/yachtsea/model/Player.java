package net.zerobandwidth.android.apps.yachtsea.model;

import java.util.UUID;

/**
 * Models data for a player.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */
public class Player
{
    public static final String LOG_TAG = Player.class.getSimpleName() ;

    /** The unique ID of the player in the app's database. */
    protected String m_sID = null ;
    /** The player's name. */
    protected String m_sName = null ;

    /**
     * Gets the player's UUID.
     * @return the player's UUID in the database
     */
    public String getID()
    { return m_sID ; }

    /**
     * Sets the player's UUID.
     * If {@code null} is supplied, then a random UUID will be generated.
     * @param sID the UUID to be set
     * @return (fluid)
     */
    public Player setID( String sID )
    {
        if( sID == null )
            m_sID = UUID.randomUUID().toString() ;
        else
            m_sID = sID ;
        return this ;
    }

    /**
     * Gets the player's name.
     * @return the player's name
     */
    public String getName()
    { return m_sName ; }

    /**
     * Sets the player's name.
     * @param sName the name to be set
     * @return (fluid)
     */
    public Player setName( String sName )
    { m_sName = sName ; return this ; }
}
