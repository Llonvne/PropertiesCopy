import cn.llonvne.llonvne.copy.PropertiesCopy

@PropertiesCopy(target = UserWithoutPassword::class)
@PropertiesCopy(target = Password::class)
data class User<T>(val username: String, val password: String, val value: T) {
    companion object
}

data class UserWithoutPassword(val username: String)

data class Password(val password: String)
