import java.io.File

val file = File("expenses.csv")

fun writeToFile(
    expenseList: List<Expense>
) {
    file.printWriter().use { writer ->
        writer.println("id,name,amount,category")
        
        expenseList.forEach {
            writer.println("${it.id},${it.name},${it.amount},${it.category}")
        }
    }
}

fun readFromFile(
    csvFile: File
): List<Expense> {
 
    val lines = csvFile.readLines()
    
    val expense = buildList {
        for(line in lines.drop(1)) {
            val columns = line.split(",")
            
            val id = columns[0].toLong()
            val name = columns[1]
            val amount = columns[2].toDouble()
            val category = columns[3]
            
            add(Expense(
                id = id,
                name = name,
                amount = amount,
                category = category
            ))            
        }
    }
    Expense.updateNextId(expense.maxOfOrNull { it.id } ?: 0L)
    return expense
}