package com.fredprojects.core.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Кастомный фрагмент с настройкой ViewBinding'а и некоторой защитой от утечек памяти.
 * Надо будет лишь переопределить методы [setUpViews] и [getCustomVB] для каждого фрагмента, которые будут использовать ViewBinding
 */
abstract class AbsFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    val binding get() = _binding!!

    /**
     * В этом методе надо возвращать кастомный ViewBinding класс.
     * Пример реализации:
     * ```kt
     * override fun getCustomVB(
     *      inflater: LayoutInflater,
     *      container: ViewGroup?
     * ): FragmentNameBinding = FragmentNameBinding.inflate(inflater, container, false)
     * ```
     */
    abstract fun getCustomVB(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View { // Inflate the layout for this fragment
        _binding = getCustomVB(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    /** В этом методе надо настраивать вьюшки (кнопки, текстовые поля и т.д.) **/
    abstract fun setUpViews()

    override fun onDestroyView() {
        super.onDestroyView()
        // https://developer.android.com/topic/libraries/view-binding#fragments
        // https://stackoverflow.com/questions/66119231/is-it-necessary-to-set-viewbinding-to-null-in-fragments-ondestroy
        /**
         * Почему надо это делать?
         * ViewBinding генерирует кастомный ViewBinding класс который будет сохранять ссылки на все вьюшки внутри фрагмента.
         * Фрагменты переживают свои представления. Поэтому если не очистить viewBinding, то все ссылки будут храниться в памяти, даже если не используешь их, что может привести к утечкам памяти.
         * Поэтому лучше присвоить ему null в конце жизненного цикла.
         */
        _binding = null
    }
}