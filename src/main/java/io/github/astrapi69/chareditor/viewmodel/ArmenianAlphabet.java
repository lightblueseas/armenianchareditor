package io.github.astrapi69.chareditor.viewmodel;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArmenianAlphabet {

    public static void main(String[] args) {
        Map<String, CharacterInfo> characterInfos = newCharacterInfoMap();
        System.out.println(characterInfos);
    }


    public static final String[][] alphabet = {
            {         "\u0531", "A", "&#1329;", "Ա", "ARMENIAN CAPITAL LETTER AYB"   },
            {         "\u0532", "B", "&#1330;", "Բ", "ARMENIAN CAPITAL LETTER BEN"    },
            {         "\u0533", "G", "&#1331;", "Գ", "ARMENIAN CAPITAL LETTER GIM"     },
            {         "\u0534", "D", "&#1332;", "Դ", "ARMENIAN CAPITAL LETTER DA"     },
            {         "\u0535", "Je", "&#1333;", "Ե", "ARMENIAN CAPITAL LETTER ECH"     },
            {         "\u0536", "Z", "&#1334;", "Զ", "ARMENIAN CAPITAL LETTER ZA"     },
            {         "\u0537", "E", "&#1335;", "Է", "ARMENIAN CAPITAL LETTER EH"     },
            {         "\u0538", "Ö", "&#1336;", "Ը", "ARMENIAN CAPITAL LETTER ET"     },
            {         "\u0539", "T", "&#1337;", "Թ", "ARMENIAN CAPITAL LETTER TO"     },
            {         "\u053A", "Schz", "&#1338;", "Ժ", "ARMENIAN CAPITAL LETTER ZHE"     },
            {         "\u053B", "I", "&#1339;", "Ի", "ARMENIAN CAPITAL LETTER INI"     },
            {         "\u053C", "L", "&#1340;", "Լ", "ARMENIAN CAPITAL LETTER LIWN"     },
            {         "\u053D", "Ch", "&#1341;", "Խ", "ARMENIAN CAPITAL LETTER XEH"     },
            {         "\u053E", "Ts", "&#1342;", "Ծ", "ARMENIAN CAPITAL LETTER CA"     },
            {         "\u053F", "K", "&#1343;", "Կ", "ARMENIAN CAPITAL LETTER KEN"     },

            {         "\u0540", "H", "&#1344;", "Հ", "ARMENIAN CAPITAL LETTER HO"     },
            {         "\u0541", "Dz", "&#1345;", "Ձ", "ARMENIAN CAPITAL LETTER JA"     },
            {         "\u0542", "R", "&#1346;", "Ղ", "ARMENIAN CAPITAL LETTER GHAD"     },
            {         "\u0543", "Dtsch", "&#1347;", "Ճ", "ARMENIAN CAPITAL LETTER CHEH"     },
            {         "\u0544", "M", "&#1348;", "Մ", "ARMENIAN CAPITAL LETTER MEN"     },
            {         "\u0545", "J", "&#1349;", "Յ", "ARMENIAN CAPITAL LETTER YI"     },
            {         "\u0546", "N", "&#1350;", "Ն", "ARMENIAN CAPITAL LETTER NOW"     },
            {         "\u0547", "Sch", "&#1351;", "Շ", "ARMENIAN CAPITAL LETTER SHA"     },
            {         "\u0548", "O", "&#1352;", "Ո", "ARMENIAN CAPITAL LETTER VO"     },
            {         "\u0549", "Tsch", "&#1353;", "Չ", "ARMENIAN CAPITAL LETTER CHA"     },
            {         "\u054A", "P", "&#1354;", "Պ", "ARMENIAN CAPITAL LETTER PEH"     },
            {         "\u054B", "Dsch", "&#1355;", "Ջ", "ARMENIAN CAPITAL LETTER JHEH"     },
            {         "\u054C", "R", "&#1356;", "Ռ", "ARMENIAN CAPITAL LETTER RA"     },
            {         "\u054D", "Ss", "&#1357;", "Ս", "ARMENIAN CAPITAL LETTER SEH"     },
            {         "\u054E", "W", "&#1358;", "Վ", "ARMENIAN CAPITAL LETTER VEW"    },
            {         "\u054F", "Dt", "&#1359;", "Տ", "ARMENIAN CAPITAL LETTER TIWN"     },

            {         "\u0550", "R", "&#1360;", "Ր", "ARMENIAN CAPITAL LETTER REH"     },
            {         "\u0551", "Ts", "&#1361;", "Ց", "ARMENIAN CAPITAL LETTER CO"     },
            {         "\u0552", "U", "&#1362;", "Ւ", "ARMENIAN CAPITAL LETTER YIWN"     },
            {         "\u0553", "P", "&#1363;", "Փ", "ARMENIAN CAPITAL LETTER PIWR"     },
            {         "\u0554", "K", "&#1364;", "Ք", "ARMENIAN CAPITAL LETTER KEH"     },
            {         "\u0555", "O", "&#1365;", "Օ", "ARMENIAN CAPITAL LETTER OH"     },
            {         "\u0556", "V", "&#1366;", "Ֆ", "ARMENIAN CAPITAL LETTER FEH"     },
            {         "\u0559", "", "&#1369;", "ՙ", "ARMENIAN MODIFIER LETTER LEFT HALF RING"     },
            {         "\u055A", "՚", "&#1370;", "՚", "ARMENIAN APOSTROPHE"    },
            {         "\u055B", "՛", "&#1371;", "՛", "ARMENIAN EMPHASIS MARK"    },
            {         "\u055C", "", "&#1372;", "՜", "ARMENIAN EXCLAMATION MARK"    },
            {         "\u055D", ",", "&#1373;", "՝", "ARMENIAN COMMA"    },
            {         "\u055E", "?", "&#1374;", "՞", "ARMENIAN QUESTION MARK"    },
            {         "\u055F", "", "&#1375;", "՟", "ARMENIAN ABBREVIATION MARK"    },

            {         "\u0561", "a", "&#1377;", "ա", "ARMENIAN SMALL LETTER AYB"    },
            {         "\u0562", "b", "&#1378;", "բ", "ARMENIAN SMALL LETTER BEN"    },
            {         "\u0563", "g", "&#1379;", "գ", "ARMENIAN SMALL LETTER GIM"    },
            {         "\u0564", "d", "&#1380;", "դ", "ARMENIAN SMALL LETTER DA"    },
            {         "\u0565", "je", "&#1381;", "ե", "ARMENIAN SMALL LETTER ECH"    },
            {         "\u0566", "z", "&#1382;", "զ", "ARMENIAN SMALL LETTER ZA"    },
            {         "\u0567", "e", "&#1383;", "է", "ARMENIAN SMALL LETTER EH"    },
            {         "\u0568", "ö", "&#1384;", "ը", "ARMENIAN SMALL LETTER ET"    },
            {         "\u0569", "t", "&#1385;", "թ", "ARMENIAN SMALL LETTER TO"    },
            {         "\u056A", "schz", "&#1386;", "ժ", "ARMENIAN SMALL LETTER ZHE"    },
            {         "\u056B", "i", "&#1387;", "ի", "ARMENIAN SMALL LETTER INI"    },
            {         "\u056C", "l", "&#1388;", "լ", "ARMENIAN SMALL LETTER LIWN"    },
            {         "\u056D", "ch", "&#1389;", "խ", "ARMENIAN SMALL LETTER XEH"    },
            {         "\u056E", "ts", "&#1390;", "ծ", "ARMENIAN SMALL LETTER CA"    },
            {         "\u056F", "k", "&#1391;", "կ", "ARMENIAN SMALL LETTER KEN"    },

            {         "\u0570", "h", "&#1392;", "հ", "ARMENIAN SMALL LETTER HO"    },
            {         "\u0571", "dz", "&#1393;", "ձ", "ARMENIAN SMALL LETTER JA"    },
            {         "\u0572", "r", "&#1394;", "ղ", "ARMENIAN SMALL LETTER GHAD"    },
            {         "\u0573", "dtsch", "&#1395;", "ճ", "ARMENIAN SMALL LETTER CHEH"    },
            {         "\u0574", "m", "&#1396;", "մ", "ARMENIAN SMALL LETTER MEN"    },
            {         "\u0575", "j", "&#1397;", "յ", "ARMENIAN SMALL LETTER YI"    },
            {         "\u0576", "n", "&#1398;", "ն", "ARMENIAN SMALL LETTER NOW"    },
            {         "\u0577", "sch", "&#1399;", "շ", "ARMENIAN SMALL LETTER SHA"    },
            {         "\u0578", "o", "&#1400;", "ո", "ARMENIAN SMALL LETTER VO"    },
            {         "\u0579", "tsch", "&#1401;", "չ", "ARMENIAN SMALL LETTER CHA"    },
            {         "\u057A", "p", "&#1402;", "պ", "ARMENIAN SMALL LETTER PEH"    },
            {         "\u057B", "dsch", "&#1403;", "ջ", "ARMENIAN SMALL LETTER JHEH"    },
            {         "\u057C", "r", "&#1404;", "ռ", "ARMENIAN SMALL LETTER RA"    },
            {         "\u057D", "ss", "&#1405;", "ս", "ARMENIAN SMALL LETTER SEH"    },
            {         "\u057E", "w", "&#1406;", "վ", "ARMENIAN SMALL LETTER VEW"    },
            {         "\u057F", "dt", "&#1407;", "տ", "ARMENIAN SMALL LETTER TIWN"    },

            {         "\u0580", "r", "&#1408;", "ր", "ARMENIAN SMALL LETTER REH"    },
            {         "\u0581", "ts", "&#1409;", "ց", "ARMENIAN SMALL LETTER CO"    },
            {         "\u0582", "u", "&#1410;", "ւ", "ARMENIAN SMALL LETTER YIWN"    },
            {         "\u0583", "p", "&#1411;", "փ", "ARMENIAN SMALL LETTER PIWR"    },
            {         "\u0584", "k", "&#1412;", "ք", "ARMENIAN SMALL LETTER KEH"    },
            {         "\u0585", "o", "&#1413;", "օ", "ARMENIAN SMALL LETTER OH"    },
            {         "\u0586", "v", "&#1414;", "ֆ", "ARMENIAN SMALL LETTER FEH"    },
            {         "\u0587", "u", "&#1415;", "և", "ARMENIAN SMALL LIGATURE ECH YIWN"    },
            {         "\u0589", ".", "&#1417;", "։", "ARMENIAN FULL STOP"    },
            {         "\u058A", "֊", "&#1418;", "֊", "ARMENIAN HYPHEN"    },
            {         "\u058F", "O", "&#1423;", "֏", "ARMENIAN DRAM SIGN"    },
    };

    public static Map<String, CharacterInfo> newCharacterInfoMap(){
        Map<String, CharacterInfo> characterInfoMap = new LinkedHashMap<>();
        String[][] alphabet = ArmenianAlphabet.alphabet;
        Arrays.stream(alphabet).forEach(entry -> characterInfoMap.put(entry[0], newCharacterInfo(entry)));
        return characterInfoMap;
    }

    public static CharacterInfo newCharacterInfo(String[] characterInfoArray) {
        return CharacterInfo.builder()
                .unicode(characterInfoArray[0])
                .latin(characterInfoArray[1])
                .htmlEntity(characterInfoArray[2])
                .representation(characterInfoArray[3])
                .description(characterInfoArray[4])
                .build();
    }
}
