package com.mikexapp.mikex.mikexapp.fragment;



import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.utils.ConstantsUtils;

/**
 * Created by mike on 16-8-27.
 */

public class InstalledAppFragment extends AppBaseFragment {

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_installed_app, container, false);
        mListView = (ListView) view.findViewById(R.id.list_view_installed_app);
        this.mStartType = getArguments().getInt(ConstantsUtils.START_TYPE);
        startLoadAppsList();
        return view;
    }
}
