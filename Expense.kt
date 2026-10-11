data class Expense(
    val id: Long = generateId(),
    val name: String,
    val amount: Double,
    val category: String
) {
    companion object {

        private var nextId = 1L

        private fun generateId(): Long {
            return nextId++
        }
    }
}
