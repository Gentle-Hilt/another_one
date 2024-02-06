package gentle.hilt.data.room

import gentle.hilt.data.room.catalog.CatalogItemEntity
import gentle.hilt.network.models.goods.GoodsModel


fun mapGoodsToCatalogItemEntity(goodsModel: GoodsModel): List<CatalogItemEntity> {
    return goodsModel.items.map {
        CatalogItemEntity(
            id = it.id.orEmpty(),
            title = it.title.orEmpty(),
            subtitle = it.subtitle.orEmpty(),
            description = it.description.orEmpty(),
            oldPrice = it.price?.price.orEmpty(),
            newPrice = it.price?.priceWithDiscount.orEmpty(),
            consistOf = it.ingredients.orEmpty(),
            tags = it.tags.orEmpty(),
            info = it.info.orEmpty(),
            available = it.available ?: 0,
            rating = it.feedback?.rating ?: 0.0,
            feedBackCount = it.feedback?.count ?: 0,
            discountPercentage = it.price?.discount ?: 0,
        )
    }
}