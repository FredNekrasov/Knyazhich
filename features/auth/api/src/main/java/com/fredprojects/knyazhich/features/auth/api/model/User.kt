package com.fredprojects.knyazhich.features.auth.api.model

/**
 * @param login логин
 * @param password пароль
 * @param email электронная почта
 * @param gender пол (true - мужской, false - женский)
 * @param birthday timestamp даты рождения (timestamp - это последовательность символов или закодированной информации, показывающей, когда произошло определённое событие)
 * @param name имя пользователя
 * @param patronymic отчество пользователя
 * @param surname фамилия пользователя
 */
data class User(
    val login: String,
    val password: String,
    val email: String,
    val gender: Boolean,
    val birthday: Long,
    val name: String,
    val patronymic: String,
    val surname: String
)