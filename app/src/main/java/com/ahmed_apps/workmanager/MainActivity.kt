package com.ahmed_apps.workmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.ahmed_apps.workmanager.ui.theme.WorkManagerTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.Duration
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWorker()
        setContent {
            WorkManagerTheme {

            }
        }
    }

    private fun perWorker() { //oneTimeRequest
//constrains الشروط
        val constraints = Constraints.Builder().setRequiresCharging(true).build()

        val workRequest =
            PeriodicWorkRequestBuilder<DataSyncWorker>(1, TimeUnit.HOURS).setBackoffCriteria(
                backoffPolicy = BackoffPolicy.LINEAR, duration = Duration.ofSeconds(15)
            ).setConstraints(constraints).build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }
//

    private fun initWorker() { //oneTimeRequest
//constrains الشروط
        val constraints = Constraints.Builder().setRequiresCharging(true).build()

        val workRequest = OneTimeWorkRequestBuilder<DataSyncWorker>().setBackoffCriteria(
            backoffPolicy = BackoffPolicy.LINEAR, duration = Duration.ofSeconds(15)
        ).setConstraints(constraints).build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }

}











