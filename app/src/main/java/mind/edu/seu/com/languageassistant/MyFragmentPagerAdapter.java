package mind.edu.seu.com.languageassistant;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import mind.edu.seu.com.languageassistant.SecondFragment.SecondFragment;

/**
 * Created by Mind on 2017/3/15.
 */
class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public final int COUNT = 3;
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    //传递给已经生成的fragment参数调用的
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      return  super.instantiateItem(container,position);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return  FirstFragment.newInstance(position);
        if(position==1)
            return  new SecondFragment();
        return new Fragment();
    }

    @Override
    public int getCount() {
        return COUNT;
    }



}