package com.eve.engine.esi4k.resource

import com.eve.engine.esi4k.Datasource
import com.eve.engine.esi4k.ESIClient
import com.eve.engine.esi4k.ESIResponse
import com.eve.engine.esi4k.Version
import com.eve.engine.esi4k.model.Bookmark
import com.eve.engine.esi4k.model.BookmarkFolder
import java.awt.print.Book

class BookmarkResources(esiClient: ESIClient,  datasource: Datasource): ESIResources(esiClient,datasource) {

    fun characterBookmarksRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/bookmarks")
    }

    fun characterBookmarks(characterId: Int): ReifyResult<List<Bookmark>> {
        return characterBookmarks(characterBookmarksRaw(characterId))
    }

    fun characterBookmarks(esiResponse: ESIResponse): ReifyResult<List<Bookmark>> {
        return responseToEntityList(esiResponse)
    }

    fun characterBookmarkFoldersRaw(characterId: Int): ESIResponse {
        return callExecute("/characters/$characterId/bookmarks/folders")
    }

    fun characterBookmarkFolders(characterId: Int): ReifyResult<List<BookmarkFolder>> {
        return characterBookmarkFolders(characterBookmarkFoldersRaw(characterId))
    }

    fun characterBookmarkFolders(esiResponse: ESIResponse): ReifyResult<List<BookmarkFolder>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationBookmarksRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/bookmarks")
    }

    fun corporationBookmarks(corporationId: Int): ReifyResult<List<Bookmark>> {
        return corporationBookmarks(corporationBookmarksRaw(corporationId))
    }

    fun corporationBookmarks(esiResponse: ESIResponse): ReifyResult<List<Bookmark>> {
        return responseToEntityList(esiResponse)
    }

    fun corporationBookmarkFoldersRaw(corporationId: Int): ESIResponse {
        return callExecute("/corporations/$corporationId/bookmarks/folders")
    }

    fun corporationBookmarkFolders(corporationId: Int): ReifyResult<List<BookmarkFolder>> {
        return corporationBookmarkFolders(corporationBookmarkFoldersRaw(corporationId))
    }

    fun corporationBookmarkFolders(esiResponse: ESIResponse): ReifyResult<List<BookmarkFolder>> {
        return responseToEntityList(esiResponse)
    }
}