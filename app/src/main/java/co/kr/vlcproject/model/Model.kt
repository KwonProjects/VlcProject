package co.kr.vlcproject.model

abstract class Model(
    open val id: Long,
    open val type: CellType
) {
}