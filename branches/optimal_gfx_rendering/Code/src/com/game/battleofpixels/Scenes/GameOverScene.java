package com.game.battleofpixels.Scenes;

import android.os.Handler;
import android.os.Message;

import com.game.battleofpixels.MessageHandler;
import com.game.battleofpixels.MsgType;
import com.game.battleofpixels.DagActivity.SceneType;
import com.game.battleofpixels.MessageHandler.MsgReceiver;

/**
 * A specific scene for the "Game Over" screen.
 * @author Ying
 *
 */
public class GameOverScene extends Scene 
{
	/**
	 * Initializes and sets the handler callback.
	 */
	public GameOverScene()
	{
		super();
		
		this.handler = new Handler() 
		{
	        public void handleMessage(Message msg) 
	        {
	        	// If the "ok" button (which is the only button in the scene) is clicked, go back to the menu
	        	if(msg.what == MsgType.BUTTON_CLICK.ordinal())
	        	{
	        		MessageHandler.Get().Send(MsgReceiver.ACTIVITY, MsgType.ACTIVITY_CHANGE_SCENE, SceneType.MENU_SCENE.ordinal());
	        	}
	        	// If the activity tells us to stop, we stop.
	        	else if(msg.what == MsgType.STOP_SCENE.ordinal())
	        	{
	        		runScene = false;
	        	}
	        	
	        }
	    };
	}
	
	@Override
	public void End() {

	}

	@Override
	public void Start() {

	}

	/**
	 * The only update done is to update the profiler in the activity.
	 */
	@Override
	public void Update() 
	{
		MessageHandler.Get().Send(MsgReceiver.ACTIVITY, MsgType.UPDATE_LOGIC_PROFILER);
	}

}
