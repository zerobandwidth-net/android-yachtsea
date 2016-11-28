package net.zerobandwidth.android.apps.yachtsea.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import net.zerobandwidth.android.apps.yachtsea.R;
import net.zerobandwidth.android.lib.AppUtils;

/**
 * Allows the user to create a new game.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */
public class CreateActivity
extends ControlledAppCompatActivity
{
    public static final String LOG_TAG = CreateActivity.class.getSimpleName() ;

    @Override
    protected void onCreate( Bundle bndlState )
    {
        super.onCreate( bndlState ) ;
        setContentView( R.layout.activity_yachtsea_create_game ) ;
        AppUtils.initBackButtonForActivity(this) ;
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
     * Handles the event where a user wants to create a new player.
     * @param w the selected UI element (ignored)
     */
    public void onCreatePlayerSelected( View w )
    {
        Log.d( LOG_TAG, "Yep, someone pressed the Create Player button." ) ;
    }
}
