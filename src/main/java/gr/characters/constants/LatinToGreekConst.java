package gr.characters.constants;

import java.util.Arrays;
import java.util.List;

public interface LatinToGreekConst {
    /**  CAPITAL_LETTER_ALPHA in Latin. value:"A"  */
    public static final String LATIN_K_ALPHA  = "A" ; //"CAPITAL_LETTER_ALPHA"
    /**  CAPITAL_LETTER_ALPHA_WITH_TONOS in Latin. value:"_A"  */
    public static final String LATIN_K_ALPHA_TONOS = "_A" ; //"CAPITAL_LETTER_ALPHA_WITH_TONOS"
    /**  SMALL_LETTER_ALPHA in Latin. value:"a"   */
    public static final String LATIN_M_ALPHA = "a" ; //"SMALL_LETTER_ALPHA"
    /**  SMALL LETTER ALPHA WITH TONOS in Latin. value:"_a"   */
    public static final String LATIN_M_ALPHA_TONOS = "_a" ; //"SMALL LETTER ALPHA WITH TONOS"
    /**  CAPITAL LETTER BETA in Latin. value:"B"  */
    public static final String LATIN_K_BETA = "B" ; //"CAPITAL LETTER BETA"
    /**  SMALL LETTER BETA in Latin. value:"b"   */
    public static final String LATIN_M_BETA = "b" ; //"SMALL LETTER BETA"
    /**  CAPITAL LETTER GAMMA in Latin. value:"G"   */
    public static final String LATIN_K_GAMMA = "G" ; //"CAPITAL LETTER GAMMA"
    /**  SMALL LETTER GAMMA in Latin. value:"g"   */
    public static final String LATIN_M_GAMMA = "g"; //"SMALL LETTER GAMMA"
    /**  CAPITAL LETTER DELTA in Latin. value:"D"   */
    public static final String LATIN_K_DELTA = "D"; //"CAPITAL LETTER DELTA"
    /**  SMALL LETTER DELTA in Latin. value:"d"   */
    public static final String LATIN_M_DELTA = "d"; //"SMALL LETTER DELTA"
    /**  CAPITAL LETTER EPSILON in Latin. value:"E"   */
    public static final String LATIN_K_EPSILON = "E"; //"CAPITAL LETTER EPSILON"
    /**  CAPITAL LETTER EPSILON WITH TONOS in Latin. value:"_E"   */
    public static final String LATIN_K_EPSILON_TONOS = "_E"; //"CAPITAL LETTER EPSILON WITH TONOS"
    /**  SMALL LETTER EPSILON in Latin. value:"e"   */
    public static final String LATIN_M_EPSILON = "e"; //"SMALL LETTER EPSILON"
    /**  SMALL LETTER EPSILON WITH TONOS in Latin. value:"_e"   */
    public static final String LATIN_M_EPSILON_TONOS = "_e"; //"SMALL LETTER EPSILON WITH TONOS"
    /**  CAPITAL LETTER ZETA in Latin. value:"Z"   */
    public static final String LATIN_K_ZETA = "Z"; //"CAPITAL LETTER ZETA"
    /**  SMALL LETTER ZETA in Latin. value:"z"   */
    public static final String LATIN_M_ZETA = "z"; //"SMALL LETTER ZETA"
    /**  CAPITAL LETTER ETA in Latin. value:"H"   */
    public static final String LATIN_K_HTA = "H"; //"CAPITAL LETTER ETA"
    /**  CAPITAL LETTER ETA WITH TONOS in Latin. value:"_H"   */
    public static final String LATIN_K_HTA_TONOS = "_H"; //"CAPITAL LETTER ETA WITH TONOS"
    /**  SMALL LETTER ETA in Latin. value:"h"   */
    public static final String LATIN_M_HTA = "h"; //"SMALL LETTER ETA"
    /**  SMALL LETTER ETA WITH TONOS in Latin. value:"_h"   */
    public static final String LATIN_M_HTA_TONOS = "_h"; //"SMALL LETTER ETA WITH TONOS"
    /**  CAPITAL LETTER THETA in Latin. value:"Q"   */
    public static final String LATIN_K_THETA = "Q"; //"CAPITAL LETTER THETA"
    /**  SMALL LETTER THETA in Latin. value:"q"   */
    public static final String LATIN_M_THETA = "q"; //"SMALL LETTER THETA"
    /**  CAPITAL LETTER IOTA in Latin. value:"I"   */
    public static final String LATIN_K_JIOTA = "I"; //"CAPITAL LETTER IOTA"
    /**  CAPITAL LETTER IOTA WITH TONOS in Latin. value:"_I"   */
    public static final String LATIN_K_JIOTA_TONOS = "_I"; //"CAPITAL LETTER IOTA WITH TONOS"
    /**  CAPITAL LETTER IOTA WITH DIALYTIKA in Latin. value:":I"   */
    public static final String LATIN_K_JIOTA_DIALYTIKA = ":I"; //"CAPITAL LETTER IOTA WITH DIALYTIKA"
    /**  SMALL LETTER IOTA in Latin. value:"i"   */
    public static final String LATIN_M_JIOTA = "i"; //"SMALL LETTER IOTA"
    /**  SMALL LETTER IOTA WITH TONOS in Latin. value:"_i"   */
    public static final String LATIN_M_JIOTA_TONOS = "_i"; //"SMALL LETTER IOTA WITH TONOS"
    /**  SMALL LETTER IOTA WITH DIALYTIKA in Latin. value:":i"   */
    public static final String LATIN_M_JIOTA_DIALYTIKA = ":i"; //"SMALL LETTER IOTA WITH DIALYTIKA"
    /**  SMALL LETTER IOTA WITH DIALYTIKA AND TONOS in Latin. value:":_i"   */
    public static final String LATIN_M_JIOTA_TONOS_DIALYTIKA = ":_i"; //"SMALL LETTER IOTA WITH DIALYTIKA AND TONOS"
    /**  CAPITAL LETTER KAPPA in Latin. value:"K"   */
    public static final String LATIN_K_KAPPA = "K"; //"CAPITAL LETTER KAPPA"
    /**  SMALL LETTER KAPPA in Latin. value:"k"   */
    public static final String LATIN_M_KAPPA = "k"; //"SMALL LETTER KAPPA"
    /**  CAPITAL LETTER LAMDA in Latin. value:"L"   */
    public static final String LATIN_K_LAMDA = "L"; //"CAPITAL LETTER LAMDA"
    /**  SMALL LETTER LAMDA in Latin. value:"l"   */
    public static final String LATIN_M_LAMDA = "l"; //"SMALL LETTER LAMDA"
    /**  CAPITAL LETTER MI in Latin. value:"M"   */
    public static final String LATIN_K_MI = "M"; //"CAPITAL LETTER MI"
    /**  SMALL LETTER MI in Latin. value:"m"   */
    public static final String LATIN_M_MI = "m"; //"SMALL LETTER MI"
    /**  CAPITAL LETTER NI in Latin. value:"N"   */
    public static final String LATIN_K_NI = "N"; //"CAPITAL LETTER NI"
    /**  SMALL LETTER NI in Latin. value:"n"   */
    public static final String LATIN_M_NI = "n"; //"SMALL LETTER NI"
    /**  CAPITAL LETTER KSI in Latin. value:"_K"   */
    public static final String LATIN_K_KSI = "_K"; //"CAPITAL LETTER KSI"
    /**  SMALL LETTER KSI in Latin. value:"_k"   */
    public static final String LATIN_M_KSI = "_k";  //"SMALL LETTER KSI"
    /**  CAPITAL LETTER OMICRON in Latin. value:"O"   */
    public static final String LATIN_K_OMIKRON = "O"; //"CAPITAL LETTER OMICRON"
    /**  CAPITAL LETTER OMICRON WITH TONOS in Latin. value:"_O"   */
    public static final String LATIN_K_OMIKRON_TONOS = "_O"; //"CAPITAL LETTER OMICRON WITH TONOS"
    /**  SMALL LETTER OMICRON in Latin. value:"o"   */
    public static final String LATIN_M_OMIKRON = "o"; //"SMALL LETTER OMICRON"
    /**  SMALL LETTER OMICRON WITH TONOS in Latin. value:"_o"   */
    public static final String LATIN_M_OMIKRON_TONOS = "_o"; //"SMALL LETTER OMICRON WITH TONOS"
    /**  CAPITAL LETTER PI in Latin. value:"P"   */
    public static final String LATIN_K_PI = "P"; //"CAPITAL LETTER PI"
    /**  SMALL LETTER PI in Latin. value:"p"   */
    public static final String LATIN_M_PI = "p"; //"SMALL LETTER PI"
    /**  CAPITAL LETTER RO in Latin. value:"R"   */
    public static final String LATIN_K_RO = "R"; //"CAPITAL LETTER RHO"
    /**  SMALL LETTER RO in Latin. value:"r"   */
    public static final String LATIN_M_RO = "r"; //"SMALL LETTER RHO"
    /**  CAPITAL LETTER SIGMA in Latin. value:"S"   */
    public static final String LATIN_K_SIGMA = "S"; //"CAPITAL LETTER SIGMA"
    /**  SMALL LETTER SIGMA in Latin. value:"s"   */
    public static final String LATIN_M_SIGMA = "s"; //"SMALL LETTER SIGMA"
    /**  SMALL LETTER FINAL SIGMA in Latin. value:"_s"   */
    public static final String LATIN_M_SIGMA_TELIKO = "_s"; //"SMALL LETTER FINAL SIGMA"
    /**  CAPITAL LETTER TAF in Latin. value:"T"   */
    public static final String LATIN_K_TAF = "T"; //"CAPITAL LETTER TAU"
    /**  SMALL LETTER TAF in Latin. value:"t"   */
    public static final String LATIN_M_TAF = "t"; //"SMALL LETTER TAU"
    /**  CAPITAL LETTER YPSILON in Latin. value:"Y"   */
    public static final String LATIN_K_YPSILON = "Y"; //"CAPITAL LETTER UPSILON"
    /**  CAPITAL LETTER YPSILON WITH TONOS in Latin. value:"_Y"   */
    public static final String LATIN_K_YPSILON_TONOS = "_Y"; //"CAPITAL LETTER UPSILON WITH TONOS"
    /**  CAPITAL LETTER YPSILON WITH DIALYTIKA in Latin. value:":Y"   */
    public static final String LATIN_K_YPSILON_DIALYTIKA = ":Y"; //"CAPITAL LETTER UPSILON WITH DIALYTIKA"
    /**  SMALL LETTER YPSILON in Latin. value:"y"   */
    public static final String LATIN_M_YPSILON = "y"; //"SMALL LETTER UPSILON"
    /**  SMALL LETTER YPSILON WITH TONOS in Latin. value:"_y"   */
    public static final String LATIN_M_YPSILON_TONOS = "_y"; //"SMALL LETTER UPSILON WITH TONOS"
    /**  SMALL LETTER YPSILON WITH DIALYTIKA in Latin. value:":y"   */
    public static final String LATIN_M_YPSILON_DIALYTIKA = ":y"; //"SMALL LETTER UPSILON WITH DIALYTIKA"
    /**  SMALL LETTER YPSILON WITH DIALYTIKA AND TONOS in Latin. value:":_y"   */
    public static final String LATIN_M_YPSILON_TONOS_DIALYTIKA = ":_y"; //"SMALL LETTER UPSILON WITH DIALYTIKA AND TONOS"
    /**  CAPITAL LETTER PHI in Latin. value:"F"   */
    public static final String LATIN_K_FI = "F"; //"CAPITAL LETTER PHI"
    /**  SMALL LETTER PHI in Latin. value:"f"   */
    public static final String LATIN_M_FI = "f"; //"SMALL LETTER PHI"
    /**  CAPITAL LETTER CHI in Latin. value:"X"   */
    public static final String LATIN_K_XI = "X"; //"CAPITAL LETTER CHI"
    /**  SMALL LETTER CHI in Latin. value:"x"   */
    public static final String LATIN_M_XI = "x"; //"SMALL LETTER CHI"
    /**  CAPITAL LETTER PSI in Latin. value:"_P"   */
    public static final String LATIN_K_PSI = "_P"; //"CAPITAL LETTER PSI"
    /**  SMALL LETTER PSI in Latin. value:"_p"   */
    public static final String LATIN_M_PSI = "_p"; //"SMALL LETTER PSI"
    /**  CAPITAL LETTER OMEGA in Latin. value:"W"   */
    public static final String LATIN_K_OMEGA = "W"; //"CAPITAL LETTER OMEGA"
    /**  CAPITAL LETTER OMEGA WITH TONOS in Latin. value:"_W"   */
    public static final String LATIN_K_OMEGA_TONOS = "_W"; //"CAPITAL LETTER OMEGA WITH TONOS"
    /**  SMALL LETTER OMEGA in Latin. value:"w"   */
    public static final String LATIN_M_OMEGA = "w"; //"SMALL LETTER OMEGA"
    /**  SMALL LETTER OMEGA WITH TONOS in Latin. value:"_w"   */
    public static final String LATIN_M_OMEGA_TONOS = "_w";//"SMALL LETTER OMEGA WITH TONOS"

