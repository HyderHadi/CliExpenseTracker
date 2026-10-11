val expenseList = mutableListOf<Expense>()


fun main() {

    var command: String? = null

    while (command?.lowercase() != "exit") {
        println(
            """
            (((  Expense Tracker  )))
            1 - Add
            2 - Delete
            3 - List
            """.trimIndent()
        )
        print("Type a command: ")
        command = readln()
        when (command) {
            "add" -> {
                print("Type name of the expense: ")
                val name = readln()
                print("Amount: ")
                val amount = readln().toDoubleOrNull()
                if (amount == null) {
                    println("Wrong expense amount")
                    continue
                }
                print("Which Category: ")
                var category = readln().isEmpty { "Untitled" }
                expenseList.add(
                    Expense(
                        name = name,
                        amount = amount,
                        category = category
                    )
                )
                println("Expense Added Successfully")
            }

            "delete" -> {
                print("Type the id number of an expense to delete: ")
                val tmpId = readln().toLongOrNull()
                if (!expenseList.removeIf { it.id == tmpId }) {
                    println("Expense Doesn't Exist")
                    continue
                }
                println("Successful Deletion")
            }

            "list" -> {
                expenseList.forEach {
                    println("ID: ${it.id}, ${it.name}, Cost: ${it.amount}, Category: ${it.category}")
                }
            }
        }
    }
}
