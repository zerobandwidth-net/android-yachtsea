package net.zerobandwidth.android.apps.yachtsea.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.zerobandwidth.android.apps.yachtsea.Control;
import net.zerobandwidth.android.apps.yachtsea.R;
import net.zerobandwidth.android.lib.AppUtils;

/**
 * Main activity for the app.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */
public class MainActivity
extends AppCompatActivity
{
    public static final String LOG_TAG = MainActivity.class.getSimpleName() ;

    /** A one-time definition of the title card string. */
    protected static String s_sTitleCard = null ;

    /** A reference to the overall activity layout. */
    protected LinearLayout m_layMain = null ;

    /** A reference to the title card. */
    protected TextView m_twTitleCard = null ;

    @Override
    protected void onCreate( Bundle bndlState )
    {
        super.onCreate(bndlState) ;
        this.setContentView( R.layout.activity_yachtsea_main ) ;
        this.acquireUIRefs().updateTitleCard() ;
    }

    /**
     * Grabs persistent references to components of the UI.
     * @return (fluid)
     */
    protected MainActivity acquireUIRefs()
    {
        m_layMain = ((LinearLayout)
                ( this.findViewById( R.id.layout_yachtsea_main_activity ) )) ;
        m_twTitleCard = ((TextView)
                ( this.findViewById( R.id.textview_yachtsea_main_titlecard ) ));
        return this ;
    }

    /**
     * Updates the text of the main activity's title card.
     * If the text value has not yet been resolved, then it will first set that
     * value statically in the activity class.
     * @return (fluid)
     * @see #s_sTitleCard
     */
    protected MainActivity updateTitleCard()
    {
        if( m_twTitleCard != null )
        {
            if( s_sTitleCard == null )
            {
                s_sTitleCard = AppUtils.getAppNameAndVersion(
                        this, R.string.text_title_card ) ;
            }
            this.runOnUiThread( new Runnable()
            {
                @Override
                public void run()
                { m_twTitleCard.setText( MainActivity.s_sTitleCard ) ; }
            });
        }
        return this ;
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu )
    {
        this.getMenuInflater().inflate( R.menu.menu_yachtsea_main, menu ) ;
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item )
    {
        switch( item.getItemId() )
        {
            case R.id.menuitem_yachtsea_main_play:
                this.onPlayGameSelected(null) ;
                break ;
            case R.id.menuitem_yachtsea_main_score:
                this.onKeepScoreSelected(null) ;
                break ;
            default:
                Log.w( LOG_TAG, "Unrecognized menu item selected." ) ;
        }
        return super.onOptionsItemSelected(item) ;
    }

    public void onPlayGameSelected( View w )
    {
        Control.startActivity( this, CreateOrOpenActivity.class,
                Control.MODE_PLAY_GAME ) ;
    }

    public void onKeepScoreSelected( View w )
    {
        Control.startActivity( this, CreateOrOpenActivity.class,
                Control.MODE_KEEP_SCORE ) ;
    }
}