    public static final String [] greekAlphabet_LATIN = {LATIN_K_ALPHA, LATIN_K_ALPHA_TONOS,
        LATIN_M_ALPHA, LATIN_M_ALPHA_TONOS, LATIN_K_BETA, LATIN_M_BETA, LATIN_K_GAMMA, LATIN_M_GAMMA,
        LATIN_K_DELTA, LATIN_M_DELTA, LATIN_K_EPSILON, LATIN_K_EPSILON_TONOS, LATIN_M_EPSILON ,
        LATIN_M_EPSILON_TONOS, LATIN_K_ZETA, LATIN_M_ZETA, LATIN_K_HTA, LATIN_K_HTA_TONOS, LATIN_M_HTA ,
        LATIN_M_HTA_TONOS , LATIN_K_THETA, LATIN_M_THETA, LATIN_K_JIOTA, LATIN_K_JIOTA_TONOS,
        LATIN_K_JIOTA_DIALYTIKA, LATIN_M_JIOTA, LATIN_M_JIOTA_TONOS, LATIN_M_JIOTA_DIALYTIKA,
        LATIN_M_JIOTA_TONOS_DIALYTIKA, LATIN_K_KAPPA, LATIN_M_KAPPA , LATIN_K_LAMDA, LATIN_M_LAMDA,
        LATIN_K_MI, LATIN_M_MI, LATIN_K_NI, LATIN_M_NI, LATIN_K_KSI, LATIN_M_KSI, LATIN_K_OMIKRON,
        LATIN_K_OMIKRON_TONOS, LATIN_M_OMIKRON, LATIN_M_OMIKRON_TONOS, LATIN_K_PI, LATIN_M_PI,
        LATIN_K_RO, LATIN_M_RO, LATIN_K_SIGMA, LATIN_M_SIGMA, LATIN_M_SIGMA_TELIKO, LATIN_K_TAF,
        LATIN_M_TAF, LATIN_K_YPSILON, LATIN_K_YPSILON_TONOS, LATIN_K_YPSILON_DIALYTIKA, LATIN_M_YPSILON,
        LATIN_M_YPSILON_TONOS, LATIN_M_YPSILON_DIALYTIKA, LATIN_M_YPSILON_TONOS_DIALYTIKA, LATIN_K_FI,
        LATIN_M_FI, LATIN_K_XI, LATIN_M_XI, LATIN_K_PSI, LATIN_M_PSI, LATIN_K_OMEGA, LATIN_K_OMEGA_TONOS,
        LATIN_M_OMEGA, LATIN_M_OMEGA_TONOS
    };

