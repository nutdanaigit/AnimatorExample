package ayp.aug.testanimator;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by Nutdanai on 9/18/2016.
 */
public class AnimaFragment extends Fragment {

    public static AnimaFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AnimaFragment fragment = new AnimaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View mSceneView;
    private View mSunView;
    private View mSkyView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_anima,container,false);
        mSceneView = v;
        mSkyView = v.findViewById(R.id.sky);
        mSunView = v.findViewById(R.id.sun);

        mSceneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimator();
            }
        });

        return v;
    }

    public void startAnimator(){
        float sunStart = mSunView.getTop();
        float sunEnd = mSkyView.getHeight();

        ObjectAnimator  ob = ObjectAnimator.ofFloat(mSunView,"y",sunStart,sunEnd)
                .setDuration(3000);
        ob.setInterpolator(new AccelerateInterpolator());
        ob.start();
    }
}
