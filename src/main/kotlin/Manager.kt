package main.kotlin

import Task
import java.io.File

class Manager {
    private var tasks = mutableListOf<Task>()

    // Adds a Task element to the task collection
    fun addTask(newTask: Task) {
        tasks.add(newTask)
    }

    //Removes a task from the tasks collection based on a given int
    fun removeTask(choice: Int) {
        val choice1 = choice-1
        tasks.removeAt(choice1)
    }

    // Calls the display function of each task element in the tasks collection
    fun displayAll() {
        for(task in tasks) {
            task.display()
            println()
        }
    }

    // Saves the tasks collection to a file with each task
    // saved to a individule line of the file
    // The filename is provided at function declaration
    fun saveToFile(fileName: String) {
        val file = File(fileName)
        file.writeText("${tasks[0].text}")

        for(x in 1 until tasks.size) {
            file.appendText("\n")
            file.appendText("$${tasks[x].text}")
        }
    }

    // Loads tasks from a provided filename
    // each line of the file is added to tasks
    // as a single Task element
    fun loadFromFile(fileName: String) {
        val file = File(fileName)
        val lines = file.readLines()
        for(line in lines) {
            val task = Task()
            task.text = line
            tasks.add(task)
        }

    }
}