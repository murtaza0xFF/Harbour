package com.murtaza0xff.harbour.user

import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.Request

class UserService {

    private val BASE_WEB_URL = "https://news.ycombinator.com/"
    private val LOGIN_PARAM_ACCOUNT = "acct"
    private val LOGIN_PARAM_PASSWORD = "pw"
    private val LOGIN_PARAM_GOTO = "goto"
    private val LOGIN_PARAM_REDIRECT = "news"
    private val LOGIN_PARAM_CREATING = "creating"
    private val LOGIN_PARAM_CREATING_VAL = "t"
    private val COMMENT_PATH = "comment"
    private val LOGIN_PATH = "login"
    private val PARAM_ID = "Id"
    private val VOTE_HOW = "how"
    private val VOTE_UP = "up"
    private val VOTE_PATH = "vote"
    private val COMMENT_PARAM_PARENT = "parent"
    private val COMMENT_PARAM_TEXT = "text"

    fun postLogin(userName: String, password: String, createAccount: Boolean): Request {
        val loginFormBody = loginFormBody(userName, password, createAccount)
        return Request.Builder()
            .url(
                HttpUrl.parse(BASE_WEB_URL)!!
                    .newBuilder()
                    .addPathSegment(LOGIN_PATH)
                    .build()
            )
            .post(loginFormBody)
            .build()
    }

    private fun loginFormBody(userName: String, password: String, createAccount: Boolean): FormBody {
        val formBodyBuilder = FormBody.Builder()
            .add(LOGIN_PARAM_ACCOUNT, userName)
            .add(LOGIN_PARAM_PASSWORD, password)
            .add(LOGIN_PARAM_GOTO, LOGIN_PARAM_REDIRECT)
        if (createAccount) formBodyBuilder.add(LOGIN_PARAM_CREATING, LOGIN_PARAM_CREATING_VAL)
        return formBodyBuilder.build()
    }


    fun postVote(account: String, password: String, itemId: String): Request {
        val voteFormBody = voteFormBody(account, password, itemId)
        return Request.Builder()
            .url(
                HttpUrl.parse(BASE_WEB_URL)!!
                    .newBuilder()
                    .addPathSegment(VOTE_PATH)
                    .build()
            )
            .post(voteFormBody)
            .build()
    }

    private fun voteFormBody(account: String, password: String, itemId: String): FormBody {
        return FormBody.Builder()
            .add(LOGIN_PARAM_ACCOUNT, account)
            .add(LOGIN_PARAM_PASSWORD, password)
            .add(PARAM_ID, itemId)
            .add(VOTE_HOW, VOTE_UP)
            .build()
    }


    fun postComment(username: String, password: String, parentId: String, text: String): Request {
        val commentFormBody = commentFormBody(username, password, parentId, text)
        return Request.Builder()
            .url(
                HttpUrl.parse(BASE_WEB_URL)!!
                    .newBuilder()
                    .addPathSegment(COMMENT_PATH)
                    .build()
            )
            .post(commentFormBody)
            .build()
    }

    private fun commentFormBody(username: String, password: String, parentId: String, text: String): FormBody {
        return FormBody.Builder()
            .add(LOGIN_PARAM_ACCOUNT, username)
            .add(LOGIN_PARAM_PASSWORD, password)
            .add(COMMENT_PARAM_PARENT, parentId)
            .add(COMMENT_PARAM_TEXT, text)
            .build()
    }
}