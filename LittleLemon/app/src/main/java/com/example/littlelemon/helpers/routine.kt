package com.example.littlelemon.helpers

import com.example.littlelemon.database.AppDatabase
import com.example.littlelemon.database.MenuItemNetwork
import com.example.littlelemon.database.MenuNetwork
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

fun validateRegData(firstName: String, lastName: String, email: String): Boolean {
    var validated = false

    if (firstName.isNotBlank() && lastName.isNotBlank() && email.isNotBlank()) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) validated = true
    }

    return validated
}


suspend fun fetchMenu(url: String): List<MenuItemNetwork> {
    val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
    val httpResponse: MenuNetwork = httpClient.get(url).body()
    return httpResponse.items
}


fun saveMenuToDatabase(database: AppDatabase, menuItemsNetwork: List<MenuItemNetwork>) {
    val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
    database.menuItemDao().insertAll(*menuItemsRoom.toTypedArray())
}