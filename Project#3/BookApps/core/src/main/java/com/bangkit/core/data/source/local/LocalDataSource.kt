package com.bangkit.core.data.source.local

import com.bangkit.core.data.source.local.entity.BookEntity
import com.bangkit.core.data.source.local.entity.DetailBookEntity
import com.bangkit.core.data.source.local.room.BookDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val bookDao: BookDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(bookDao: BookDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(bookDao)
            }
    }

    fun getAllBook(): Flow<List<BookEntity>> = bookDao.getAllBook()

    fun getFavoriteBook(): Flow<List<BookEntity>> = bookDao.getFavoriteBook()

    suspend fun insertBook(bookList: List<BookEntity>) = bookDao.insertBook(bookList)

    fun setFavoriteBook(book: BookEntity, newState: Boolean) {
        book.isFavorite = newState
        bookDao.updateFavoriteBook(book)
    }

    fun getDetailBook(id: String): Flow<DetailBookEntity> = bookDao.getdetailBook(id)

    suspend fun insertdetailBook(detailBook: DetailBookEntity) =
        bookDao.insertdetailBook(detailBook)
}