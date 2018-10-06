import java.util.Comparator;
/**
 * Class for merge sort.
 *
 * @param      <T>   { parameter_description }
 */
class MergeSort<T> {
    /**
     * auxiliary array.
     */
    private  T[] aux;
    /**
     * sort method
     *
     * @param      a     { array }
     * @param      cp    { comparator variable }
     */
    public  void sort(final T[] a, final Comparator<T> cp) {
        aux = (T[]) new Object[a.length];
        sort(a, 0, a.length - 1, cp);
    }
    /**
     * merge method.
     *
     * @param      a     { array }
     * @param      lo    The lower
     * @param      mid   The middle
     * @param      hi    The higher
     * @param      cp    { comparator variable }
     */
    private void merge(final T[] a, final int lo, final int mid, final int hi, final Comparator<T> cp) {
        int i = lo, j = mid + 1;
        
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi )              a[k] = aux[i++];
            else if (less(aux[j], aux[i], cp)) a[k] = aux[j++];
            else                           a[k] = aux[i++];
    }
    /**
     * less method.
     *
     * @param      a     { variable}
     * @param      b     { variable }
     * @param      cp    {comparator variable }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean less(T a, T b, Comparator<T> cp) {
        return cp.compare(a,b) < 0;
    }
    /**
     * sort method.
     *
     * @param      a     { array }
     * @param      lo    The lower
     * @param      hi    The higher
     * @param      cp    { comparator variable}
     */
    private void sort(T[] a, int lo, int hi, Comparator<T> cp) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid, cp);
        sort(a, mid + 1, hi, cp);
        merge(a, lo, mid, hi, cp);
    }
}
