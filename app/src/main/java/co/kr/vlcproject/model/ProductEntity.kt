package co.kr.vlcproject.model

data class ProductEntity(
    override val id: Long,
    val title: String,
    val quantity: Long
) : Entity