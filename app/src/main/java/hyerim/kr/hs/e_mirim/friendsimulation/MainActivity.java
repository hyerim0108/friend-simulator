package hyerim.kr.hs.e_mirim.friendsimulation;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String TAG ="최민경:Main";
    private ImageView mImageViewFriendVisual;
    private MediaPlayer mMediaPlayer;
    private Vibrator mVib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate 메소드 호출");
        setContentView(R.layout.activity_main);
        mImageViewFriendVisual=(ImageView) findViewById(R.id.friend_visual);
        Log.d(TAG,"activity_main 레이아웃 세팅");
        mMediaPlayer=MediaPlayer.create(this, R.raw.a02); //01배고파02불끌게03으아아아04안녕05젤리먹을래?
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();
        mVib=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        mVib.vibrate(2000);
    }

    protected void onDestroy(){
        super.onDestroy();
        mMediaPlayer.pause();
        mMediaPlayer.stop();
    }
    void onClick(View view){
        Log.d(TAG,"onClick 메소드 호출");
        Log.d(TAG,"클릭된 뷰 id : "+view.getId());
        mVib.vibrate(1000);
        if(mMediaPlayer.isPlaying()){
            mMediaPlayer.pause();
        }
        switch (view.getId()){
            case R.id.button1:
                Log.d(TAG,"버튼1 클릭");
                mImageViewFriendVisual.setImageResource(R.drawable.six);
                Toast.makeText(this, "안녕", Toast.LENGTH_SHORT).show();
                mMediaPlayer=MediaPlayer.create(this, R.raw.a04);
                mMediaPlayer.start();
                break;
            case R.id.button2:
                Log.d(TAG,"버튼2 클릭");
                mImageViewFriendVisual.setImageResource(R.drawable.two);
                Toast.makeText(this, "으아아아아", Toast.LENGTH_SHORT).show();
                mMediaPlayer=MediaPlayer.create(this, R.raw.a03);
                mMediaPlayer.start();
                break;
            case R.id.button3:
                Log.d(TAG,"버튼3 클릭");
                mImageViewFriendVisual.setImageResource(R.drawable.one);
                Toast.makeText(this, "배고파", Toast.LENGTH_SHORT).show();
                mMediaPlayer=MediaPlayer.create(this, R.raw.a01);
                mMediaPlayer.start();
                break;
            case R.id.button4:
                Log.d(TAG,"버튼4 클릭");
                mImageViewFriendVisual.setImageResource(R.drawable.three);
                Toast.makeText(this, "젤리 먹을래?", Toast.LENGTH_SHORT).show();
                mMediaPlayer=MediaPlayer.create(this, R.raw.a05);
                mMediaPlayer.start();
                break;
            case R.id.button5:
                Log.d(TAG,"버튼5 클릭");
                mImageViewFriendVisual.setImageResource(R.drawable.four);
                Toast.makeText(this, "불끌게", Toast.LENGTH_SHORT).show();
                mMediaPlayer=MediaPlayer.create(this, R.raw.a02);
                mMediaPlayer.start();
                break;
            default:
                Log.e(TAG,"모르는 녀석 클릭");
                Toast.makeText(this, "뭐라는지 모르겠어염", Toast.LENGTH_SHORT).show();
                mMediaPlayer=MediaPlayer.create(this, R.raw.a04);
                mMediaPlayer.start();
                break;
        }

    }
}
