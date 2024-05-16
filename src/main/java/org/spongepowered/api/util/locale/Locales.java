/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.util.locale;

import org.spongepowered.api.Sponge;

import java.util.Locale;

/**
 * The list of locales available in Vanilla Minecraft.
 */
public final class Locales {

    /**
     * Gets a locale for the specified locale code, e.g. {@code en_US}.
     *
     * @param locale The locale to lookup (e.g. {@code en_US}.
     * @return The locale
     */
    public static Locale of(String locale) {
        return Sponge.game().locale(locale);
    }

    public static final Locale AF_ZA = Locale.of("af", "ZA");
    public static final Locale AR_SA = Locale.of("ar", "SA");
    public static final Locale AST_ES = Locale.of("ast", "ES");
    public static final Locale AZ_AZ = Locale.of("az", "AZ");
    public static final Locale BG_BG = Locale.of("bg", "BG");
    public static final Locale CA_ES = Locale.of("ca", "ES");
    public static final Locale CS_CZ = Locale.of("cs", "CZ");
    public static final Locale CY_GB = Locale.of("cy", "GB");
    public static final Locale DA_DK = Locale.of("da", "DK");
    public static final Locale DE_DE = Locale.GERMANY;
    public static final Locale EL_GR = Locale.of("el", "GR");
    public static final Locale EN_AU = Locale.of("en", "AU");
    public static final Locale EN_CA = Locale.of("en", "CA");
    public static final Locale EN_GB = Locale.UK;
    public static final Locale EN_PT = Locale.of("en", "PT");
    public static final Locale EN_US = Locale.US;
    public static final Locale EO_UY = Locale.of("eo", "UY");
    public static final Locale ES_AR = Locale.of("es", "AR");
    public static final Locale ES_ES = Locale.of("es", "ES");
    public static final Locale ES_MX = Locale.of("es", "MX");
    public static final Locale ES_UY = Locale.of("es", "UY");
    public static final Locale ES_VE = Locale.of("es", "VE");
    public static final Locale ET_EE = Locale.of("et", "EE");
    public static final Locale EU_ES = Locale.of("eu", "ES");
    public static final Locale FA_IR = Locale.of("fa", "IR");
    public static final Locale FI_FI = Locale.of("fi", "FI");
    public static final Locale FIL_PH = Locale.of("fil", "PH");
    public static final Locale FR_CA = Locale.CANADA_FRENCH;
    public static final Locale FR_FR = Locale.FRANCE;
    public static final Locale GA_IE = Locale.of("ga", "IE");
    public static final Locale GL_ES = Locale.of("gl", "ES");
    public static final Locale GV_IM = Locale.of("gv", "IM");
    public static final Locale HE_IL = Locale.of("he", "IL");
    public static final Locale HI_IN = Locale.of("hi", "IN");
    public static final Locale HR_HR = Locale.of("hr", "HR");
    public static final Locale HU_HU = Locale.of("hu", "HU");
    public static final Locale HY_AM = Locale.of("hy", "AM");
    public static final Locale ID_ID = Locale.of("id", "ID");
    public static final Locale IS_IS = Locale.of("is", "IS");
    public static final Locale IT_IT = Locale.ITALY;
    public static final Locale JA_JP = Locale.JAPAN;
    public static final Locale KA_GE = Locale.of("ka", "GE");
    public static final Locale KO_KR = Locale.KOREA;
    public static final Locale KW_GB = Locale.of("kw", "GB");
    public static final Locale LA_LA = Locale.of("la", "LA");
    public static final Locale LB_LU = Locale.of("lb", "LU");
    public static final Locale LT_LT = Locale.of("lt", "LT");
    public static final Locale LV_LV = Locale.of("lv", "LV");
    public static final Locale MI_NZ = Locale.of("mi", "NZ");
    public static final Locale MS_MY = Locale.of("ms", "MY");
    public static final Locale MT_MT = Locale.of("mt", "MT");
    public static final Locale NDS_DE = Locale.of("nds", "DE");
    public static final Locale NL_NL = Locale.of("nl", "NL");
    public static final Locale NN_NO = Locale.of("nn", "NO");
    public static final Locale NO_NO = Locale.of("no", "NO");
    public static final Locale OC_FR = Locale.of("oc", "FR");
    public static final Locale PL_PL = Locale.of("pl", "PL");
    public static final Locale PT_BR = Locale.of("pt", "BR");
    public static final Locale PT_PT = Locale.of("pt", "PT");
    public static final Locale QYA_AA = Locale.of("qya", "AA");
    public static final Locale RO_RO = Locale.of("ro", "RO");
    public static final Locale RU_RU = Locale.of("ru", "RU");
    public static final Locale SE_NO = Locale.of("se", "NO");
    public static final Locale SK_SK = Locale.of("sk", "SK");
    public static final Locale SL_SI = Locale.of("sl", "SI");
    public static final Locale SR_SP = Locale.of("sr", "SP");
    public static final Locale SV_SE = Locale.of("sv", "SE");
    public static final Locale TH_TH = Locale.of("th", "TH");
    public static final Locale TLH_AA = Locale.of("tlh", "AA");
    public static final Locale TR_TR = Locale.of("tr", "TR");
    public static final Locale UK_UA = Locale.of("uk", "UA");
    public static final Locale VAL_ES = Locale.of("val", "ES");
    public static final Locale VI_VN = Locale.of("vi", "VN");
    public static final Locale ZH_CN = Locale.SIMPLIFIED_CHINESE;
    public static final Locale ZH_TW = Locale.TRADITIONAL_CHINESE;

    /**
     * The default locale used when the receiver's locale is unknown.
     */
    public static final Locale DEFAULT = Locales.EN_US;

    // Suppress default constructor to ensure non-instantiability.
    private Locales() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
