package cute.kittens;

import java.util.ArrayList;
import android.app.ListActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class CuteKittensActivity extends ListActivity {
	
	private ArrayList<Sound> mSounds = null;
	private SoundAdapter mAdapter = null;
	static MediaPlayer mMediaPlayer = null;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //create a simple list
        mSounds = new ArrayList<Sound>();
        Sound s = new Sound();
        s.setDescription("Mr. Fluffy");
        s.setIconResourceId(R.drawable.kitten1);
        s.setSoundResourceId(R.raw.kitten);
        mSounds.add(s);
        s = new Sound();
        s.setDescription("Mr. Bigglesworth");
        s.setIconResourceId(R.drawable.kitten2);
        s.setSoundResourceId(R.raw.lion);
        mSounds.add(s);
        s = new Sound();
        s.setDescription("Mr. Meow");
        s.setIconResourceId(R.drawable.kitten3);
        s.setSoundResourceId(R.raw.scream);
        mSounds.add(s);
        mAdapter = new SoundAdapter(this, R.layout.images, mSounds);
        setListAdapter(mAdapter);
    }
    
    @Override
    public void onListItemClick(ListView parent, View v, int position, long id){
    	Sound s = (Sound) mSounds.get(position);
    	MediaPlayer mp = MediaPlayer.create(this, s.getSoundResourceId());
    	mp.start();
    }

}