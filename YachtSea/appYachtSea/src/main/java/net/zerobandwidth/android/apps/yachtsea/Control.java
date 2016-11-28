package net.zerobandwidth.android.apps.yachtsea;

import android.content.Context;
import android.content.Intent;

/**
 * Defines constants that control the behavior of the app.
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 * @see net.zerobandwidth.android.apps.yachtsea.ui.ControlledAppCompatActivity
 */
public class Control
{
    /**
     * Mode indicator placeholder value when it has not been initialized yet.
     */
    public static final int MODE_NOT_INITIALIZED = -1 ;

    /**
     * Mode indicator for using the app to play the game.
     * @see #startActivity
     */
    public static final int MODE_PLAY_GAME = 0 ;

    /**
     * Mode indicator for using the app to keep score.
     * @see #startActivity
     */
    public static final int MODE_KEEP_SCORE = 1 ;

    /**
     * Uniquely (?) identifies the extra in which the mode is marshalled.
     * @see #startActivity
     */
    public static final String EXTRA_MODE =
            Control.class.getCanonicalName() + ".MODE" ;

    /**
     * Kicks off one of the app's activities while passing in the appropriate
     * behavior mode.
     * @param ctxCaller the context in which the activity will be started
     * @param clsCalled the activity to be started
     * @param nMode the operating mode
     * @see #MODE_PLAY_GAME
     * @see #MODE_KEEP_SCORE
     */
    public static void startActivity( Context ctxCaller, Class<?> clsCalled, int nMode )
    {
        Intent sig = new Intent( ctxCaller, clsCalled ) ;
        sig.putExtra( Control.EXTRA_MODE, nMode ) ;
        ctxCaller.startActivity( sig ) ;
    }
}
