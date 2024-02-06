package gentle.hilt.product.screen.dynamic_constraints

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import gentle.hilt.data.room.catalog.CatalogItemEntity


fun dynamicPriceConstraints(
    product: CatalogItemEntity,
    starsBottom: ConstraintLayoutBaseScope.HorizontalAnchor,
    availableAmountBottom: ConstraintLayoutBaseScope.HorizontalAnchor
): ConstraintLayoutBaseScope.HorizontalAnchor {
    return if (product.rating > 0.0 && product.feedBackCount > 0) {
        starsBottom
    } else {
        availableAmountBottom
    }
}

