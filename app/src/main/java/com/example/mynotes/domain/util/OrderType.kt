package com.example.mynotes.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
