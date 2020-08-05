package br.com.zup.beagle.android.context.contextoperations.operationstrategy.comparison

import br.com.zup.beagle.android.context.contextoperations.operationstrategy.Operations
import br.com.zup.beagle.android.context.contextoperations.operationstrategy.BaseOperation
import br.com.zup.beagle.android.context.contextoperations.parameter.Parameter

internal fun BaseOperation<Operations>.toBoolean(parameter: Parameter) : Any {
    val firstValue = parameter.arguments[0].value.toString().toDouble()
    val secondValue = parameter.arguments[1].value.toString().toDouble()
    val isSizeCorrect = parameter.arguments.size == 2

    return when (this.operationType) {
        ComparisionOperationTypes.GREATER_THAN -> isSizeCorrect && firstValue > secondValue
        ComparisionOperationTypes.GREATER_THAN_EQUALS -> isSizeCorrect && firstValue >= secondValue
        ComparisionOperationTypes.LESS_THEN -> isSizeCorrect && firstValue < secondValue
        ComparisionOperationTypes.LESS_THEN_EQUALS -> isSizeCorrect && firstValue <= secondValue
        ComparisionOperationTypes.EQUALS -> isSizeCorrect && firstValue == secondValue
        else -> false
    }
}
