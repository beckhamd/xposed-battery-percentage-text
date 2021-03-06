package com.extrinsic.batterypercentagetext;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    public static final String ACTION_PREF_LOCK_SCREEN_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_LOCK_SCREEN_CHANGED";
    public static final String EXTRA_PREF_LOCK_SCREEN_ENABLED = "com.extrinsic.batterypercentagetext.extra.PREF_LOCK_SCREEN_ENABLED";
    public static final String PREF_LOCK_SCREEN = "pref_lock_screen";

    public static final String ACTION_PREF_LOCK_SCREEN_FONT_SIZE_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_LOCK_SCREEN_FONT_SIZE_CHANGED";
    public static final String EXTRA_PREF_LOCK_SCREEN_FONT_SIZE = "com.extrinsic.batterypercentagetext.extra.PREF_LOCK_SCREEN_FONT_SIZE";
    public static final String PREF_LOCK_SCREEN_FONT_SIZE = "pref_lock_screen_font_size";

    public static final String ACTION_PREF_LOCK_SCREEN_FONT_STYLE_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_LOCK_SCREEN_FONT_STYLE_CHANGED";
    public static final String EXTRA_PREF_LOCK_SCREEN_FONT_STYLE = "com.extrinsic.batterypercentagetext.extra.PREF_LOCK_SCREEN_FONT_STYLE";
    public static final String PREF_LOCK_SCREEN_FONT_STYLE = "pref_lock_screen_font_style";

    public static final String ACTION_PREF_LOCK_SCREEN_POSITION_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_LOCK_SCREEN_POSITION_CHANGED";
    public static final String EXTRA_PREF_LOCK_SCREEN_POSITION = "com.extrinsic.batterypercentagetext.extra.PREF_LOCK_SCREEN_POSITION";
    public static final String PREF_LOCK_SCREEN_POSITION = "pref_lock_screen_position";

    public static final String ACTION_PREF_NOTIFICATION_SHADE_HEADER_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_NOTIFICATION_SHADE_HEADER_CHANGED";
    public static final String EXTRA_PREF_NOTIFICATION_SHADE_HEADER_ENABLED = "com.extrinsic.batterypercentagetext.extra.PREF_NOTIFICATION_SHADE_HEADER_ENABLED";
    public static final String PREF_NOTIFICATION_SHADE_HEADER = "pref_notification_shade_header";

    public static final String ACTION_PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE_CHANGED";
    public static final String EXTRA_PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE = "com.extrinsic.batterypercentagetext.extra.PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE";
    public static final String PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE = "pref_notification_shade_header_font_size";

    public static final String ACTION_PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE_CHANGED";
    public static final String EXTRA_PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE = "com.extrinsic.batterypercentagetext.extra.PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE";
    public static final String PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE = "pref_notification_shade_header_font_style";

    public static final String ACTION_PREF_NOTIFICATION_SHADE_HEADER_POSITION_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_NOTIFICATION_SHADE_HEADER_POSITION_CHANGED";
    public static final String EXTRA_PREF_NOTIFICATION_SHADE_HEADER_POSITION = "com.extrinsic.batterypercentagetext.extra.PREF_NOTIFICATION_SHADE_HEADER_POSITION";
    public static final String PREF_NOTIFICATION_SHADE_HEADER_POSITION = "pref_notification_shade_header_position";

    public static final String ACTION_PREF_STATUS_BAR_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_STATUS_BAR_CHANGED";
    public static final String EXTRA_PREF_STATUS_BAR_ENABLED = "com.extrinsic.batterypercentagetext.extra.PREF_STATUS_BAR_ENABLED";
    public static final String PREF_STATUS_BAR = "pref_status_bar";

    public static final String ACTION_PREF_STATUS_BAR_FONT_SIZE_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_STATUS_BAR_FONT_SIZE_CHANGED";
    public static final String EXTRA_PREF_STATUS_BAR_FONT_SIZE = "com.extrinsic.batterypercentagetext.extra.PREF_STATUS_BAR_FONT_SIZE";
    public static final String PREF_STATUS_BAR_FONT_SIZE = "pref_status_bar_font_size";

    public static final String ACTION_PREF_STATUS_BAR_FONT_STYLE_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_STATUS_BAR_FONT_STYLE_CHANGED";
    public static final String EXTRA_PREF_STATUS_BAR_FONT_STYLE = "com.extrinsic.batterypercentagetext.extra.PREF_STATUS_BAR_FONT_STYLE";
    public static final String PREF_STATUS_BAR_FONT_STYLE = "pref_status_bar_font_style";

    public static final String ACTION_PREF_STATUS_BAR_POSITION_CHANGED = "com.extrinsic.batterypercentagetext.action.ACTION_PREF_STATUS_BAR_POSITION_CHANGED";
    public static final String EXTRA_PREF_STATUS_BAR_POSITION = "com.extrinsic.batterypercentagetext.extra.PREF_STATUS_BAR_POSITION";
    public static final String PREF_STATUS_BAR_POSITION = "pref_status_bar_position";

    public static final String PREF_HIDE_LAUNCHER_ICON = "pref_hide_launcher_icon";

    public static final int PREF_FONT_SIZE_SMALL = 0;
    public static final int PREF_FONT_SIZE_NORMAL = 1;
    public static final int PREF_FONT_SIZE_LARGE = 2;

    public static final int PREF_FONT_STYLE_NORMAL = 0;
    public static final int PREF_FONT_STYLE_ITALIC = 1;
    public static final int PREF_FONT_STYLE_BOLD = 2;
    public static final int PREF_FONT_STYLE_BOLD_ITALIC = 3;

    public static final int PREF_POSITION_LEFT = 0;
    public static final int PREF_POSITION_RIGHT = 1;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        getPreferenceManager().setSharedPreferencesMode(Context.MODE_WORLD_READABLE);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Intent intent = new Intent();

        switch (key) {
            case PREF_LOCK_SCREEN:
                intent.setAction(ACTION_PREF_LOCK_SCREEN_CHANGED);
                intent.putExtra(EXTRA_PREF_LOCK_SCREEN_ENABLED, sharedPreferences.getBoolean(key, false));
                break;
            case PREF_LOCK_SCREEN_FONT_SIZE:
                intent.setAction(ACTION_PREF_LOCK_SCREEN_FONT_SIZE_CHANGED);
                intent.putExtra(EXTRA_PREF_LOCK_SCREEN_FONT_SIZE, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_LOCK_SCREEN_FONT_STYLE:
                intent.setAction(ACTION_PREF_LOCK_SCREEN_FONT_STYLE_CHANGED);
                intent.putExtra(EXTRA_PREF_LOCK_SCREEN_FONT_STYLE, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_LOCK_SCREEN_POSITION:
                intent.setAction(ACTION_PREF_LOCK_SCREEN_POSITION_CHANGED);
                intent.putExtra(EXTRA_PREF_LOCK_SCREEN_POSITION, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_NOTIFICATION_SHADE_HEADER:
                intent.setAction(ACTION_PREF_NOTIFICATION_SHADE_HEADER_CHANGED);
                intent.putExtra(EXTRA_PREF_NOTIFICATION_SHADE_HEADER_ENABLED, sharedPreferences.getBoolean(key, false));
                break;
            case PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE:
                intent.setAction(ACTION_PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE_CHANGED);
                intent.putExtra(EXTRA_PREF_NOTIFICATION_SHADE_HEADER_FONT_SIZE, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE:
                intent.setAction(ACTION_PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE_CHANGED);
                intent.putExtra(EXTRA_PREF_NOTIFICATION_SHADE_HEADER_FONT_STYLE, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_NOTIFICATION_SHADE_HEADER_POSITION:
                intent.setAction(ACTION_PREF_NOTIFICATION_SHADE_HEADER_POSITION_CHANGED);
                intent.putExtra(EXTRA_PREF_NOTIFICATION_SHADE_HEADER_POSITION, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_STATUS_BAR:
                intent.setAction(ACTION_PREF_STATUS_BAR_CHANGED);
                intent.putExtra(EXTRA_PREF_STATUS_BAR_ENABLED, sharedPreferences.getBoolean(key, false));
                break;
            case PREF_STATUS_BAR_FONT_SIZE:
                intent.setAction(ACTION_PREF_STATUS_BAR_FONT_SIZE_CHANGED);
                intent.putExtra(EXTRA_PREF_STATUS_BAR_FONT_SIZE, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_STATUS_BAR_FONT_STYLE:
                intent.setAction(ACTION_PREF_STATUS_BAR_FONT_STYLE_CHANGED);
                intent.putExtra(EXTRA_PREF_STATUS_BAR_FONT_STYLE, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_STATUS_BAR_POSITION:
                intent.setAction(ACTION_PREF_STATUS_BAR_POSITION_CHANGED);
                intent.putExtra(EXTRA_PREF_STATUS_BAR_POSITION, Integer.parseInt(sharedPreferences.getString(key, "")));
                break;
            case PREF_HIDE_LAUNCHER_ICON:
                ComponentName componentName = new ComponentName(getActivity(), "com.extrinsic.batterypercentagetext.SettingsActivityAlias");
                int state = sharedPreferences.getBoolean(key, false) ? PackageManager.COMPONENT_ENABLED_STATE_DISABLED : PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
                getActivity().getPackageManager().setComponentEnabledSetting(componentName, state, PackageManager.DONT_KILL_APP);
        }

        if (intent.getAction() != null) {
            getActivity().sendBroadcast(intent);
        }
    }
}
