package com.vincent.util

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class RxProvider {

    open fun compositeDisposable() = CompositeDisposable()

    open fun ioScheduler() = Schedulers.io()

    open fun uiScheduler() = AndroidSchedulers.mainThread()

    open fun computationScheduler() = Schedulers.computation()

    open fun <T> publishSubject() = PublishSubject.create<T>()

    open fun <T> behaviorSubject() = BehaviorSubject.create<T>()
}