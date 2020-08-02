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
        return Sponge.getGame().getLocale(locale);
    }

    public static final Locale AF_ZA = new Locale("af", "ZA");
    public static final Locale AR_SA = new Locale("ar", "SA");
    public static final Locale AST_ES = new Locale("ast", "ES");
    public static final Locale AZ_AZ = new Locale("az", "AZ");
    public static final Locale BG_BG = new Locale("bg", "BG");
    public static final Locale CA_ES = new Locale("ca", "ES");
    public static final Locale CS_CZ = new Locale("cs", "CZ");
    public static final Locale CY_GB = new Locale("cy", "GB");
    public static final Locale DA_DK = new Locale("da", "DK");
    public static final Locale DE_DE = Locale.GERMANY;
    public static final Locale EL_GR = new Locale("el", "GR");
    public static final Locale EN_AU = new Locale("en", "AU");
    public static final Locale EN_CA = new Locale("en", "CA");
    public static final Locale EN_GB = Locale.UK;
    public static final Locale EN_PT = new Locale("en", "PT");
    public static final Locale EN_US = Locale.US;
    public static final Locale EO_UY = new Locale("eo", "UY");
    public static final Locale ES_AR = new Locale("es", "AR");
    public static final Locale ES_ES = new Locale("es", "ES");
    public static final Locale ES_MX = new Locale("es", "MX");
    public static final Locale ES_UY = new Locale("es", "UY");
    public static final Locale ES_VE = new Locale("es", "VE");
    public static final Locale ET_EE = new Locale("et", "EE");
    public static final Locale EU_ES = new Locale("eu", "ES");
    public static final Locale FA_IR = new Locale("fa", "IR");
    public static final Locale FI_FI = new Locale("fi", "FI");
    public static final Locale FIL_PH = new Locale("fil", "PH");
    public static final Locale FR_CA = Locale.CANADA_FRENCH;
    public static final Locale FR_FR = Locale.FRANCE;
    public static final Locale GA_IE = new Locale("ga", "IE");
    public static final Locale GL_ES = new Locale("gl", "ES");
    public static final Locale GV_IM = new Locale("gv", "IM");
    public static final Locale HE_IL = new Locale("he", "IL");
    public static final Locale HI_IN = new Locale("hi", "IN");
    public static final Locale HR_HR = new Locale("hr", "HR");
    public static final Locale HU_HU = new Locale("hu", "HU");
    public static final Locale HY_AM = new Locale("hy", "AM");
    public static final Locale ID_ID = new Locale("id", "ID");
    public static final Locale IS_IS = new Locale("is", "IS");
    public static final Locale IT_IT = Locale.ITALY;
    public static final Locale JA_JP = Locale.JAPAN;
    public static final Locale KA_GE = new Locale("ka", "GE");
    public static final Locale KO_KR = Locale.KOREA;
    public static final Locale KW_GB = new Locale("kw", "GB");
    public static final Locale LA_LA = new Locale("la", "LA");
    public static final Locale LB_LU = new Locale("lb", "LU");
    public static final Locale LT_LT = new Locale("lt", "LT");
    public static final Locale LV_LV = new Locale("lv", "LV");
    public static final Locale MI_NZ = new Locale("mi", "NZ");
    public static final Locale MS_MY = new Locale("ms", "MY");
    public static final Locale MT_MT = new Locale("mt", "MT");
    public static final Locale NDS_DE = new Locale("nds", "DE");
    public static final Locale NL_NL = new Locale("nl", "NL");
    public static final Locale NN_NO = new Locale("nn", "NO");
    public static final Locale NO_NO = new Locale("no", "NO");
    public static final Locale OC_FR = new Locale("oc", "FR");
    public static final Locale PL_PL = new Locale("pl", "PL");
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale PT_PT = new Locale("pt", "PT");
    public static final Locale QYA_AA = new Locale("qya", "AA");
    public static final Locale RO_RO = new Locale("ro", "RO");
    public static final Locale RU_RU = new Locale("ru", "RU");
    public static final Locale SE_NO = new Locale("se", "NO");
    public static final Locale SK_SK = new Locale("sk", "SK");
    public static final Locale SL_SI = new Locale("sl", "SI");
    public static final Locale SR_SP = new Locale("sr", "SP");
    public static final Locale SV_SE = new Locale("sv", "SE");
    public static final Locale TH_TH = new Locale("th", "TH");
    public static final Locale TLH_AA = new Locale("tlh", "AA");
    public static final Locale TR_TR = new Locale("tr", "TR");
    public static final Locale UK_UA = new Locale("uk", "UA");
    public static final Locale VAL_ES = new Locale("val", "ES");
    public static final Locale VI_VN = new Locale("vi", "VN");
    public static final Locale ZH_CN = Locale.SIMPLIFIED_CHINESE;
    public static final Locale ZH_TW = Locale.TRADITIONAL_CHINESE;

    /**
     * The default locale used when the receiver's locale is unknown.
     */
    public static final Locale DEFAULT = EN_US;

    // Suppress default constructor to ensure non-instantiability.
    private Locales() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
