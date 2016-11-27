package net.zerobandwidth.android.apps.yachtsea.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import net.zerobandwidth.android.apps.yachtsea.Control;
import net.zerobandwidth.android.apps.yachtsea.R;
import net.zerobandwidth.android.lib.AppUtils;

public class CreateOrOpenActivity
extends AppCompatActivity
{
    public static final String LOG_TAG =
            CreateOrOpenActivity.class.getSimpleName() ;

    /** A persistent reference to the main layout. */
    protected LinearLayout m_layMain = null ;

    @Override
    protected void onCreate( Bundle bndlState )
    {
        super.onCreate(bndlState) ;
        setContentView( R.layout.activity_yachtsea_create_or_open ) ;
        this.acquireUIRefs().setTitleForMode() ;
        AppUtils.initBackButtonForActivity(this) ;
        AppUtils.setLinearOrientation( this, m_layMain ) ;
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
        final int nMode = this.getIntent()
                .getIntExtra( Control.EXTRA_MODE, Control.MODE_KEEP_SCORE ) ;
        switch( nMode )
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
            default:
                Log.d( LOG_TAG, "Unrecognized menu item selected." ) ;
        }
        return super.onOptionsItemSelected(item) ;
    }
}
