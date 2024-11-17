package com.example.armandoapp.background_process

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class CustomWorker constructor(
    context: Context,
    workerParameters: WorkerParameters,
):CoroutineWorker(context,workerParameters){
    override suspend fun doWork(): Result{
        println("Hello from worker!")
        return Result.success()
    }
}