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
            4 - Search
            5 - Total
            6 - Category-total
            7 - Exit
            (Commands are case insensitive)
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
                var category = readln().ifEmpty { "Untitled" }
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

            "search" -> {
                print("Search Here(by expense name): ")
                val searchString = readln()
                val tmpList = expenseList.filter { it.name.contains(searchString, ignoreCase = true) }
                if (tmpList.isEmpty()) {
                    println("No matching result")
                    continue
                }
                println("<<<Search Result>>>")
                tmpList.forEach {
                    println("ID: ${it.id}, ${it.name}, Cost: ${it.amount}, Category: ${it.category}")
                }
            }

            "total" -> {
                var totalExpenditure: Double = 0.0
                expenseList.forEach {
                    totalExpenditure = totalExpenditure + it.amount
                }
                println("Total Expenses: ${totalExpenditure} IQD")
            }

            "category-total" -> {
                val totalByCategory = mutableMapOf<String, Double>()
                expenseList.forEach {
                    totalByCategory[it.category] = totalByCategory.getOrDefault(it.category, 0.0) + it.amount
                }
                totalByCategory.forEach { category, total ->
                    println("Category: ${category}, Total: ${total}")
                }
            }
        }
    }
}
