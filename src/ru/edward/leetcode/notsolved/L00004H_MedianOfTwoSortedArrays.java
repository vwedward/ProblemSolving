/*
 * ©Edward, 2026
 */

package ru.edward.leetcode.notsolved;

public class L00004H_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. Гарантируем, что первый массив — меньший (для эффективности)
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        // +1 чтобы левая половина была больше или равна правой при нечётном общем количестве элементов
        int totalLeft = (m + n + 1) / 2; // сколько элементов должно быть в левой половине

        // 2. Бинарный поиск по массиву nums1
        int left = 0;
        int right = m;

        while (left <= right) {
            // Количество элементов, взятых из nums1 в левую половину
            int cut1 = (left + right) / 2;
            // Остальные элементы в левую половину добираем из nums2
            int cut2 = totalLeft - cut1;

            // 3. Определяем элементы слева и справа от разреза
            // Используем Integer.MIN_VALUE и Integer.MAX_VALUE для граничных случаев
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // 4. Проверяем, правильный ли разрез
            if (left1 <= right2 && left2 <= right1) {
                // Нашли правильный разрез!
                if ((m + n) % 2 == 1) {
                    // Нечётное количество элементов — медиана это максимум левой половины
                    return Math.max(left1, left2);
                } else {
                    // Чётное — среднее арифметическое двух центральных элементов
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            } else if (left1 > right2) {
                // Слишком много элементов взяли из nums1 → смещаем разрез влево
                right = cut1 - 1;
            } else {
                // left2 > right1 → слишком мало элементов из nums1 → смещаем вправо
                left = cut1 + 1;
            }
        }

        // Теоретически сюда мы не должны попасть при корректных входных данных
        return 0.0;
    }

    /*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Left = 0;
        int nums1Right = nums1.length - 1;
        int nums1Length = nums1Right - nums1Left + 1;

        int nums2Left = 0;
        int nums2Right = nums2.length - 1;
        int nums2Length = nums2Right - nums2Left + 1;

        // В цикле, до тех пор пока суммарное кол-во элементов не станет равным 1 или 2
        while (nums1Length + nums2Length > 2) {
            // Индексы средних элементов
            int nums1Middle = nums1Right/2;
            int nums2Middle = nums2Right/2;
            // Сравниваем средние элементы в nums1 и nums2 и выкидываем дальние друг от друга части
            if (nums1[nums1Middle] < nums2[nums2Middle]) {


                // Если есть что обрезать в nums1, обрезаем и пересчитываем длину
                if (nums1Length > 1) {
                    nums1Left = nums1Right - nums1Left
                    nums1Length = nums1Right - nums1Left + 1;
                }



            }

        }

        return null;
    }*/
}
