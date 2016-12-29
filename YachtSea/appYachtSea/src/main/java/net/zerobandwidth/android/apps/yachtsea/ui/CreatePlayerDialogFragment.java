package net.zerobandwidth.android.apps.yachtsea.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import net.zerobandwidth.android.apps.yachtsea.R;
import net.zerobandwidth.android.apps.yachtsea.model.Player;

/**
 * Allows a user to input a player's name.
 *
 * Any activity that contains this fragment must implement the
 * {@link CreatePlayerDialogFragment.InteractionListener} interface if it wants
 * to handle interaction events.
 *
 * @since zerobandwidth-net/android-yachtsea 0.0.1
 */
public class CreatePlayerDialogFragment
extends DialogFragment
{
    /**
     * Activities including this fragment must implement this interface to catch
     * events passed back from the fragment.
     * @since zerobandwidth-net/android-yachtsea 0.0.1
     */
    public interface InteractionListener
    {
        /**
         * Handles the event where a user has created a new player.
         * @param player the created player
         */
        void onPlayerCreated( Player player ) ;

        /**
         * Handles the event where a user has cancelled the player creation
         * dialog.
         */
        void onPlayerCreationCancelled() ;
    }

    private InteractionListener m_listener = null ;

    /** Empty constructor required by API. */
    public CreatePlayerDialogFragment() {}

    @Override
    public Dialog onCreateDialog( Bundle bndlState )
    {
        final FragmentActivity act = this.getActivity() ;
        AlertDialog.Builder bldr = new AlertDialog.Builder( act ) ;
        LayoutInflater layer = act.getLayoutInflater() ;
        bldr.setTitle( R.string.title_create_player )
            .setView( layer.inflate( R.layout.fragment_yachtsea_create_player, null ) )
            .setPositiveButton( R.string.label_button_create_player_ok,
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick( DialogInterface dialog, int resID )
                    { CreatePlayerDialogFragment.this.returnPlayer() ; }
                })
            .setNegativeButton( R.string.label_button_cancel,
                new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick( DialogInterface dialog, int resID )
                    { CreatePlayerDialogFragment.this.cancel() ; }
                })
            ;
        return bldr.create() ;
    }

    @Override
    public void onAttach( Context ctx )
    {
        super.onAttach(ctx) ;
        if( ctx instanceof InteractionListener )
            m_listener = ((InteractionListener)(ctx)) ;
        else
        {
            throw new RuntimeException( ctx.getClass().getSimpleName()
                    + " must implement OnFragmentInteractionListener" ) ;
        }
    }

    @Override
    public void onDetach()
    {
        m_listener = null ;
        super.onDetach() ;
    }

    /**
     * Based on the inputs on the form, this method creates a {@link Player}
     * instance, populates its member fields, and returns it to the dialog's
     * listener.
     */
    protected void returnPlayer()
    {
        if( m_listener != null )
        {
            final EditText txtName = ((EditText)
                    (this.getDialog().findViewById(R.id.input_new_player_name))) ;
            final String sName = txtName.getText().toString() ;
            Player player = new Player() ;
            player.identify().setName( sName ) ;

            m_listener.onPlayerCreated( player ) ;
        }
    }

    /**
     * Cancels creation of a new player.
     */
    protected void cancel()
    {
        if( m_listener != null )
            m_listener.onPlayerCreationCancelled() ;
    }
}
