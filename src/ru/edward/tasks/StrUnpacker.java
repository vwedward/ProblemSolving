/*
 * ©Edward, 2021
 */

/*
Тестовое задание
Создал: Эдуард Шестериков
e-mail: vwedward@mail.ru
Дата 18.03.2021

Условие:
Написать на Java программу распаковывания строки. На вход поступает строка вида число[строка], на выход - строка, содержащая повторяющиеся подстроки.

Пример:
Вход: 3[xyz]4[xy]z
Выход: xyzxyzxyzxyxyxyxyz

Ограничения:
- одно повторение может содержать другое. Например: 2[3[x]y]  = xxxyxxxy
- допустимые символы на вход: латинские буквы, числа и скобки []
- числа означают только число повторений
- скобки только для обозначения повторяющихся подстрок
- входная строка всегда валидна.

Дополнительное задание:
Проверить входную строку на валидность.
*/

package ru.edward.tasks;

public class StrUnpacker {

    //Функция для распаковки строки (рекурсия)
    //Входной параметр - исходная строка. Возвращает распакованную строку
    public static String unpackStr(String SourceStr) {

        int CurIdx = 0; //Текущая позиция символа в исходной строке
        String ResultStr = ""; // Накопитель результата
        int BegIdx; //Позиция с которой начался поиск цифры
        int DigIdx; //Позиция цифры
        int OpIdx; //Позиция открывающейся скобки
        int ClIdx; //Позиция закрывающейся скобки
        int Mult; //Собственно цифра - множитель
        int Lvl; //Уровень вложенности скобок
        String Substr; //содержимое скобок

        //Проходим по каждому символу строки
        while (CurIdx < SourceStr.length()) {

            //Ищем цифру
            BegIdx = CurIdx;
            DigIdx = -1;
            while (CurIdx < SourceStr.length()) {
                if (Character.isDigit(SourceStr.charAt(CurIdx))) {
                    DigIdx = CurIdx;
                    break;
                }
                CurIdx++;
            }

            if (DigIdx == -1) {
                //Если цифру не нашли, значит преобразовывать дальше нечего
                ResultStr = ResultStr.concat(SourceStr.substring(BegIdx));
            } else {
                //Текст до цифры не преобразовываем
                ResultStr = ResultStr.concat(SourceStr.substring(BegIdx, DigIdx));
                //Ищем скобку "["
                OpIdx = SourceStr.indexOf("[", DigIdx);
                //Определяем множитель повторений (он может иметь несколько разрядов)
                Mult = Integer.parseInt(SourceStr.substring(DigIdx, OpIdx));
                //После скобки "[" ищем парную ей скобку ']'
                CurIdx = OpIdx + 1;
                ClIdx = -1;
                Lvl = 1;
                while (CurIdx < SourceStr.length()) {
                    if (SourceStr.charAt(CurIdx) == '[') {
                        //Углубляемся на один уровень
                        Lvl++;
                    } else if ((SourceStr.charAt(CurIdx) == ']') & (Lvl > 1)) {
                        //Возвращаемся на один уровень
                        Lvl--;
                    } else if (SourceStr.charAt(CurIdx) == ']') {
                        //Нашли что искали
                        ClIdx = CurIdx;
                        break;
                    }
                    CurIdx++;
                }
                //Выделяем содержимое в скобках, рекурсивно преобразовываем и дублируем
                Substr = unpackStr(SourceStr.substring(OpIdx + 1, ClIdx));
                for (int i = 1; i <= Mult; i++) {
                    ResultStr = ResultStr.concat(Substr);
                }
                CurIdx = ClIdx + 1;
            }
        }
        return ResultStr;
    }

    //Функция валидации строки (доп. задание)
    //Входной параметр - исходная строка. Возвращает true если строка прошла проверку
    public static boolean ValidateStr(String SourceStr) {
        //Проверяем парность скобок и порядок их расположения
        int Lvl = 0;
        for (int i = 0; i < SourceStr.length(); i++) {
            if (SourceStr.charAt(i) == '[') {
                //Новый уровень скобок
                Lvl++;
            } else if (SourceStr.charAt(i) == ']') {
                if (Lvl == 0) {
                    System.out.print("Исходная строка не соотвествует заданному формату. В позиции " + (i + 1) +
                            " найден символ \"[\" при отсутствии предшествующего парного символа \"[\"");
                    return false;
                } else {
                    //Возвращаемся на один уровень
                    Lvl--;
                }
            }
        }
        if (Lvl != 0) {
            System.out.print("Исходная строка не соотвествует заданному формату. Отсутствует один или более символов \"]\"" +
                    ", соответствующих предшествующим символам \"[\"");
            return false;
        }

        int CurIdx = 0; //Текущая позиция символа в исходной строке
        //Проверяем правильность расположения цифр (только перед скобкой)
        while (CurIdx < SourceStr.length()) {
            if (Character.isDigit(SourceStr.charAt(CurIdx))) {
                //Следующие символы должны быть цифры завершающиеся "["
                CurIdx++;
                while (CurIdx < SourceStr.length()) {
                    if (SourceStr.charAt(CurIdx) == '[') {
                        //Нашли скобку после цифры - всё в порядке
                        break;
                    } else if (!Character.isDigit(SourceStr.charAt(CurIdx))) {
                        System.out.print("Исходная строка не соотвествует заданному формату. В позиции " + (CurIdx + 1) +
                                " найден недопустимый символ (отличный от цифры и \"[\")");
                        return false;
                    }
                    CurIdx++;
                }
            }
            CurIdx++;
        }
        return true;
    }

    public static void main(String[] args) {
        String SourceStr = "3[xyz1[q]]4[xy]z";
        if (ValidateStr(SourceStr)) {
            System.out.print(unpackStr(SourceStr));
        }
    }
}