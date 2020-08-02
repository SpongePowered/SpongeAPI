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

import java.util.Locale;

/**
 * The list of the names of available locales in Vanilla Minecraft.
 */
@SuppressWarnings("unused")
public final class NamedLocales {

    /**
     * The default locale used when the receiver's locale is unknown.
     */
    public static final Locale DEFAULT = Locales.DEFAULT;

    public static final Locale AFRIKAANS = Locales.AF_ZA;
    public static final Locale ARABIC = Locales.AR_SA;
    public static final Locale ASTURIAN = Locales.AST_ES;
    public static final Locale AZERBAIJANI = Locales.AZ_AZ;
    public static final Locale BULGARIAN = Locales.BG_BG;
    public static final Locale CATALAN = Locales.CA_ES;
    public static final Locale CZECH = Locales.CS_CZ;
    public static final Locale WELSH = Locales.CY_GB;
    public static final Locale DANISH = Locales.DA_DK;
    public static final Locale GERMAN = Locales.DE_DE;
    public static final Locale GREEK = Locales.EL_GR;
    public static final Locale AUSTRALIAN_ENGLISH = Locales.EN_AU;
    public static final Locale CANADIAN_ENGLISH = Locales.EN_CA;
    public static final Locale BRITISH_ENGLISH = Locales.EN_GB;
    public static final Locale PIRATE_ENGLISH = Locales.EN_PT;
    public static final Locale AMERICAN_ENGLISH = Locales.EN_US;
    public static final Locale ESPERANTO = Locales.EO_UY;
    public static final Locale ARGENTINIAN_SPANISH = Locales.ES_AR;
    public static final Locale SPANISH = Locales.ES_ES;
    public static final Locale MEXICAN_SPANISH = Locales.ES_MX;
    public static final Locale URUGUAYAN_SPANISH = Locales.ES_UY;
    public static final Locale VENEZUELAN_SPANISH = Locales.ES_VE;
    public static final Locale ESTONIAN = Locales.ET_EE;
    public static final Locale BASQUE = Locales.EU_ES;
    public static final Locale PERSIAN = Locales.FA_IR;
    public static final Locale FINNISH = Locales.FI_FI;
    public static final Locale FILIPINO = Locales.FIL_PH;
    public static final Locale CANADIAN_FRENCH = Locales.FR_CA;
    public static final Locale FRENCH = Locales.FR_FR;
    public static final Locale IRISH = Locales.GA_IE;
    public static final Locale GALICIAN = Locales.GL_ES;
    public static final Locale MANX = Locales.GV_IM;
    public static final Locale HEBREW = Locales.HE_IL;
    public static final Locale HINDI = Locales.HI_IN;
    public static final Locale CROATIAN = Locales.HR_HR;
    public static final Locale HUNGARIAN = Locales.HU_HU;
    public static final Locale ARMENIAN = Locales.HY_AM;
    public static final Locale INDONESIAN = Locales.ID_ID;
    public static final Locale ICELANDIC = Locales.IS_IS;
    public static final Locale ITALIAN = Locales.IT_IT;
    public static final Locale JAPANESE = Locales.JA_JP;
    public static final Locale GEORGIAN = Locales.KA_GE;
    public static final Locale KOREAN = Locales.KO_KR;
    public static final Locale CORNISH = Locales.KW_GB;
    public static final Locale LATIN = Locales.LA_LA;
    public static final Locale LUXEMBOURGISH = Locales.LB_LU;
    public static final Locale LITHUANIAN = Locales.LT_LT;
    public static final Locale LATVIAN = Locales.LV_LV;
    public static final Locale MAORI = Locales.MI_NZ;
    public static final Locale MALAY = Locales.MS_MY;
    public static final Locale MALTESE = Locales.MT_MT;
    public static final Locale LOW_GERMAN = Locales.NDS_DE;
    public static final Locale DUTCH = Locales.NL_NL;
    public static final Locale NORWEGIAN_NYNORSK = Locales.NN_NO;
    public static final Locale NORWEGIAN = Locales.NO_NO;
    public static final Locale OCCITAN = Locales.OC_FR;
    public static final Locale POLISH = Locales.PL_PL;
    public static final Locale BRAZILIAN_PORTUGUESE = Locales.PT_BR;
    public static final Locale PORTUGUESE = Locales.PT_PT;
    public static final Locale QUENYA = Locales.QYA_AA;
    public static final Locale ROMANIAN = Locales.RO_RO;
    public static final Locale RUSSIAN = Locales.RU_RU;
    public static final Locale NORTHERN_SAMI = Locales.SE_NO;
    public static final Locale SLOVAK = Locales.SK_SK;
    public static final Locale SLOVENE = Locales.SL_SI;
    public static final Locale SERBIAN = Locales.SR_SP;
    public static final Locale SWEDISH = Locales.SV_SE;
    public static final Locale THAI = Locales.TH_TH;
    public static final Locale KLINGON = Locales.TLH_AA;
    public static final Locale TURKISH = Locales.TR_TR;
    public static final Locale UKRAINIAN = Locales.UK_UA;
    public static final Locale VALENCIAN = Locales.VAL_ES;
    public static final Locale VIETNAMESE = Locales.VI_VN;
    public static final Locale SIMPLIFIED_CHINESE = Locales.ZH_CN;
    public static final Locale TRADITIONAL_CHINESE = Locales.ZH_TW;

    // Suppress default constructor to ensure non-instantiability.
    private NamedLocales() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
