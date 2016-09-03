package com.mikexapp.mikex.mikexapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikexapp.mikex.mikexapp.R;
import com.mikexapp.mikex.mikexapp.model.AppInfo;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by mike on 16-8-29.
 */

public class InstalledAppAdapter extends AppBaseAdapter {

    public InstalledAppAdapter(Context context, List<AppInfo> appInfoList, int startType) {
        super(context, appInfoList, startType);
    }
}

