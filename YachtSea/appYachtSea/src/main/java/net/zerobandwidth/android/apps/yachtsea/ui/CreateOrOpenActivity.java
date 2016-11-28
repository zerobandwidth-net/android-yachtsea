package net.zerobandwidth.android.apps.yachtsea.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import net.zerobandwidth.android.apps.yachtsea.Control;
import net.zerobandwidth.android.apps.yachtsea.R;
import net.zerobandwidth.android.lib.AppUtils;

/**
 * Allows the user to create a new game record, or reopen an existing game for
 * further play.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */
public class CreateOrOpenActivity
extends ControlledAppCompatActivity
{
    public static final String LOG_TAG =
            CreateOrOpenActivity.class.getSimpleName() ;

    /** A persistent reference to the main layout. */
    protected LinearLayout m_layMain = null ;

    @Override
    protected void onCreate( Bundle bndlState )
    {
        super.onCreate(bndlState) ;
        this.setContentView( R.layout.activity_yachtsea_create_or_open ) ;
        this.acquireUIRefs().setTitleForMode() ;
        AppUtils.initBackButtonForActivity(this) ;
    }

    /**
     * Grabs persistent references to components of the UI.
     * @return (fluid)
     */
    protected CreateOrOpenActivity acquireUIRefs()
    {
        m_layMain = ((LinearLayout)( this.findViewById(
                R.id.layout_yachtsea_create_or_open_activity ) )) ;
        return this ;
    }

    /**
     * Sets the activity's title based on the mode with which it was invoked.
     * @return (fluid)
     */
    protected CreateOrOpenActivity setTitleForMode()
    {
        switch( m_nMode )
        {
            case Control.MODE_PLAY_GAME:
                this.setTitle( R.string.title_play_game ) ;
                break ;
            case Control.MODE_KEEP_SCORE:
            default:
                this.setTitle( R. string.title_keep_score ) ;
                break ;
        }
        return this ;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        switch( item.getItemId() )
        {
            case android.R.id.home:
                this.onBackPressed() ;
                break ;
            default:
                Log.d( LOG_TAG, "Unrecognized menu item selected." ) ;
        }
        return super.onOptionsItemSelected(item) ;
    }

    /**
     * Handles the event where a user wants to create a new game.
     * @param w the selected UI element (ignored)
     */
    public void onCreateNewGameSelected( View w )
    { Control.startActivity( this, CreateActivity.class, m_nMode ) ; }
}
