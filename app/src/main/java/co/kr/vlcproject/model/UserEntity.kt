package co.kr.vlcproject.model

data class UserEntity(
    override val id: Long,
    val name: String,
    val age: Int
) : Entity