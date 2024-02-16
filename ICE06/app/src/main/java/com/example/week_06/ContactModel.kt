package com.example.week_06


data class ContactModel(
    val FullName: String,
    val ContactNumber: String,
    val EmailAddress: String
)
{
    /**
     * Overridden toString method
     */
    override fun toString(): String
    {
        return """Full Name: $FullName, Contact Number: $ContactNumber, Email Address: $EmailAddress """
    }
}
