
val expenseList = mutableListOf<Expense>()



fun main() {
    
    var command: String? = null
    
    while(command?.lowercase() != "exit") {
        print("Type a command: ")
        command = readln()
        when(command) {
            "add" -> {
                print("Type name of the expense: ")
                val name = readln()
                print("Amount: ")
                val amount = readln().toDoubleOrNull()
                if(amount == null) {
                    println("Wrong expense amount")
                    continue
                }
                print("Which Category: ")
                val category = readln()
                expenseList.add(
                    Expense(
                        name = name,
                        amount = amount,
                        category = category
                    )
                )
                println("Expense Added Successfully")
            }
        }
    }
}