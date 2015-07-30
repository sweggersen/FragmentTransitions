package info.awesomedevelopment.fragmenttransitions;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.TransitionSet;
import android.view.View;


public class MainActivity extends Activity {

    public static final String IMG_URL = "http://i.imgur.com/VYR6061.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction
                .replace(
                        R.id.fragment,
                        fragment,
                        "fragment"
                )
                .commit();
    }

    public void changeFragment(Fragment fragment, View sharedElement) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        TransitionSet enterTransition = new TransitionSet();
        enterTransition.addTransition(new ChangeBounds());
        enterTransition.addTransition(new ChangeImageTransform());

        fragment.setSharedElementEnterTransition(enterTransition);

        transaction.addSharedElement(sharedElement, sharedElement.getTransitionName());

        completeTransaction(transaction, fragment);
    }

    private void completeTransaction(FragmentTransaction transaction, Fragment fragment) {
        transaction
                .replace(
                        R.id.fragment,
                        fragment,
                        "fragment"
                )
                .addToBackStack(null)
                .commit();
    }
}