    public static final List<String> GREEK_ALPHABET_AS_LIST  = Arrays.asList(greekAlphabet_LATIN);

    public static final String[][] greekAlphabetLATIN = {
        { "A" },//"CAPITAL_LETTER_ALPHA"
        { "_A" },//"CAPITAL_LETTER_ALPHA_WITH_TONOS"
        { "a" },//"SMALL_LETTER_ALPHA"
        { "_a" },//"SMALL LETTER ALPHA WITH TONOS"
        {"B" },//"CAPITAL LETTER BETA"
        { "b" },//"SMALL LETTER BETA"
        { "G" },//"CAPITAL LETTER GAMMA"
        { "g"},//"SMALL LETTER GAMMA"
        { "D"},//"CAPITAL LETTER DELTA"
        { "d"},//"SMALL LETTER DELTA"
        { "E"},//"CAPITAL LETTER EPSILON"
        { "_E"},//"CAPITAL LETTER EPSILON WITH TONOS"
        { "e"},//"SMALL LETTER EPSILON"
        { "_e"},//"SMALL LETTER EPSILON WITH TONOS"
        { "Z"},//"CAPITAL LETTER ZETA"
        { "z"},//"SMALL LETTER ZETA"
        { "H"},//"CAPITAL LETTER ETA"
        { "_H"},//"CAPITAL LETTER ETA WITH TONOS"
        { "h"},//"SMALL LETTER ETA"
        { "_h"},//"SMALL LETTER ETA WITH TONOS"
        { "Q"},//"CAPITAL LETTER THETA"
        { "q"},//"SMALL LETTER THETA"
        { "I"},//"CAPITAL LETTER IOTA"
        { "_I"},//"CAPITAL LETTER IOTA WITH TONOS"
        { ":I"},//"CAPITAL LETTER IOTA WITH DIALYTIKA"
        { "i"},//"SMALL LETTER IOTA"
        { "_i"},//"SMALL LETTER IOTA WITH TONOS"
        { ":i"},//"SMALL LETTER IOTA WITH DIALYTIKA"
        { ":_i"},//"SMALL LETTER IOTA WITH DIALYTIKA AND TONOS"
        { "K"},//"CAPITAL LETTER KAPPA"
        { "k"},//"SMALL LETTER KAPPA"
        { "L"},//"CAPITAL LETTER LAMDA"
        { "l"},//"SMALL LETTER LAMDA"
        { "M"},//"CAPITAL LETTER MI"
        { "m"},//"SMALL LETTER MI"
        { "N"},//"CAPITAL LETTER NI"
        { "n"},//"SMALL LETTER NI"
        { "_K"},//"CAPITAL LETTER KSI"
        { "_k"}, //"SMALL LETTER KSI"
        { "O"},//"CAPITAL LETTER OMICRON"
        { "_O"},//"CAPITAL LETTER OMICRON WITH TONOS"
        { "o"},//"SMALL LETTER OMICRON"
        { "_o"},//"SMALL LETTER OMICRON WITH TONOS"
        { "P"},//"GREEK CAPITAL LETTER PI"
        { "p"},//"SMALL LETTER PI"
        { "R"},//"CAPITAL LETTER RHO"
        { "r"},//"SMALL LETTER RHO"
        { "S"},//"CAPITAL LETTER SIGMA"
        { "s"},//"SMALL LETTER SIGMA"
        { "_s"},//"SMALL LETTER FINAL SIGMA"
        { "T"},//"CAPITAL LETTER TAU"
        { "t"},//"SMALL LETTER TAU"
        { "Y"},//"CAPITAL LETTER UPSILON"
        { "_Y"},//"CAPITAL LETTER UPSILON WITH TONOS"
        { ":Y"},//"CAPITAL LETTER UPSILON WITH DIALYTIKA"
        { "y"},//"SMALL LETTER UPSILON"
        { "_y"},//"SMALL LETTER UPSILON WITH TONOS"
        { ":y"},//"SMALL LETTER UPSILON WITH DIALYTIKA"
        { ":_y"},//"SMALL LETTER UPSILON WITH DIALYTIKA AND TONOS"
        { "F"},//"CAPITAL LETTER PHI"
        {"f"},//"SMALL LETTER PHI"
        { "X"},//"CAPITAL LETTER CHI"
        { "x"},//"SMALL LETTER CHI"
        { "_P"},//"CAPITAL LETTER PSI"
        { "_p"},//"SMALL LETTER PSI"
        { "W"},//"CAPITAL LETTER OMEGA"
        { "_W"},//"CAPITAL LETTER OMEGA WITH TONOS"
        { "w"},//"SMALL LETTER OMEGA"
        { "_w"}//"SMALL LETTER OMEGA WITH TONOS"
    };
}
