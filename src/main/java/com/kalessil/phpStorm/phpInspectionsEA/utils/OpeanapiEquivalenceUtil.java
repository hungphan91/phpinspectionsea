package com.kalessil.phpStorm.phpInspectionsEA.utils;

import com.intellij.codeInsight.PsiEquivalenceUtil;
import com.intellij.psi.PsiElement;
import com.kalessil.phpStorm.phpInspectionsEA.EASettings;
import com.kalessil.phpStorm.phpInspectionsEA.utils.analytics.AnalyticsUtil;
import org.jetbrains.annotations.NotNull;

/*
 * This file is part of the Php Inspections (EA Extended) package.
 *
 * (c) Vladimir Reznichenko <kalessil@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

final public class OpeanapiEquivalenceUtil {
    public static boolean areEqual(@NotNull PsiElement first, @NotNull PsiElement second) {
        boolean result;
        try {
            result = PsiEquivalenceUtil.areElementsEquivalent(first, second);
            if (!result) {
                result = first.getClass() == second.getClass() && first.getText().equals(second.getText());
            }
        } catch (Throwable error) {
            AnalyticsUtil.registerPreventedException(EASettings.getInstance().getUuid(), error);
            result = false;
        }
        return result;
    }
}
