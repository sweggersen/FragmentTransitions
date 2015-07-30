package info.awesomedevelopment.fragmenttransitions;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailFragment extends AFragment {

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_detail;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView iv = (ImageView) view.findViewById(R.id.image);
        iv.setTransitionName(MainActivity.IMG_URL);
        Picasso.with(getActivity()).load(MainActivity.IMG_URL).into(iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivity.changeFragment(new MainFragment(), iv);
            }
        });
    }
}
