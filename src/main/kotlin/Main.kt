package main.kotlin
import Task
fun main() {
    Main().main()
}
class Main {
    // Main function of the program that drives the function
    // It provides the user with a menu to navigate the program
    // and calls the code to run the users choices
    fun main() {
        val manager = Manager()
        var userSelect = -1
        while(userSelect != 6) {
            println("1. Add Task")
            println("2. Remove Task")
            println("3. Display")
            println("4. Load List")
            println("5. Save List")
            println("6. Quit")

            print("What would you like to do: ")
            val userInput = readln()

            userSelect = userInput.toInt()

            when (userSelect) {
                1 -> {
                    val task = Task()
                    print("Enter the Task: ")
                    task.text = readln()
                    manager.addTask(task)
                }
                2 -> {
                    manager.displayAll()
                    println("Which would you like to remove: ")
                    val choice = readln()
                    manager.removeTask(choice.toInt())

                }
                3 -> {manager.displayAll()}
                4 -> {
                    print("What is the filename: ")
                    val file = readln()
                    manager.loadFromFile(file)
                }
                5 -> {
                    print("What is the filename: ")
                    val file = readln()
                    manager.saveToFile(file)
                }
            }
        }
    }
}