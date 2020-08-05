/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.android.context.operations.strategy.string

import br.com.zup.beagle.android.context.operations.grammar.GrammarChars
import br.com.zup.beagle.android.context.operations.grammar.RegularExpressions
import br.com.zup.beagle.android.context.operations.parameter.Argument

internal fun Argument.withoutApostrophe() : String {
    return (this.value as String).withoutApostrophe()
}

internal fun String.withoutApostrophe() : String {
    var parameter = ""

    RegularExpressions.BETWEEN_APOSTROPHE_MARK.toRegex()
        .findAll(this).forEach {
            it.groupValues.forEachIndexed { index, item ->
                if (index > 0) {
                    parameter = item
                }
            }
        }

    return parameter
}

internal fun String.withApostropheMark() : String =
    GrammarChars.APOSTROPHE_MARK + this + GrammarChars.APOSTROPHE_MARK
