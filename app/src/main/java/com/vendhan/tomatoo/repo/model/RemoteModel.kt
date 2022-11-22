package com.vendhan.tomatoo.repo.model

import com.google.gson.annotations.SerializedName

data class RemoteModel(
    @SerializedName("data")
    val data: ArrayList<Data>? = null
)

data class Data(
    @SerializedName(value = "children")
    val children: ArrayList<Data>? = null,
    @SerializedName(value = "type")
    var viewType: ViewType = ViewType.UNKNOWN,
    @SerializedName("value")
    var value: String = "",
    @SerializedName("size")
    val size: Int? = null,
    @SerializedName("action")
    val action: ActionType = ActionType.UNKNOWN,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("padding")
    val padding: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("width")
    val width: String? = null,
    @SerializedName("radius")
    val cornerRadius: String? = null,
    @SerializedName("color")
    val color: Colors? = null,
    @SerializedName("textType")
    val textType: TextType? = null,
    @SerializedName("textStyle")
    val textStyle: TextStyles? = null,
    @SerializedName("cardItem")
    val cardItem: RestaurantCard? = null,
    @SerializedName("alignment")
    val alignment: String? = null
)

data class RestaurantCard(
    val name: String? = null,
    val rating: String? = null,
    val time: String? = null,
    val offer: String? = null,
    val imageURL: String? = null,
    val type: String? = null
)

enum class ViewType {
    UNKNOWN,
    SCAFFOLD,
    APP_BAR,
    ROW,
    COLUMN,
    VERTICAL_LIST,
    HORIZONTAL_LIST,
    CARD,
    TEXT,
    IMAGE,
    BOX,
    EDIT_TEXT,
    SLIDER,
    VERTICAL_SPACER,
    HORIZONTAL_SPACER,
    SIMPLE_HEADER_TEXT,
    HEADER_WITH_BUTTON,
    RATING
}

enum class ActionType {
    UNKNOWN,
    LIST,
    DETAIL
}

enum class Colors {
    RED,
    WHITE,
    BLUE,
}

enum class TextType {
    BOLD,
    SEMI_BOLD,
    MEDIUM,
    NORMAL,
    LIGHT,
    THIN
}

enum class TextStyles {
    HEADLINE,
    TITLE,
    SUBTITLE,
    BODY,
    CAPTION
}
