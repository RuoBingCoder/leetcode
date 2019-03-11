package sorts;

import static sorts.SortUtils.*;

/**
 * Implementation of gnome sort
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @since 2018-04-10
 * <p>
 * 侏儒排序（英语：Gnome Sort）或愚人排序（英语：Stupid Sort）是一种排序算法
 * ，最初在2000年由伊朗计算机工程师Hamid Sarbazi-Azad（谢里夫理工大学计算机工程教授）提出，
 * 他称之为“愚人排序”[1]。此后Dick Grune也描述了这一算法，称其为“侏儒排序”[2]。此算法类似于插入排序
 * ，但是移动元素到它该去的位置是通过一系列类似冒泡排序的移动实现的
 * 。从概念上讲侏儒排序非常简单，甚至不需要嵌套循环。它的平均运行时间是O(n2)，如果列表已经排序好则只需O(n)的运行时间。[3
 **/
public class GnomeSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int i = 1;
        int j = 2;
        while (i < arr.length) {
            if (less(arr[i - 1], arr[i])) i = j++;
            else {
                swap(arr, i - 1, i);
                if (--i == 0) {
                    i = j++;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 26, 11, 23, 0, -6, 3, 54, 231, 9, 12};
        String[] strings = {"c", "a", "e", "b", "d", "dd", "da", "zz", "AA", "aa", "aB", "Hb", "Z"};
        GnomeSort gnomeSort = new GnomeSort();

        gnomeSort.sort(integers);
        gnomeSort.sort(strings);

        System.out.println("After sort : ");
        print(integers);
        print(strings);


    }

}
