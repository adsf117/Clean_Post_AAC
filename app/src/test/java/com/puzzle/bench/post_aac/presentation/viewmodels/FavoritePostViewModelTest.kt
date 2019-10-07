package com.puzzle.bench.post_aac.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.puzzle.bench.post_aac.data.PostStorageImpl
import com.puzzle.bench.post_aac.utils.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

class FavoritePostViewModelTest {

    private val postStorageImpl = mock<PostStorageImpl>()

    private lateinit var viewModel: FavoritePostViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Before
    fun setUp() {
        viewModel = FavoritePostViewModel(postStorageImpl)
    }

    @Test
    fun getAllFavoritePostLiveData() {
        viewModel.allFavoritePostLiveData
        runBlocking {
            verify(postStorageImpl).getAllFavoritePost()
        }
    }
}