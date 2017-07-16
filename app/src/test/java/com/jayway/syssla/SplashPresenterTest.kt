package com.jayway.syssla

import com.jayway.syssla.db.Db
import com.jayway.syssla.model.User
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class SplashPresenterTest {

    lateinit var presenter: SplashPresenter

    @Before
    fun before_test() {
        presenter = SplashPresenter()
    }

    @Test
    fun if_user_exists_the_user_exists_operation_should_return_true() {
        var mockDb: Db = mock()

        whenever(mockDb.getUser()).thenReturn(User("bob", "123"))

        presenter.userExists(db = mockDb) shouldEqual true
    }

    @Test
    fun if_user_does_not_exist_the_user_exists_operation_should_return_false() {
        var mockDb: Db = mock()

        whenever(mockDb.getUser()).thenReturn(null)

        presenter.userExists(db = mockDb) shouldEqual false
    }
}
