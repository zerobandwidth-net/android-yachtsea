package net.zerobandwidth.android.apps.yachtsea.model;

/**
 * Models an instance of a player's score card.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */

public class ScoreCard
{
    protected Integer m_nAces = null ;
    protected Integer m_nTwos = null ;
    protected Integer m_nThrees = null ;
    protected Integer m_nFours = null ;
    protected Integer m_nFives = null ;
    protected Integer m_nSixes = null ;
    protected static final int UPPER_BONUS_MINIMUM = 63 ;
    protected static final int SCORE_UPPER_BONUS = 35 ;
    protected Integer m_nTriple = null ;
    protected Integer m_nQuad = null ;
    protected Integer m_nFullHouse = null ;
    protected static final int SCORE_FULL_HOUSE = 25 ;
    protected Integer m_nShortStraight = null ;
    protected static final int SCORE_SHORT_STRAIGHT = 30 ;
    protected Integer m_nLongStraight = null ;
    protected static final int SCORE_LONG_STRAIGHT = 40 ;
    protected Integer m_nQuint = null ;
    protected static final int SCORE_QUINT = 50 ;
    protected Integer m_nJunk = null ;
    protected int m_nBonusQuints = 0 ;
    protected static final int SCORE_BONUS_QUINT = 100 ;

    /**
     * Counts a null integer as zero for the purposes of tallying scores.
     * @param n the integer field to be evaluated
     * @return 0 if null, or the value if non-null
     */
    public static int valueOf( Integer n )
    { return ( n == null ? 0 : n ) ; }

    /**
     * Calculates the total raw score from the "upper section" of the card.
     * Values that are still null are counted as zero.
     * @return the total raw score for the upper section
     */
    public int getUpperScore()
    {
        return valueOf(m_nAces) + valueOf(m_nTwos) + valueOf(m_nThrees)
            + valueOf(m_nFours) + valueOf(m_nFives) + valueOf(m_nSixes) ;
    }

    /**
     * Returns the bonus to be applied to the "upper section" total score.
     * @return the bonus to be applied
     */
    public int getUpperBonus()
    { return this.getUpperBonus( this.getUpperScore() ) ; }

    /**
     * Given the specified raw score for the "upper section" of the score card,
     * the method returns the bonus to be applied.
     * @param nUpperScore the raw score for the "upper section" of the card
     * @return the bonus to be applied
     */
    public int getUpperBonus( int nUpperScore )
    { return ( nUpperScore >= UPPER_BONUS_MINIMUM ? SCORE_UPPER_BONUS : 0 ) ; }

    /**
     * Calculates the total score for the "upper section" &mdash; the raw score
     * plus the bonus, if any.
     * @return the total score for the "upper section"
     */
    public int getUpperTotal()
    {
        final int nUpperScore = this.getUpperScore() ;
        return nUpperScore + this.getUpperBonus(nUpperScore) ;
    }

    /**
     * Calculates the total score for the "lower section" of the score card.
     * @return the total score for the "lower section"
     */
    public int getLowerTotal()
    {
        return valueOf(m_nTriple) + valueOf(m_nQuad) + valueOf(m_nFullHouse)
            + valueOf(m_nShortStraight) + valueOf(m_nLongStraight)
            + valueOf(m_nQuint) + valueOf(m_nJunk)
            + ( m_nBonusQuints * SCORE_BONUS_QUINT )
            ;
    }

    /**
     * Calculates the total score for the entire card.
     * @return the total score for the entire card
     */
    public int getGrandTotal()
    { return this.getUpperTotal() + this.getLowerTotal() ; }
}
