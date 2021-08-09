package com.example.harajtask.base

import com.example.harajtask.essential.util.StaticHelper
import com.example.harajtask.util.InstantExecutorExtension
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit

@ExperimentalCoroutinesApi
@ExtendWith(InstantExecutorExtension::class)
abstract class BaseUnitTest {
    protected val staticHelper = mock<StaticHelper>()
    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Rule
    @JvmField
    val mockitoRule = MockitoJUnit.rule()!!

    @BeforeEach
    open fun before() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(this.testCoroutineDispatcher)

        whenever(staticHelper.getSystemTimeInMillis()).thenReturn(1_628_473_561_000)
    }

    @AfterEach
    open fun after() {
        Dispatchers.resetMain()
    }
}