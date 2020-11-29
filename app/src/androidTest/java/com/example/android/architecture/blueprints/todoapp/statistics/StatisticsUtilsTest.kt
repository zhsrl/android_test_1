package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        val tasks = listOf<Task>(Task("title", "desc", isCompleted = false))

        val result = getActiveAndCompletedStats(tasks)

//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    internal fun getActiveAndCompleteStats(tasks: List<Task>?): StatsResult{

        val totalTasks = tasks!!.size
        val numberOfActiveTasks = tasks.count { it.isActive }
        val activePercent = 100 * numberOfActiveTasks / totalTasks
        val completePercent = 100 * (totalTasks - numberOfActiveTasks) / totalTasks

        return StatsResult(
                activeTasksPercent = activePercent.toFloat(),
                completedTasksPercent = completePercent.toFloat()
        )

    }
}