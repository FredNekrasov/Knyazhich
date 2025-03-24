package com.fredprojects.knyazhich.features.auth.api.storage

import com.fredprojects.knyazhich.features.auth.api.model.User

/**
 * IUserStorage предоставляет методы для сохранения и получения данных о пользователе.
 * Он также предоставляет константу USER_KEY, по которому сохраняются данные.
 * Этот интерфейс необходим, чтобы обращаться к данным о пользователе из разных модулей.
 */
interface IUserStorage {
    /**
     * Метод сохраняет данные о пользователе в по ключу [USER_KEY].
     * @param user объект User, который содержит данные, необходимые для сохранения.
     */
    fun save(user: User)

    /**
     * Метод возвращает данные о пользователе по ключу [USER_KEY]
     * @return [User] если данные ранее были сохранены, иначе null
     **/
    fun get(): User?

    companion object {
        /** Константа USER_KEY, по которому получаем данные о пользователе или сохраням их. **/
        const val USER_KEY = "USER_PD.KEY"
    }
}