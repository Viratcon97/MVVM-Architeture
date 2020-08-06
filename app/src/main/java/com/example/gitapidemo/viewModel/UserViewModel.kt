package com.example.gitapidemo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.gitapidemo.api.Retrofit
import com.example.gitapidemo.model.GithubUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserViewModel(application: Application) : AndroidViewModel(application){


    var context = application
    var disposable: CompositeDisposable? = CompositeDisposable()
    private val mService  =  Retrofit()

    var githubusers : MutableLiveData<ArrayList<GithubUser>> = MutableLiveData()

    fun getUserList(){
        disposable!!.add(mService.getUserList().getUserData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                githubusers.value = it
            })
    }
}