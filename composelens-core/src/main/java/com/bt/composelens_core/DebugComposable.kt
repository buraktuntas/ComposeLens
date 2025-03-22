package com.bt.composelens_core

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class DebugComposable(val tag: String = "")
