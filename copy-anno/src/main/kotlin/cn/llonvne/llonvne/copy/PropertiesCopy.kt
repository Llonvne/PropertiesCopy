package cn.llonvne.llonvne.copy

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
@Repeatable
annotation class PropertiesCopy(val target: KClass<*>)