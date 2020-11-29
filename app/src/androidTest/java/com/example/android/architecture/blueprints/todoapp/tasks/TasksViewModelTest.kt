package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setsNewTaskEvent(){
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
//
//        tasksViewModel.addNewTask()

//        val observer = Observer<Event<Unit>> {}
//        try {
//
//            // Observe the LiveData forever
//            tasksViewModel.newTaskEvent.observeForever(observer)
//
//            // When adding a new task
//            tasksViewModel.addNewTask()
//
//            // Then the new task event is triggered
//            val value = tasksViewModel.newTaskEvent.value
//            assertThat(value?.getContentIfNotHandled(), (not(nullValue())))
//
//        } finally {
//            // Whatever happens, don't forget to remove the observer!
//            tasksViewModel.newTaskEvent.removeObserver(observer)
//        }
//
//        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
//
//        assertThat(value.getContentIfNotHandled(), not(nullValue()))

        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(
                value.getContentIfNotHandled(), (not(nullValue()))
        )



    }

    private lateinit var tasksViewModel: TasksViewModel

    // Executes each task synchronously using Architecture Components.

    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }


    @Test
    fun getTasksAddViewVisible() {

        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        // Then the "Add task" action is visible
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))
    }


}