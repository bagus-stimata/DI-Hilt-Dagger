package com.example.di_basic_kotlin

data class User (
    var firstName: String,
    var lastname: String) {

    override fun toString(): String {
        return "User(firstName='$firstName', lastname='$lastname')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (firstName != other.firstName) return false
        if (lastname != other.lastname) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastname.hashCode()
        return result
    }

}