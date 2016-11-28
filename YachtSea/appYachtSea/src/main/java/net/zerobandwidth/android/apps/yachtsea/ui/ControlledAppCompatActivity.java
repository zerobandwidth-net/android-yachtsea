package net.zerobandwidth.android.apps.yachtsea.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.zerobandwidth.android.apps.yachtsea.Control;

/**
 * Activities in this app descend from this class to inherit features related to
 * "operating mode" (playing the game vs. just keeping score)
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 * @see Control
 */
public abstract class ControlledAppCompatActivity
extends AppCompatActivity
{
    /**
     * Tracks the current operating mode (playing the game vs. just keeping score)
     */
    protected int m_nMode = Control.MODE_NOT_INITIALIZED ;

    @Override
    protected void onCreate( Bundle bndlState )
    {
        super.onCreate(bndlState) ;
        this.acquireMode() ;
    }

    /**
     * Initializes the operating mode for the activity, based on the value of
     * the extra passed in by the parent activity.
     * @return (fluid)
     */
    protected ControlledAppCompatActivity acquireMode()
    {
        m_nMode = this.getIntent().getIntExtra(
            Control.EXTRA_MODE, Control.MODE_KEEP_SCORE ) ;
        return this ;
    }
}
