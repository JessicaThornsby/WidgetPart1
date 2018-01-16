package com.jessicathornsby.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
public class NewAppWidget extends AppWidgetProvider {
    static void updateAppWidget(Context context,
                                AppWidgetManager appWidgetManager,
                                int appWidgetId) {
// Instantiate the RemoteViews object based on the application widget layout//
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//Update your app’s text, using the setTextViewText method of the RemoteViews class//
        views.setTextViewText(R.id.id_value, String.valueOf(appWidgetId));
//Register the onClickListener//
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://code.tutsplus.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.launch_url, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Update all instances of this widget//
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}

