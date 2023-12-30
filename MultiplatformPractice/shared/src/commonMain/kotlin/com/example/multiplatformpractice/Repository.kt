package com.example.multiplatformpractice

class Repository {

    private val githubDataSource = GithubDataSource()

    private val stringDataSource = StringDataSource()

    suspend fun getGitHubRepository(string: String) {
        return githubDataSource.getGithubUserInfo(string)
    }

    fun getSavedString() : String =
        stringDataSource.getSavedString()

    fun saveString(string: String) =
        stringDataSource.saveString(string)
}