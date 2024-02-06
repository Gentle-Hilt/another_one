package gentle.hilt.product.screen.dynamic_constraints

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope

fun dynamicHideButtonConstraints(
    isVisible: Boolean,
    descriptionTitle: ConstraintLayoutBaseScope.HorizontalAnchor,
    actualDescription: ConstraintLayoutBaseScope.HorizontalAnchor
): ConstraintLayoutBaseScope.HorizontalAnchor {
    return if (isVisible) {
        actualDescription
    } else {
        descriptionTitle
    }
}