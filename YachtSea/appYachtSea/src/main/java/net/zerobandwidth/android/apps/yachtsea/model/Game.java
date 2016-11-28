package net.zerobandwidth.android.apps.yachtsea.model;

import java.util.HashMap;
import java.util.Vector;

/**
 * Models an instance of a certain popular dice-based game.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */
public class Game
{
    public static final String TAG = Game.class.getSimpleName() ;

    /** A collection of players. */
    protected Vector<Player> m_vPlayers = null ;

    /** A map of player IDs to their score cards. */
    protected HashMap<String,ScoreCard> m_mapScoreCards = null ;

    public Game()
    { this.initPlayers() ; }

    /**
     * Clears or creates the collection of players.
     * Ends with a call to {@link #initScoreCards} to also clear or create the
     * score cards.
     * @return (fluid)
     */
    public Game initPlayers()
    {
        if( m_vPlayers == null )
            m_vPlayers = new Vector<>() ;
        else
            m_vPlayers.clear() ;
        return this.initScoreCards() ;
    }

    /**
     * Clears or creates the map of player IDs to score cards.
     * May be invoked directly but is also invoked by every call to
     * {@link #initPlayers}.
     * @return (fluid)
     */
    public Game initScoreCards()
    {
        if( m_mapScoreCards == null )
            m_mapScoreCards = new HashMap<>() ;
        else
            m_mapScoreCards.clear() ;
        return this ;
    }

    /**
     * Adds a player.
     * Also creates or clears that player's score card.
     * @param p the player to be added
     * @return (fluid)
     * @throws IllegalArgumentException if the player is already registered in
     *  this game
     */
    public Game addPlayer( Player p )
    throws IllegalArgumentException
    {
        final String sID = p.getID() ;
        for( Player pExisting : m_vPlayers )
        {
            if( sID.equals(pExisting.getID()) )
            {
                throw new IllegalArgumentException( (new StringBuilder())
                        .append( "Player with ID [" )
                        .append( sID )
                        .append( "] is already in this game." )
                        .toString()
                    );
            }
        }
        m_vPlayers.add(p) ;
        m_mapScoreCards.remove(sID) ;   // no consequence if ID not found in map
        m_mapScoreCards.put( sID, new ScoreCard() ) ;
        return this ;
    }

    /**
     * Removes a player.
     * Also discards that player's score card, if any.
     * @param p the player to be removed
     * @return (fluid)
     */
    public Game removePlayer( Player p )
    {
        m_vPlayers.remove(p) ;
        m_mapScoreCards.remove( p.getID() ) ;
        return this ;
    }

    /**
     * Removes a player.
     * @param nIndex in the collection of players, the index of the player to be
     *               removed
     * @return (fluid)
     * @throws IndexOutOfBoundsException if a negative index is supplied
     */
    public Game removePlayer( int nIndex )
    {
        if( nIndex < 0 || nIndex >= m_vPlayers.size() )
        {
            throw new IndexOutOfBoundsException( (new StringBuilder())
                    .append( "Illegal player index [" )
                    .append( nIndex )
                    .append( "] passed to removePlayer()." )
                    .toString()
                );
        }
        final String sID = m_vPlayers.get(nIndex).getID() ;
        m_vPlayers.remove(nIndex) ;
        m_mapScoreCards.remove(sID) ;
        return this ;
    }
}
