package com.januar.mywidgets

import android.app.job.JobParameters
import android.app.job.JobService
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.widget.RemoteViews
import kotlin.random.Random

class UpdateWidgetService: JobService() {
    override fun onStopJob(p0: JobParameters?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onStartJob(jobParameters: JobParameters): Boolean {
        val manager = AppWidgetManager.getInstance(this)
        val view = RemoteViews(packageName, R.layout.random_widget_number)
        val theWidget = ComponentName(this, RandomWidgetNumber::class.java)
        val lastUpdate = "Random" + NumberGenerator.generate(100)
        view.setTextViewText(R.id.appwidget_text, lastUpdate)
        manager.updateAppWidget(theWidget, view)
        jobFinished(jobParameters, false)
        return true
    }
}